package ru.mfc.mfcreference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mfc.mfcreference.entities.Office;
import ru.mfc.mfcreference.repository.OfficeRepository;

import java.util.List;


@Service
public class OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    public Office save (Office office){
        return officeRepository.save(office);
    }

    public List<Office> findAllOffice() {
        return officeRepository.findAllOffice();
    }

    public Office getOfficeByOfficeId(String officeId){
        return officeRepository.getOfficeByOfficeId(officeId);
    }

}
