package com.ldeng.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ldeng.domain.Journal;
import com.ldeng.repository.JournalRepository;

@Service
public class JournalService {
	private static final Logger Log = LoggerFactory.getLogger(JournalService.class);
	
	@Autowired
	private JournalRepository repo;
	
	public void createDummyData() throws ParseException{
		Journal journal1 = new Journal("Get to know Spring Boot","Today I will learn Spring Boot", "01/01/2016");
		Journal journal2 = new Journal("Simple Spring Boot Project","I will do my first Spring Boot project", "01/02/2016");
		Journal journal3 = new Journal("Spring Boot Reading","Read more about Spring Boot", "01/02/2016");
		Journal journal4 = new Journal("Spring Boot in the Cloud","Learn Spring Boot using Cloud Foundry", "01/01/2016");
		
		repo.delete(repo.findByTitle("Get to know Spring Boot"));

		Log.info("Here is journal4 info {}",repo.findOne(repo.findByTitle("Spring Boot in the Cloud").getId()));
		
		journal3.setTitle("Update Title");
		repo.save(journal3);
		Log.info("Here is journal3 info {}",repo.findOne(repo.findByTitle("Spring Boot Reading").getId()));
		
	}
	
	public List<Journal> findAll(){
		return (List<Journal>) repo.findAll();
	}
	
	public Journal findByTitle (String title){
		return repo.findByTitle(title);
	}
	
	public Journal findOne (long id){
		return (Journal) repo.findOne(id);
	}
	
	public void create(Journal journal){
		repo.save(journal);
	}
	
	public void delete(long id){
		repo.delete(id);;
	}
}
