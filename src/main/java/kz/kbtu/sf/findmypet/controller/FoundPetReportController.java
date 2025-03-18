package kz.kbtu.sf.findmypet.controller;

import kz.kbtu.sf.findmypet.model.FoundPetReport;
import kz.kbtu.sf.findmypet.service.FoundPetReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/found-pets")
public class FoundPetReportController {

    @Autowired
    private FoundPetReportService foundPetReportService;

    @GetMapping
    public List<FoundPetReport> getAllReports() {
        return foundPetReportService.getAllReports();
    }

    @GetMapping("/{id}")
    public Optional<FoundPetReport> getReportById(@PathVariable Long id) {
        return foundPetReportService.getReportById(id);
    }

    @PostMapping
    public FoundPetReport createReport(@RequestBody FoundPetReport report) {
        return foundPetReportService.createReport(report);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        foundPetReportService.deleteReport(id);
    }
}
