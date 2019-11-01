package com.unifiedDashboard.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.text.Utilities;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifiedDashboard.model.JobReport;

import com.unifiedDashboard.repository.JobReportRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class JobReportController {
	
	@Autowired
	private JobReportRepository jobReportRepository;
	
	@GetMapping("/getJobReport")
	public ResponseEntity<?> getJobReport(){
		
		 List<JobReport> result= jobReportRepository.findAll();
		 return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@GetMapping("/getJobReportById/{id}")
	public ResponseEntity<?> getJobReportByid(@PathVariable(value="id") Integer id){
		
		return ResponseEntity.status(HttpStatus.OK).body(jobReportRepository.findById(id));
		
	}
	@PostMapping("/addJobReport")
	public JobReport addJobReport(@Valid @RequestBody JobReport jobReport){
		return jobReportRepository.save(jobReport);
		
	}
	@PutMapping("/updateJobReport/{id}")
	public JobReport updateJobReport(@PathVariable(value = "id") Integer id, @Valid @RequestBody JobReport jobReport) {
		Optional<JobReport> jobReport2=jobReportRepository.findById(id);
		JobReport result= jobReport2.get();
		result.setStatus(jobReport.getStatus().toString());
		result.setCcTicketId(jobReport.getCcTicketId().toString());
		return jobReportRepository.save(result);
		
	}

}
