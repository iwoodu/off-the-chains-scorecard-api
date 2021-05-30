package com.rhitm.scorecard.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import com.rhitm.scorecard.ResourceNotFoundException;
import com.rhitm.scorecard.domain.ScorecardTemplate;
import com.rhitm.scorecard.domain.ScorecardTemplateMetadata;
import com.rhitm.scorecard.dto.create.ScorecardTemplateRequest;
import com.rhitm.scorecard.repository.ScorecardTemplateRepository;
import com.rhitm.scorecard.util.ScorecardBeanUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for retrieving basic scorecard template data and metadata.
 *
 */
@RestController
@RequestMapping("/scorecards/metadata/templates")
public class ScorecardTemplateMetadataController {
	
	@Autowired
	private ScorecardTemplateRepository templateRepository;
	
	/**
	 * Retrieves basic information for all scorecard templates and its metadata.
	 * 
	 * @return zero or more scorecard templates
	 */
	@GetMapping(produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ScorecardTemplateMetadata> retrieveAllScorecardTemplatesMetadata() {
		List<ScorecardTemplateMetadata> scorecardTemplatesMetadata = new ArrayList<>();
		for(ScorecardTemplate scorecardTemplate : templateRepository.findAll()) {
			ScorecardTemplateMetadata scorecardTemplateMetadata = new ScorecardTemplateMetadata();
			BeanUtils.copyProperties(scorecardTemplate, scorecardTemplateMetadata);
			scorecardTemplatesMetadata.add(scorecardTemplateMetadata);
		}
		return scorecardTemplatesMetadata;
	}
	
}
