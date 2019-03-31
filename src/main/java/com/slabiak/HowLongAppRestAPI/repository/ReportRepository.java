package com.slabiak.HowLongAppRestAPI.repository;

import com.slabiak.HowLongAppRestAPI.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Integer> {
}
