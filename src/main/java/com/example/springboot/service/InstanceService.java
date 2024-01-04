package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entity.Instance;
import com.example.springboot.entityVO.InstanceRequestVO;
import com.example.springboot.entityVO.InstanceVO;

public interface InstanceService {
	
	public List<Instance> findAllInstances();
	
	public List<InstanceVO> findAllSemesters();
	
	public List<InstanceVO> findInstanceBycourseIdYearAndSemester(long year,long semester,long courseId);
	
	public Instance createInstance(InstanceRequestVO instanceRequestVO);
	
	public void deleteInstance(long year,long semester,long courseId);
	
	public List<InstanceVO> findInstancesByYearAndSem(long year,long semester);
}
