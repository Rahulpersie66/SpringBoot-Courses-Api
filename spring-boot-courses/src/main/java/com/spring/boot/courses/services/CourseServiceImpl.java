package com.spring.boot.courses.services;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.courses.daos.CourseDao;
import com.spring.boot.courses.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	//List<Course> list;
	
	public CourseServiceImpl() {
		
		
		
		
//		list=new ArrayList<>();
//		list.add(new Course(1,"Java","knowledge of java"));
//		list.add(new Course(2,"Sql","Databse table"));
	}
	
	
	@Override
	public List<Course> getCourses() {
		
		
		return courseDao.findAll();
		
		// TODO Auto-generated method stub
		//return list;
	}
	
	@Override
	public Course getCourse(int courseId) {
	
		return courseDao.findById(courseId).get();
	// TODO Auto-generated method stub
//		Course c=null;
//		for(Course course:list)
//		{
//			if(course.getId()==courseId)
//			{
//				c=course;
//				break;
//			}
//		}
//		return c;
	}
	
	
	@Override
	public Course addCourse(Course course) {
	
		courseDao.save(course);
		return course;
		// TODO Auto-generated method stub
		//list.add(course);
		//return course;
	}
	
	
	@Override
	public Boolean updateCourse(int courseId,Course course) {
//		Course c=new Course();
//		c.setId(courseId);
//		c.setTitle(course.getTitle());
//		c.setDescr(course.getDescr());
		Boolean flag=false;
		Set<Course> courses=new LinkedHashSet<Course>(courseDao.findAll());
		for(Course cour:courses) {
			if(courseId==cour.getId())
			{
				courseDao.save(course);
				flag=true;
			}
			
		}
		return flag;
		
		// TODO Auto-generated method stub
//		list.forEach(e->{
//			if(e.getId()==course.getId())
//			{
//				e.setTitle(course.getTitle());
//				e.setDescr(course.getDescr());
//			}
//		});
//		return course;
	}
	
	
	@Override
	public void deleteCourse(int parseLong) {
		Course entityDelete=courseDao.getById(parseLong);
		courseDao.delete(entityDelete);
		
		// TODO Auto-generated method stub
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}
	
	

}
