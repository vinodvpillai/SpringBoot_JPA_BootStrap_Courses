/**
 * 
 */
package com.zenosys.vinod.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This class Course Model All course related properties are defined over here
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version 1.0
 */

@Entity
@Table(name="courses")
public class CoursesModel {

	private int id;
	private String title;
	private String description;
	private int fees;

	public CoursesModel() {
		super();
	}

	public CoursesModel(String title, String description, int fees) {
		super();
		this.title = title;
		this.description = description;
		this.fees = fees;
	}

	public CoursesModel(int id, String title, String description, int fees) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.fees = fees;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", title=" + title + ", description="
				+ description + ", fees=" + fees + "]";
	}

}
