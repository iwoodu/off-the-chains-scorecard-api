package com.rhitm.scorecard.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Hole {
	
	/**
	 * Assigned hole number on the course
	 */
	private int holeNumber;
	
	/**
	 * Tee positions defined for this hole
	 */
	private List<TeePosition> teePositions;

}
