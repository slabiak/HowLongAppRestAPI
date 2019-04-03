package com.slabiak.HowLongAppRestAPI.service.impl;

import com.slabiak.HowLongAppRestAPI.service.ReportService;
import com.slabiak.HowLongAppRestAPI.service.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledServiceImpl implements ScheduledService {

    @Autowired
    ReportService reportService;

    // run every 5 minute
    @Override
    @Scheduled(fixedDelay = 5*60*1000)
    public void deleteExpiredReports() {
        reportService.deleteExpiredReports();
    }
}
