package com.rhitm.scorecard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class TeePosition {
	
	private String description;
	private int distance;
	private int par;

}
