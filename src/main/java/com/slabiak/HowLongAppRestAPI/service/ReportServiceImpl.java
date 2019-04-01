package com.slabiak.HowLongAppRestAPI.service;

import com.slabiak.HowLongAppRestAPI.exceptions.ReportNotFoundException;
import com.slabiak.HowLongAppRestAPI.model.Report;
import com.slabiak.HowLongAppRestAPI.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    ReportRepository reportRepository;

    @Override
    public Report addReport(Report report, int restaurantId) {
        report.setCreatedAt(new Date());
        report.setRestaurant(restaurantService.getRestaurantById(restaurantId));
        reportRepository.save(report);
        return report;
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public Report getReportById(int reportId) {
        Optional<Report> report = reportRepository.findById(reportId);
        if(report.isPresent()){
            return report.get();
        } else{
            throw new ReportNotFoundException(String.format("Report with id %d is not found.",reportId));
        }
    }
}
