package com.slabiak.HowLongAppRestAPI.controller;

import com.slabiak.HowLongAppRestAPI.model.Report;
import com.slabiak.HowLongAppRestAPI.model.Restaurant;
import com.slabiak.HowLongAppRestAPI.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    ReportService reportService;


    @GetMapping()
    public List<Report> getAllRestaurants(){
        return reportService.getAllReports();
    }

    @GetMapping("/{reportId}")
    public Report getReportById(@PathVariable("reportId") int reportId){
        return reportService.getReportById(reportId);
    }

    @PostMapping()
    public Report addReport(@RequestParam("restaurant_id")int restaurantId, @RequestParam("waiting_time") int waitingTime, @RequestParam("created_by") String createdBy){
        return reportService.addReport(restaurantId,waitingTime,createdBy);
    }
}
