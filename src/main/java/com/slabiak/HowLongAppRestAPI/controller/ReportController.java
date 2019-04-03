package com.slabiak.HowLongAppRestAPI.controller;

import com.slabiak.HowLongAppRestAPI.model.Report;
import com.slabiak.HowLongAppRestAPI.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{restaurantId}/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping()
    public List<Report> getAllReportsForRestaurant(@PathVariable("restaurantId") int restaurantId){
        return reportService.getReportsByRestaurant(restaurantId);
    }

    @GetMapping("/{reportId}")
    public Report getReportById(@PathVariable("reportId") int reportId){
        return reportService.getReportById(reportId);
    }

    @PostMapping()
    public Report addReport(@RequestBody Report report,@PathVariable("restaurantId") int restaurantId){
        return reportService.addReport(report, restaurantId);
    }
}
