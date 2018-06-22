package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Cloud;


@Repository
public interface CloudRepository extends JpaRepository<Cloud, Integer> {

	Cloud findByCloudName(String cloudName);
	
}