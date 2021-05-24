package com.rhitm.scorecard.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class Hole {
	
	/**
	 * Assigned hole number on the course
	 */
	private int holeNumber;
	
	// Tee position
	private TeePosition teePosition;
	
	// Distance from this tee position to the basket, in feet
	private int distance;
	
	// The par rating for this tee position
	private int par;

}
