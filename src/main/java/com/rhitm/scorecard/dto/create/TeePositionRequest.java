package com.rhitm.scorecard.dto.create;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.rhitm.scorecard.domain.TeeDescription;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Request container that stores information about the teebox position on a specific hole.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class TeePositionRequest {

	// Tee position
	@NotNull(message = "A tee position description of GOLD, BLUE, WHITE, or RED is required")
	private TeeDescription description;
	
	// Distance from this tee position to the basket
	@Min(1)
	private int distance;
	
	// The par rating for this tee position
	@NotNull(message = "A par rating for the tee position is required")
	private int par;

}
