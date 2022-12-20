package ru.mfc.mfcreference.web;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mfc.mfcreference.dto.OfficeNameDto;
import ru.mfc.mfcreference.entities.Office;
import ru.mfc.mfcreference.service.OfficeService;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/refbook")
public class RefBookController {

    private static final Logger log = Logger.getLogger(RefBookController.class);

    @Autowired
    OfficeService officeService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(path = "/units")
    public Object resultsList(){
        List<Office> officeList = officeService.findAllOffice();
        List<Object> officeNameList = officeList.stream().map(p->p.getOfficeName()).collect(Collectors.toList());
        return officeNameList;
    }

    @GetMapping(path = "/service")
    public Object serviceList(@RequestParam() String officeId) {
        Office officeServiceResult = officeService.getOfficeByOfficeId(officeId);
        return officeServiceResult.getOfficeService();
    }
}
