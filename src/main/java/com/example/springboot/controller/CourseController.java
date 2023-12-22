package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Instance;
import com.example.springboot.entityVO.InstanceRequestVO;
import com.example.springboot.entityVO.InstanceVO;
import com.example.springboot.service.CourseService;
import com.example.springboot.service.InstanceService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private InstanceService instanceService;
	
	@PostMapping("/createCourses")
	public Course createCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
	}
	
	@GetMapping("/viewAllCourses")
	public ResponseEntity<List<Course>> findAllCourse(){
		return new ResponseEntity<>( courseService.findAllCourse(), HttpStatus.FOUND);
	}
	
	@GetMapping("/viewCourse/{courseId}")
	public Course findByCourseId(@PathVariable long courseId) {
		return courseService.findByCourseId(courseId);
	}
	
	@DeleteMapping("/delCourse/{courseId}")
	public void deleteCourse(@PathVariable long courseId) {
	   courseService.deleteCourse(courseId);
	}
	
	@PostMapping("/createInstances")
	public Instance createInstance(@RequestBody InstanceRequestVO instanceRequestVO) {
		return instanceService.createInstance(instanceRequestVO);
	}
	
	@GetMapping("/viewAllInstances")
	public ResponseEntity<List<Instance>> findAllInstances(){
		return new ResponseEntity<>(instanceService.findAllInstances(), HttpStatus.FOUND);
	}
	
	@GetMapping("/viewInstances/{year}/{semester}")
	public ResponseEntity<List<InstanceVO>> findInstancesesByYearAndSem(@PathVariable long year,@PathVariable long semester){
		return new ResponseEntity<>( instanceService.findInstancesByYearAndSem(year,semester), HttpStatus.FOUND);
	}
	
	@GetMapping("/viewInstances/{year}/{semester}/{courseId}")
	public ResponseEntity<List<InstanceVO>> findInstanceBycourseIdYearAndSemester(@PathVariable long year,@PathVariable long semester,@PathVariable long courseId){
		return new ResponseEntity<>( instanceService.findInstanceBycourseIdYearAndSemester(year,semester,courseId), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delInstances/{year}/{semester}/{courseId}")
	public void deleteInstance(@PathVariable long year,@PathVariable long semester,@PathVariable long courseId) {
		instanceService.deleteInstance(year,semester,courseId);
	}

}
