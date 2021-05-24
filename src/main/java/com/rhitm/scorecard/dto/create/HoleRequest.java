package com.rhitm.scorecard.dto.create;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.rhitm.scorecard.domain.TeePosition;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Request container that stores information about a specific hole on the course. 
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class HoleRequest {

	/**
	 * Assigned hole number on the course
	 */
	@Min(1)
	private int holeNumber;
	
	// Tee position
	@NotNull(message = "A tee position description of GOLD, BLUE, WHITE, or RED is required")
	private TeePosition teePosition;
	
	// Distance from this tee position to the basket, in feet
	@Min(1)
	private int distance;
	
	// The par rating for this tee position
	@Min(1)
	private int par;

}
