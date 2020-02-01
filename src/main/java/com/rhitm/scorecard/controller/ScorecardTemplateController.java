package com.rhitm.scorecard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rhitm.scorecard.ResourceNotFoundException;
import com.rhitm.scorecard.domain.ScorecardTemplate;
import com.rhitm.scorecard.dto.create.ScorecardTemplateRequest;
import com.rhitm.scorecard.repository.ScorecardTemplateRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller for managing and retrieving scorecard templates.
 *
 */
@Api(consumes = "application/json", protocols = "http", description = "Operations for managing and retrieving scorecard templates")
@RestController
@RequestMapping("/scorecards/templates")
public class ScorecardTemplateController {
	
	@Autowired
	private ScorecardTemplateRepository templateRepository;
	
	@RequestMapping(method = RequestMethod.HEAD)
	public void healthCheck() {
		return;
	}
	
	/**
	 * Creates a scorecard template.
	 * <p>
	 * A scorecard template stores the basic information associated with the scorecard
	 * of a disc golf course. A player can create a new scorecard based on a template.
	 * </p>
	 * @param scorecardTemplate the scorecard template request
	 */
	@ApiOperation("Creates and persists a new scorecard template")
	@PostMapping(consumes = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String create(@RequestBody ScorecardTemplateRequest scorecardTemplateRequest) {
		
		ScorecardTemplate scorecardTemplate = new ScorecardTemplate();
		BeanUtils.copyProperties(scorecardTemplateRequest, scorecardTemplate);
		
		ScorecardTemplate savedTemplate = templateRepository.save(scorecardTemplate);
		
		return savedTemplate.getId();
	}
	
	/**
	 * Retrieves all scorecard templates
	 * <p>
	 * The results can be filtered with the following query string options
	 * <ul>
	 * 	<li>CourseName</li>
	 * </ul>
	 * 
	 * @return zero or more scorecard templates
	 */
	@ApiOperation("Retrieves all scorecard templates")
	@GetMapping(produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ScorecardTemplate> retrieveAllScorecardTemplates(@RequestParam(name = "CourseName", required = false) String courseName) {
		if(courseName == null) {
			return templateRepository.findAll();
		}
		return templateRepository.findByCourseName(courseName);
	}
	
	/**
	 * Retrieves a scorecard template
	 * @param templateId unique scorecard template identifier
	 * 
	 * @return a scorecard template or HTTP 404 if not found
	 */
	@ApiOperation("Retrieves a scorecard template")
	@GetMapping(value = "/{templateId}", produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public ScorecardTemplate retrieveScorecardTemplateById(@PathVariable("templateId") String templateId) {
		Optional<ScorecardTemplate> result = templateRepository.findById(templateId);
		if(result.isPresent()) {
			return result.get();
		}
		throw new ResourceNotFoundException(String.format("No scorecard template found. [templateId=%s]", templateId));
	}
	
}
