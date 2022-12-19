package ru.mfc.mfcreference.repository;

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mfc.mfcreference.entities.Office;

import java.util.List;
import java.util.Map;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    @Query(value = "SELECT office_name FROM office", nativeQuery = true)
    public List<String> findAllOfficeName();

}
