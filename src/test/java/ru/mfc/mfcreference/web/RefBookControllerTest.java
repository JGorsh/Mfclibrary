package ru.mfc.mfcreference.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.mfc.mfcreference.entities.Office;
import ru.mfc.mfcreference.service.OfficeService;
import org.springframework.http.MediaType;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RefBookController.class)
@ExtendWith(MockitoExtension.class)
class RefBookControllerTest {

    @MockBean
    OfficeService officeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test findAllOffice()")
    void resultsList() throws Exception {
        when(officeService.findAllOffice()).thenReturn(Arrays.asList(new Office()));
        mockMvc.perform(get("/api/refbook/units")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(officeService,times(1)).findAllOffice();
    }

    @Test
    void serviceList() {
    }
}