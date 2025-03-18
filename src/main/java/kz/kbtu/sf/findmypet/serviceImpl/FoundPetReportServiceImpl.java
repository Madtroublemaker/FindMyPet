package kz.kbtu.sf.findmypet.serviceImpl;

import kz.kbtu.sf.findmypet.model.FoundPetReport;
import kz.kbtu.sf.findmypet.repository.FoundPetReportRepository;
import kz.kbtu.sf.findmypet.service.FoundPetReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoundPetReportServiceImpl implements FoundPetReportService {

    @Autowired
    private FoundPetReportRepository foundPetReportRepository;

    @Override
    public List<FoundPetReport> getAllReports() {
        return foundPetReportRepository.findAll();
    }

    @Override
    public Optional<FoundPetReport> getReportById(Long id) {
        return foundPetReportRepository.findById(id);
    }

    @Override
    public FoundPetReport createReport(FoundPetReport report) {
        return foundPetReportRepository.save(report);
    }

    @Override
    public void deleteReport(Long id) {
        foundPetReportRepository.deleteById(id);
    }
}

