package ru.mfc.mfcreference.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ru.mfc.mfcreference.dto.UnitServiceDto;
import ru.mfc.mfcreference.entities.Office;

import java.util.*;

@Component
public class UpdateService {
    @Autowired
    private ObjectMapper mapper;

    @Value("${configs.oktmoListUrl}")
    private String oktmoListUrl;

    @Value("${configs.oktmoObjectListUrl}")
    private String oktmoObjectListUrl;

    @Value("${configs.servicesUrl}")
    private String servicesUrl;

    @Value("${configs.login}")
    private String login;

    @Value("${configs.password}")
    private String password;

    private Office office;

    private Map<String, Object> mapOfficeName = new HashMap<>();

    @Autowired
    OfficeService officeService;

    public List<String> getOktmoListId() throws JsonProcessingException {
        List<String> oktmoListId = new ArrayList<>();
        JsonNode node = mapper.readTree(getBodyResponse(oktmoListUrl)).get("_embedded").get("oktmoObjects");
        if (node.isArray()) {
            for (JsonNode objNode : node) {
                oktmoListId.add(objNode.get("id").asText());
            }
        }
        return oktmoListId;
    }

    public void saveOfficeList(List<String> oktmoListId) throws JsonProcessingException {
        for(String oktmoId : oktmoListId){
            String oktmoObjectListUrl1 = oktmoObjectListUrl + oktmoId + "/units";
            JsonNode node = mapper.readTree(getBodyResponse(oktmoObjectListUrl1)).get("_embedded").get("units");
            if (node.isArray()) {
                for (JsonNode objNode : node) {
                    String unitId = objNode.get("id").asText();
                    mapOfficeName.put("id", unitId );
                    mapOfficeName.put("name", objNode.get("name").asText());
                    mapOfficeName.put("email", objNode.get("email").asText());
                    mapOfficeName.put("phone", objNode.get("phone").asText());
                    mapOfficeName.put("latitude", objNode.get("latitude").asDouble());
                    mapOfficeName.put("longitude", objNode.get("longitude").asDouble());
                    mapOfficeName.put("shortName", objNode.get("shortName").asText());
                    mapOfficeName.put("workingHours", objNode.get("workingHours").asText());
                    mapOfficeName.put("legalAddressDescription", objNode.get("legalAddressDescription").asText());

                    Map<String, Object> mapService = new HashMap<>();
                    String servicesUrl1 = servicesUrl + unitId + "&preRecord=true";
                    JsonNode nodeUnitService = mapper.readTree(getBodyResponse(servicesUrl1));
                    mapService.put(String.valueOf(unitId),getUnitService(nodeUnitService));

                    office = officeService.getOfficeByOfficeId(unitId);
                    if(office==null){
                        office = new Office();
                        office.setOfficeId(unitId);
                    }

                    office.setOfficeName(mapOfficeName);
                    office.setOfficeService(mapService);
                    officeService.save(office);
                }
            }
        }
    }

    private List<UnitServiceDto> getUnitService(JsonNode node){
        List<UnitServiceDto> unitServiceDtoList = new ArrayList<>();
        if (node.isArray() ) {
            for (JsonNode objNode : node) {
                UnitServiceDto children = new UnitServiceDto();
                if(!objNode.get("children").isNull()){
                    JsonNode objNodeRec = objNode.get("children");
                    children.setChildren(getUnitService(objNodeRec));
                }
                if(!objNode.get("childrenGroups").isNull()){
                    JsonNode objNodeRec = objNode.get("childrenGroups");
                    children.setChildrenGroups(getUnitService(objNodeRec));
                }
                children.setId(objNode.get("id").asLong());
                children.setDescription(objNode.get("description").asText());
                children.setName(objNode.get("name").asText());
                unitServiceDtoList.add(children);
            }
        }
        return unitServiceDtoList;
    }

    private String getBodyResponse (String url){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(login, password);
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }
}
