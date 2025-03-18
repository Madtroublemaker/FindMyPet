package kz.kbtu.sf.findmypet.service;

import kz.kbtu.sf.findmypet.model.LostPetReport;

import java.util.List;
import java.util.Optional;

public interface LostPetReportService {
    List<LostPetReport> getAllReports();
    Optional<LostPetReport> getReportById(Long id);
    LostPetReport createReport(LostPetReport report);
    void deleteReport(Long id);
}
