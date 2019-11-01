package com.unifiedDashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifiedDashboard.model.JobReport;

public interface JobReportRepository extends JpaRepository<JobReport, Integer> {

}
