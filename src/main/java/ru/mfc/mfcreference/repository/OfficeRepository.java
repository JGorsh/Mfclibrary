package ru.mfc.mfcreference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mfc.mfcreference.dto.OfficeNameDto;
import ru.mfc.mfcreference.entities.Office;
import java.util.List;


@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    @Query(value="SELECT * FROM office ", nativeQuery = true)
    List<Office> findAllOffice();

}