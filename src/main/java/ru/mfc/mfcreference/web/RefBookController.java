package ru.mfc.mfcreference.web;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mfc.mfcreference.service.OfficeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/refbook")
public class RefBookController {

    @Autowired
    OfficeService officeService;

    @Autowired
    ObjectMapper objectMapper;

//    @GetMapping(path = "/units")
//    public List<String> resultsList() {
//        List<String> officeName;
//        officeName = objectMapper.readValue(officeService.getAllOfficeName(), new TypeReference<List<String>>);
//        return officeName;
//    }
//    @GetMapping(path = "/service")
//    public Result<?> resultsList(@RequestParam() Integer page, @RequestParam() Integer pageSize) {
//        Page<AdvertisingResult> data = advertisingService.getAdvertisingResults(page, pageSize);
//        return new Result<>(data);
//    }
}
