package com.unifiedDashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifiedDashboard.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByEmail(String email);

}
