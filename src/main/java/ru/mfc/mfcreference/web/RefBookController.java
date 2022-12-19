package ru.mfc.mfcreference.web;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mfc.mfcreference.dto.OfficeNameDto;
import ru.mfc.mfcreference.entities.Office;
import ru.mfc.mfcreference.service.OfficeService;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/refbook")
public class RefBookController {

    @Autowired
    OfficeService officeService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(path = "/units")
    public List<Office> resultsList() {
        //List<Office> officeList = officeService.findAllOffice();
        //List<OfficeNameDto> officeNameDtoList = officeList.stream().map(p->p.getOfficeName()).collect(Collectors.toList());
        return officeService.findAllOffice();
    }
//    @GetMapping(path = "/service")
//    public Result<?> resultsList(@RequestParam() Integer page, @RequestParam() Integer pageSize) {
//        Page<AdvertisingResult> data = advertisingService.getAdvertisingResults(page, pageSize);
//        return new Result<>(data);
//    }
}
