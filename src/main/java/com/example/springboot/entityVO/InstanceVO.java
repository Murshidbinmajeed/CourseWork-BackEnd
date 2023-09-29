package com.example.springboot.entityVO;

public class InstanceVO {
	private long semester;
	private long year;
	private String courseTitle;
	private String courseCode;
	public InstanceVO(long semester, long year, String courseTitle, String courseCode) {
		this.semester = semester;
		this.year = year;
		this.courseTitle = courseTitle;
		this.courseCode = courseCode;
	}
	public InstanceVO(String courseTitle, String courseCode) {
		this.courseTitle = courseTitle;
		this.courseCode = courseCode;
	}

	public InstanceVO() {
		
	}
	public long getSemester() {
		return semester;
	}
	public void setSemester(long semester) {
		this.semester = semester;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
