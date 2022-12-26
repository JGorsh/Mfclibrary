package ru.mfc.mfcreference.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mfc.mfcreference.entities.Office;
import ru.mfc.mfcreference.service.OfficeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/refbook")
public class RefBookController {

    @Autowired
    OfficeService officeService;

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
