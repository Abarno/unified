package com.unifiedDashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unifiedDashboard.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
	List<Subscription> findByCountry(String country);
	List<Subscription> findByOdinId(String odin_id);

}
