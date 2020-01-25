package com.rhitm.scorecard.dto.create;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.rhitm.scorecard.domain.TeeDescription;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * Request container that stores information about the teebox position on a specific hole.
 *
 */
@Getter
public class TeePositionRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2716312683855164256L;

	// Tee position
	@NonNull
	@NotNull(message = "A tee position description of GOLD, BLUE, WHITE, or RED is required")
	private TeeDescription description;
	
	// Distance from this tee position to the basket
	private Integer distance;
	
	// The par rating for this tee position
	@NonNull
	@NotNull(message = "A par rating for the tee position is required")
	private Integer par;

	public TeePositionRequest(TeeDescription teeDescription, Integer distance, Integer par) {
		this.description = teeDescription;
		this.distance = distance;
		this.par = par;
	}
}
