package com.spring.boot.courses.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.courses.entities.Course;
@Repository
public interface CourseDao extends JpaRepository<Course, Integer>{
//by default it have pre defined methods for -- getAll getONe, delete ,update, add
}
