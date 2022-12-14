package ru.mfc.mfcreference.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mfc.mfcreference.service.OfficeService;

@RestController
@RequestMapping(value = "/api/library")
public class RefBookController {

//    @Autowired
//    OfficeService officeService;
//    @GetMapping(path = "/unit")
//    public Result<?> resultsList(@RequestParam() Integer page, @RequestParam() Integer pageSize) {
//        Page<AdvertisingResult> data = advertisingService.getAdvertisingResults(page, pageSize);
//        return new Result<>(data);
//    }
//    @GetMapping(path = "/service")
//    public Result<?> resultsList(@RequestParam() Integer page, @RequestParam() Integer pageSize) {
//        Page<AdvertisingResult> data = advertisingService.getAdvertisingResults(page, pageSize);
//        return new Result<>(data);
//    }
}
