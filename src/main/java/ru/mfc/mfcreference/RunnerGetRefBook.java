package ru.mfc.mfcreference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.mfc.mfcreference.service.UpdateService;

@Component
public class RunnerGetRefBook implements CommandLineRunner {

    @Autowired
    UpdateService updateService;
    @Override
    public void run(String... args) throws Exception {
        updateService.saveOfficeList(updateService.getOktmoListId());
    }
}
