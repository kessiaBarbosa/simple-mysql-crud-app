package com.ldeng.repository;

import org.springframework.data.repository.CrudRepository;

import com.ldeng.domain.Journal;

public interface JournalRepository extends CrudRepository<Journal, Long>{
	
	Journal findByTitle(String title);

}
