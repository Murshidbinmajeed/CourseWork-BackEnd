package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Course;
import com.example.springboot.repository.CourseRepository;
import com.example.springboot.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> findAllCourse() {
		return courseRepository.findAll();
	}

	@Override
	public Course findByCourseId(long courseId) {
		return courseRepository.findById(courseId).get();
	}

	@Override
	public Course createCourse(Course course) {
		Course course1 = new Course();
		course1.setCourseTitle(course.getCourseTitle());
		course1.setCourseCode(course.getCourseCode());
		course1.setDescription(course.getDescription());
		courseRepository.save(course1);
		return course1;
	}

	@Override
	public void deleteCourse(long courseId) {
		courseRepository.deleteById(courseId);
		
	}

}
