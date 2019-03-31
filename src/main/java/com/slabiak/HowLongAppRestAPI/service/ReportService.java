package com.slabiak.HowLongAppRestAPI.service;

import com.slabiak.HowLongAppRestAPI.model.Report;

import java.util.List;

public interface ReportService {
    Report addReport(int restaurantId, int waitingTime, String createdBy);
    List<Report> getAllReports();
    Report getReportById(int reportId);

}
