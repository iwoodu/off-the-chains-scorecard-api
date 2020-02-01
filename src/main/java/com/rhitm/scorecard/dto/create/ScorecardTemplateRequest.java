package com.rhitm.scorecard.dto.create;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Request for creating and updating scorecard templates.
 *
 */
@NoArgsConstructor @RequiredArgsConstructor
@Getter @Setter
public class ScorecardTemplateRequest {

	/**
	 * Name of the course
	 */
	@NonNull
	@NotNull(message = "Course name is required")
	private String courseName;

	/**
	 * Collection of holes that comprise the course
	 */
	@NonNull
	@NotNull(message = "A list of holes is required")
	private List<HoleRequest> holes;
	
}
