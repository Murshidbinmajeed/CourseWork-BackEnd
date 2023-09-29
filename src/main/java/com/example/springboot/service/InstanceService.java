package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entity.Instance;
import com.example.springboot.entityVO.InstanceRequestVO;
import com.example.springboot.entityVO.InstanceVO;

public interface InstanceService {
	
	public Instance findInstanceBycourseId(long instanceId);
	
	public Instance createInstance(InstanceRequestVO instanceRequestVO);
	
	public void deleteInstance(long instanceId);
	
	public List<InstanceVO> findCoursesByYearAndSem(InstanceRequestVO instanceRequestVO);
}
