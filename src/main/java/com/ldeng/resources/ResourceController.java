package com.ldeng.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ldeng.domain.Journal;
import com.ldeng.service.JournalService;

@RestController
public class ResourceController {
	
	@Autowired
	private JournalService journalService;

	@RequestMapping("/journal/all")
	public List<Journal> getAllJournals(){
		return journalService.findAll();
	}
	
	@RequestMapping("/journal/{id}")
	public Journal getJournal(@PathVariable long id){
		return journalService.findOne(id);
	}
	
	@RequestMapping(value = "/journal", method=RequestMethod.POST)
	public void create(@RequestBody Journal journal){
		journalService.create(journal);
	}
	
	@RequestMapping(value = "/journal/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable long id){
		journalService.delete(id); 
	}
}
