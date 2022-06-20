package com.spring.boot.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.courses.entities.Course;
import com.spring.boot.courses.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService; 
	
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to this course";
	}
	
	//retrieve all the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	//single course retrieve
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Integer.parseInt(courseId));
	}
	
	//course add in the data
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	
	//update the course
	@PutMapping("/courses/{courseId}")
	public String updateCourse(@PathVariable String courseId, @RequestBody Course course)
	{	String msg=null;
		if (this.courseService.updateCourse(Integer.parseInt(courseId),course))
			msg="Succesfullly updated data for id: "+courseId+" .";
		else
			msg="No such id:"+courseId+" exist in the database, so CANNOT be updated.";
			return msg;
	}
	
	//delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try {
			this.courseService.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
