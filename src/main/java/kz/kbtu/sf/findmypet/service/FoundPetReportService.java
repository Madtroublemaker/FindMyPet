package kz.kbtu.sf.findmypet.service;

import kz.kbtu.sf.findmypet.model.FoundPetReport;

import java.util.List;
import java.util.Optional;

public interface FoundPetReportService {
    List<FoundPetReport> getAllReports();
    Optional<FoundPetReport> getReportById(Long id);
    FoundPetReport createReport(FoundPetReport report);
    void deleteReport(Long id);
}