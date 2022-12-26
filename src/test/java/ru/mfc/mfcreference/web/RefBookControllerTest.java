package ru.mfc.mfcreference.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@WebMvcTest(RefBookController.class)
@ExtendWith(MockitoExtension.class)
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