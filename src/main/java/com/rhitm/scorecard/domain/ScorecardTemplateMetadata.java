package com.rhitm.scorecard.domain;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Basic information of a score card template and its metadata.
 *
 */
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class ScorecardTemplateMetadata {
	
	/**
	 * Uniquely identifies a scorecard template
	 * <p>
	 * Defined as a string to allow UUID values vs long values only.
	 */
	private String id;
	
	/**
	 * Name of the course
	 */
	@NotBlank
	private String courseName;
	
	public ScorecardTemplateMetadata(String id, String courseName) {
		this.id = id;
		this.courseName = courseName;
	}
	
}
