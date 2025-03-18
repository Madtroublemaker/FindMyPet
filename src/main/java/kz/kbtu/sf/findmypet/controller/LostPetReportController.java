package kz.kbtu.sf.findmypet.controller;

import kz.kbtu.sf.findmypet.model.LostPetReport;
import kz.kbtu.sf.findmypet.service.LostPetReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lost-pets")
public class LostPetReportController {

    @Autowired
    private LostPetReportService lostPetReportService;

    @GetMapping
    public List<LostPetReport> getAllReports() {
        return lostPetReportService.getAllReports();
    }

    @GetMapping("/{id}")
    public Optional<LostPetReport> getReportById(@PathVariable Long id) {
        return lostPetReportService.getReportById(id);
    }

    @PostMapping
    public LostPetReport createReport(@RequestBody LostPetReport report) {
        return lostPetReportService.createReport(report);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        lostPetReportService.deleteReport(id);
    }
}