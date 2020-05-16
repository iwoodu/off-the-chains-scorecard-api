package com.rhitm.scorecard.dto.create;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
	@NotNull(message = "The hole number is required")
	private int holeNumber;
	
	/**
	 * Tee positions defined for this hole
	 */
	@Valid
	@NotNull(message = "A list of tee positions is required")
	private List<TeePositionRequest> teePositions;

}
