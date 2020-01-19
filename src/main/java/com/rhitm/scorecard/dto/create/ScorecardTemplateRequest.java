package com.rhitm.scorecard.dto.create;

import javax.validation.constraints.NotNull;

/**
 * Request for creating and updating scorecard templates.
 *
 */
public class ScorecardTemplateRequest {
	
	@NotNull(message = "Course name is required")
	private String courseName;
	
	@NotNull(message = "Tees is required")
	private String tees;
	
	@NotNull(message = "Par rating is required")
	private int par;
	
	@NotNull(message = "Number of holes is required")
	private int numberOfHoles;

	/**
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the name of the course
	 * @param courseName Name of the course
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the tees played during the round
	 */
	public String getTees() {
		return tees;
	}

	/**
	 * Sets the tees to be played during the round
	 * @param tees the tees to be played during the round
	 */
	public void setTees(String tees) {
		this.tees = tees;
	}

	/**
	 * @return the par for the course
	 */
	public int getPar() {
		return par;
	}

	/**
	 * Sets the course's par rating.
	 * @param par the course's par rating
	 */
	public void setPar(int par) {
		this.par = par;
	}

	/**
	 * @return the number of holes
	 */
	public int getNumberOfHoles() {
		return numberOfHoles;
	}

	/**
	 * Sets the number of holes on the course
	 * @param numberOfHoles the number of holes on the course
	 */
	public void setNumberOfHoles(int numberOfHoles) {
		this.numberOfHoles = numberOfHoles;
	}

}
