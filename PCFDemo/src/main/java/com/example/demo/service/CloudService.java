package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cloud;
import com.example.demo.repository.CloudRepository;

@Service
public class CloudService {

	private CloudRepository cloudRepository;

	@Autowired
	public CloudService(CloudRepository cloudRepository) {
		super();
		this.cloudRepository = cloudRepository;
	}
	
	public Cloud getByCloudNmae(String cloudName){
		return cloudRepository.findByCloudName(cloudName);
	}
	
	public Cloud getById(Integer id){
		return cloudRepository.findOne(id);
	}
	
	public List<Cloud> getAll(){
		return cloudRepository.findAll();
	}
	
	public  void saveCloud(Cloud cloud){
		  cloudRepository.save(cloud);
	}
	
	
}