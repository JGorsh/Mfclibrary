package ru.mfc.mfcreference.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RefBookControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void resultsList() {
    }

    @Test
    void serviceList() {
    }
}