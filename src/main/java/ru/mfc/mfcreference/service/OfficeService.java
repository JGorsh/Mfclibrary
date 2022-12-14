package ru.mfc.mfcreference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mfc.mfcreference.entities.Office;
import ru.mfc.mfcreference.repository.OfficeRepository;

@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    public Office save (Office office){
        return officeRepository.save(office);
    }
}
