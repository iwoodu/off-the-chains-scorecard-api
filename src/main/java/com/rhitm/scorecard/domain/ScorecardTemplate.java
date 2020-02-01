package com.rhitm.scorecard.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representation of a score card template.
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ScorecardTemplate {
	
	/**
	 * Uniquely identifies a scorecard template
	 * <p>
	 * Defined as a string to allow UUID values vs long values only.
	 */
	@Id
	private String id;
	
	/**
	 * Name of the course
	 */
	private String courseName;
	
	/**
	 * Collection of holes that comprise the course 
	 */
	private List<Hole> holes;
	
}
