package com.rhitm.scorecard.dto.create;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NonNull;

/**
 * Request container that stores information about a specific hole on the course. 
 *
 */
@Getter
public class HoleRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8687444750060418961L;

	/**
	 * Assigned hole number on the course
	 */
	@NonNull
	@NotNull(message = "The hole number is required")
	private Integer holeNumber;
	
	/**
	 * Tee positions defined for this hole
	 */
	@NonNull
	@NotNull(message = "A list of tee positions is required")
	private List<TeePositionRequest> teePositions;

	public HoleRequest(int holeNumber, List<TeePositionRequest> teePositions) {
		this.holeNumber = holeNumber;
		this.teePositions = teePositions;
	}
}
