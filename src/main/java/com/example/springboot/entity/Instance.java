package com.example.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "instance")
public class Instance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long instanceId;
	
	@Column(name = "semester")
	private long semester;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	Course course;
	
	@Column(name = "year")
	private long year;
	
	
	public Instance() {
		
	}


	public Instance(long semester, Course course, long year) {
		
		this.semester = semester;
		this.course = course;
		this.year = year;
	}


	public long getInstanceId() {
		return instanceId;
	}


	public void setInstanceId(long instanceId) {
		this.instanceId = instanceId;
	}


	public long getSemester() {
		return semester;
	}


	public void setSemester(long semester) {
		this.semester = semester;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public long getYear() {
		return year;
	}


	public void setYear(long year) {
		this.year = year;
	}
	
	
}
