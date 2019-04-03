package com.slabiak.HowLongAppRestAPI.service;

import com.slabiak.HowLongAppRestAPI.model.Report;

import java.util.List;

public interface ReportService {
    Report addReport(Report report, int restaurantId);
    List<Report> getAllReports();
    Report getReportById(int reportId);
    void deleteExpiredReports();
    void deleteReportById(int reportId);

}
