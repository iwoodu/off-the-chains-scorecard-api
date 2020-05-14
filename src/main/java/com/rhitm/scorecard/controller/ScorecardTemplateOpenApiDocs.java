package com.rhitm.scorecard.controller;

import java.util.List;

import com.rhitm.scorecard.domain.ScorecardTemplate;
import com.rhitm.scorecard.dto.create.ScorecardTemplateRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Scorecard Template API", description = "REST APIs for creating and managing scorecard templates")
public interface ScorecardTemplateOpenApiDocs {

    @Operation(summary = "Saves a scorecard template",
        description = "Saves a scorecard template, which defines one or more layouts for a disc golf course")
	public String create(@RequestBody ScorecardTemplateRequest scorecardTemplateRequest);
	
    @Operation(summary = "Retrieves a filtered list of scorecard templates",
        description = "Retrieves a filtered list of scorecard templates. The results can be filtered by specifying the optional 'CourseName' query string parameter")
	public List<ScorecardTemplate> retrieveAllScorecardTemplates(@RequestParam(name = "CourseName", required = false) String courseName);
	
    @Operation(summary = "Retrieves a scorecard template",
        description = "Retrieves a scorecard template")
	public ScorecardTemplate retrieveScorecardTemplateById(@PathVariable("templateId") String templateId);

}
