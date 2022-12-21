package ru.mfc.mfcreference.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mfc.mfcreference.web.RefBookController;

@Component
@EnableAsync
@EnableScheduling
public class ScheduleTaskService {

    private static final Logger log = Logger.getLogger(RefBookController.class);

    @Autowired
    UpdateService updateService;

    @Async
    //@Scheduled(cron = "${configs.cron}")
    @Scheduled(fixedRate = 60000)
    public void runScheduleTask() throws JsonProcessingException {
        updateService.saveOfficeList(updateService.getOktmoListId());
        log.debug("Scheduled complete!");
    }
}
