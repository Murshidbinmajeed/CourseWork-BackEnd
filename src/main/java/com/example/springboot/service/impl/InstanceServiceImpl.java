package com.example.springboot.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Instance;
import com.example.springboot.entityVO.InstanceRequestVO;
import com.example.springboot.entityVO.InstanceVO;
import com.example.springboot.repository.CourseRepository;
import com.example.springboot.repository.InstanceRepository;
import com.example.springboot.service.InstanceService;

public class InstanceServiceImpl implements InstanceService {
	
	@Autowired
	private InstanceRepository instanceRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Instance findInstanceBycourseId(long instanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instance createInstance(InstanceRequestVO instanceRequestVO) {
		Instance instance1 = new Instance();
		Course courses = courseRepository.findById(instanceRequestVO.getCourseId()).get();
		instance1.setCourse(courses);
		instance1.setSemester(instanceRequestVO.getSemester());
		instance1.setYear(instanceRequestVO.getYear());
		return instanceRepository.save(instance1);
	}

	@Override
	public void deleteInstance(long instanceId) {
		instanceRepository.deleteById(instanceId);
	}

	@Override
	public List<InstanceVO> findCoursesByYearAndSem(InstanceRequestVO instanceRequestVO) {
		List<Instance> instanceList = instanceRepository.findAll();
		long year = instanceRequestVO.getYear();
		long sem = instanceRequestVO.getSemester();
		List<InstanceVO> instanceVOList = new ArrayList<InstanceVO>();
		for(Instance i:instanceList) {
			InstanceVO instanceVO = new InstanceVO();
			long year1 = i.getYear();
			long sem1 = i.getSemester();
			if(year == year1 && sem == sem1) {
				instanceVO.setCourseCode(i.getCourse().getCourseCode());
				instanceVO.setCourseTitle(i.getCourse().getCourseTitle());
				instanceVOList.add(instanceVO);
			}
		}
		return instanceVOList;
	}

}
