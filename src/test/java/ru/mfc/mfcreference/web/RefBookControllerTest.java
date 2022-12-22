package ru.mfc.mfcreference.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RefBookController.class)
class RefBookControllerTest {

    @Test
    void resultsList() {
    }

    @Test
    void serviceList() {
    }
}