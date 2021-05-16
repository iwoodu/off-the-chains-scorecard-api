package com.rhitm.scorecard.dto.create;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Request for creating and updating scorecard templates.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class ScorecardTemplateRequest {

	/**
	 * Name of the course
	 */
	@NotNull(message = "Course name is required")
	private String courseName;

	/**
	 * Collection of holes that comprise the course
	 */
	@Valid
	@NotEmpty(message = "At least 1 hole must be defined for a scorecard")
	private List<HoleRequest> holes;
	
}
