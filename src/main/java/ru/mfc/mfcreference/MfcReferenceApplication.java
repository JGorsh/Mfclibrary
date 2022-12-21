package ru.mfc.mfcreference;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.mfc.mfcreference.service.UpdateService;

@SpringBootApplication
public class MfcReferenceApplication {
    public static void main(String[] args) throws JsonProcessingException {

        SpringApplication.run(MfcReferenceApplication.class, args);
    }
}
