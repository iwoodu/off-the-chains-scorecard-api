package com.rhitm.scorecard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhitm.scorecard.domain.ScorecardTemplate;
import com.rhitm.scorecard.dto.create.ScorecardTemplateRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller for managing and retrieving scorecard templates.
 *
 */
@Api(consumes = "application/json", protocols = "http", description = "Operations for managing and retrieving scorecard templates")
@RestController
@RequestMapping("/scorecard")
public class ScorecardTemplateController {
	
    @Lookup
    public ScorecardTemplate getScorecardTemplate() {
        return null;
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
	@PostMapping(value="/templates", consumes = "application/json")
	public ResponseEntity create(@RequestBody ScorecardTemplateRequest scorecardTemplateRequest) {
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
