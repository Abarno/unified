package com.unifiedDashboard.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifiedDashboard.model.JobReport;
import com.unifiedDashboard.model.ccTicket;
import com.unifiedDashboard.repository.ccTicketRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ccTicketController {
	
	@Autowired
	private ccTicketRepository ccTicketRepository;
	
	@GetMapping("/getCcTicket")
	public ResponseEntity<?> getCcTicket(){
		
		 List<ccTicket> result= ccTicketRepository.findAll();
		 return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	@PostMapping("/createCcTicket")
	
	public ResponseEntity<?> createCcTicket(@RequestBody ccTicket ccTicket){
		
		ccTicket ccTicket2=ccTicketRepository.save(ccTicket);
		return ResponseEntity.status(HttpStatus.OK).body(ccTicket2);
	}
	
	@PutMapping("/updateCcTicket/{id}")
	
	public ResponseEntity<?> updateCcTicket(@PathVariable(value="id") Integer id, @Valid @RequestBody ccTicket ccTicket){
		Optional<ccTicket> ccTicket2=ccTicketRepository.findById(id);
		ccTicket result=ccTicket2.get();
		result.setStatus(ccTicket.getStatus().toString());
		result.setJobReportId(ccTicket.getJobReportId());
		result.setOwner(ccTicket.getOwner());
		return ResponseEntity.status(HttpStatus.OK).body(ccTicketRepository.save(result));
	}
	
	@DeleteMapping("/deleteCcTicket/{id}")
	public ResponseEntity<?> deleteCcTicket(@PathVariable (value = "id") Integer id){
		ccTicketRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted with item id: "+id);
	}

}
