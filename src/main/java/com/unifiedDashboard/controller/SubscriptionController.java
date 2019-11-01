package com.unifiedDashboard.controller;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifiedDashboard.model.Subscription;
import com.unifiedDashboard.repository.SubscriptionRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@GetMapping("/getSubscription")
	public List<Subscription> getSubscription(){
		
		return (List<Subscription>) subscriptionRepository.findAll();
		
	}
	@GetMapping("/getSubscriptionById/{id}")
	public Optional<Subscription> getSubscriptionById(@PathVariable(value = "id")Integer id){
		
		return subscriptionRepository.findById(id);
		
	}
	@GetMapping("/getSubscription/{country}")
	public List<Subscription> getSubscription(@PathVariable(value = "country") String country){
		System.out.println(country);
		List <Subscription> subList = subscriptionRepository.findByCountry(country);
		return (List<Subscription>) subList;
	}
	
	@GetMapping("/getSubscriptionByOdinId/{odinId}")
	public List<Subscription> getSubscriptionByOdinId(@PathVariable(value = "odinId") String odinId){
		//System.out.println(country);
		List <Subscription> subList = subscriptionRepository.findByOdinId(odinId);
		return (List<Subscription>) subList;
	}
	
	@DeleteMapping("/deleteSubscription/{id}")
	public String deleteSubscription(@PathVariable(value = "id")Integer id) {
		subscriptionRepository.deleteById(id);
		return "deleted";
	}
	
}
