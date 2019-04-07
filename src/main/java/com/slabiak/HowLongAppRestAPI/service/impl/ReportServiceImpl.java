package com.slabiak.HowLongAppRestAPI.service.impl;

import com.slabiak.HowLongAppRestAPI.exceptions.ReportNotFoundException;
import com.slabiak.HowLongAppRestAPI.model.Report;
import com.slabiak.HowLongAppRestAPI.model.Restaurant;
import com.slabiak.HowLongAppRestAPI.repository.ReportRepository;
import com.slabiak.HowLongAppRestAPI.service.ReportService;
import com.slabiak.HowLongAppRestAPI.service.RestaurantService;
import com.slabiak.HowLongAppRestAPI.util.HelperMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Report> getReportsByRestaurant(int restaunrantId) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaunrantId);
        return restaurant.getReports();
    }

    @Override
    public Report getReportById(int reportId) {
        Optional<Report> report = reportRepository.findById(reportId);
        if(report.isPresent()){
            return report.get();
        } else{
            throw new ReportNotFoundException(String.format("Raport z id %d nieznaleziony",reportId));
        }
    }

    @Override
    public void deleteExpiredReports() {
        List<Report> allReports = getAllReports();
        for(Report report : allReports){
            Date expire = HelperMethods.addMinutesToDate(60,report.getCreatedAt());
            Date now = new Date(System.currentTimeMillis());
            if(now.after(expire)){
                deleteReportById(report.getId());
            }
        }
    }

    @Override
    public void deleteReportById(int reportId) {
        reportRepository.deleteById(reportId);
    }

}
