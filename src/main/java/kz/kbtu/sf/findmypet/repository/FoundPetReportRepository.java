package kz.kbtu.sf.findmypet.repository;

import kz.kbtu.sf.findmypet.model.FoundPetReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoundPetReportRepository extends JpaRepository<FoundPetReport, Long> {
}
