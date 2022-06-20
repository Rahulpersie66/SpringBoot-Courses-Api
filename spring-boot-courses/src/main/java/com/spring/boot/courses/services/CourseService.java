package com.spring.boot.courses.services;

import java.util.List;

import com.spring.boot.courses.entities.Course;

public interface CourseService {

	public List<Course> getCourses();
	
	//retreive single course
	public Course getCourse(int courseId);
	
	//add the courses
	public Course addCourse(Course course);
	
	//for update the course
	public Boolean updateCourse(int courseId,Course course);
	
	//for delete the course
	public void deleteCourse(int parseLong);
}
