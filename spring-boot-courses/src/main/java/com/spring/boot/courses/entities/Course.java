package com.spring.boot.courses.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
	
	@Id
	private int id;
	private String title;
	private String descr;
	
	public Course(int id, String title, String descr) {
		super();
		this.id = id;
		this.title = title;
		this.descr = descr;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", descr=" + descr + "]";
	}
	
	
	
	
	
}
