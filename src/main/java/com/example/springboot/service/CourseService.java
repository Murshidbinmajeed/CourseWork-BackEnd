package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entity.Course;

public interface CourseService {
	
	public List<Course> findAllCourse();
	
	public Course findByCourseId(long courseId);
	
	public Course createCourse(Course course);
	
	public void deleteCourse(long courseId);

}
