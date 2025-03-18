package kz.kbtu.sf.findmypet.repository;

import kz.kbtu.sf.findmypet.model.LostPetReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostPetReportRepository extends JpaRepository<LostPetReport, Long> {
}
