package com.example.springboot.entityVO;

public class InstanceRequestVO {
	private long courseId;
	private long semester;
	private long year;
	private long instanceId;
	
	public InstanceRequestVO(long courseId, long semester, long year, long instanceId) {
		this.courseId = courseId;
		this.semester = semester;
		this.year = year;
		this.instanceId = instanceId;
	}
	
	public InstanceRequestVO(long semester, long year, long instanceId) {
		this.semester = semester;
		this.year = year;
		this.instanceId = instanceId;
	}

	public InstanceRequestVO(long semester, long year) {
		this.semester = semester;
		this.year = year;
	}

	public InstanceRequestVO() {
		
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
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
	public long getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(long instanceId) {
		this.instanceId = instanceId;
	}
	
	
	
}
