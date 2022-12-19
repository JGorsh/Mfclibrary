package ru.mfc.mfcreference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mfc.mfcreference.entities.Office;
import ru.mfc.mfcreference.repository.OfficeRepository;

import java.util.List;
import java.util.Map;

@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    public Office save (Office office){
        return officeRepository.save(office);
    }

    public List<String> getAllOfficeName(){
        return officeRepository.findAllOfficeName();
    }
}
