package com.rhitm.scorecard.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rhitm.scorecard.domain.ScorecardTemplate;

/**
 * Repository for managing and retrieving scorecard templates from a MongoDB instance.
 *
 */
@Repository
public interface ScorecardTemplateRepository extends MongoRepository<ScorecardTemplate, String> {
	
	/**
	 * Searches for scorecard templates by the course name.
	 * 
	 * @param courseName the course name (no wildcards)
	 * @return the matching scorecard template or null if not found
	 */
	public List<ScorecardTemplate> findByCourseName(String courseName);

}
