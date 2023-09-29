package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Instance;
import com.example.springboot.entityVO.InstanceRequestVO;
import com.example.springboot.entityVO.InstanceVO;
import com.example.springboot.service.CourseService;
import com.example.springboot.service.InstanceService;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private InstanceService instanceService;
	
	@PostMapping("/api/courses")
	public Course createCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
	}
	
	@GetMapping("/api/courses")
	public List<Course> findAllCourse(){
		return courseService.findAllCourse();
	}
	
	@GetMapping("/api/courses/{courseId}")
	public Course findByCourseId(@PathVariable long courseId) {
		return courseService.findByCourseId(courseId);
	}
	
	@DeleteMapping("/api/courses/{courseId}")
	public void deleteCourse(@PathVariable long courseId) {
	   courseService.deleteCourse(courseId);
	}
	
	@PostMapping("/api/instances")
	public Instance createInstance(@RequestBody InstanceRequestVO instanceRequestVO) {
		return instanceService.createInstance(instanceRequestVO);
	}
	
	@GetMapping("/api/instances")
	public List<InstanceVO> findCoursesByYearAndSem(@RequestBody InstanceRequestVO instanceRequestVO){
		return instanceService.findCoursesByYearAndSem(instanceRequestVO);
	}
	
	@GetMapping("/api/instances")
	public Instance findInstanceBycourseId(@PathVariable long instanceId) {
		return instanceService.findInstanceBycourseId(instanceId);
	}
	
	@DeleteMapping("/api/instances/2022/2/8")
	public void deleteInstance(@PathVariable long instanceId) {
		instanceService.deleteInstance(instanceId);
	}

}
