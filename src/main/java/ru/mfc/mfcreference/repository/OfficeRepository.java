package ru.mfc.mfcreference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mfc.mfcreference.entities.Office;


@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
}
