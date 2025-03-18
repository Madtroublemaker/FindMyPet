package kz.kbtu.sf.findmypet.serviceImpl;

import kz.kbtu.sf.findmypet.model.LostPetReport;
import kz.kbtu.sf.findmypet.repository.LostPetReportRepository;
import kz.kbtu.sf.findmypet.service.LostPetReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LostPetReportServiceImpl implements LostPetReportService {

    @Autowired
    private LostPetReportRepository lostPetReportRepository;

    @Override
    public List<LostPetReport> getAllReports() {
        return lostPetReportRepository.findAll();
    }

    @Override
    public Optional<LostPetReport> getReportById(Long id) {
        return lostPetReportRepository.findById(id);
    }

    @Override
    public LostPetReport createReport(LostPetReport report) {
        return lostPetReportRepository.save(report);
    }

    @Override
    public void deleteReport(Long id) {
        lostPetReportRepository.deleteById(id);
    }
}