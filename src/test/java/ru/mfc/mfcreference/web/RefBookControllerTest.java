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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(RefBookController.class)
@ExtendWith(MockitoExtension.class)
class RefBookControllerTest {

    @MockBean
    OfficeService officeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test findAllOffice()")
    void resultsList() {
        when(officeService.findAllOffice()).thenReturn(Arrays.asList(new Office()));
        mockMvc.perform(get("/units")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService,times(1)).findAll();
    }

    @Test
    void serviceList() {
    }
}