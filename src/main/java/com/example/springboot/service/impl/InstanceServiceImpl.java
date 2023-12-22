package com.example.springboot.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Course;
import com.example.springboot.entity.Instance;
import com.example.springboot.entityVO.InstanceRequestVO;
import com.example.springboot.entityVO.InstanceVO;
import com.example.springboot.repository.CourseRepository;
import com.example.springboot.repository.InstanceRepository;
import com.example.springboot.service.InstanceService;

@Service
public class InstanceServiceImpl implements InstanceService {
	
	@Autowired
	private InstanceRepository instanceRepository;
	@Autowired
	private CourseRepository courseRepository;

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
	public List<InstanceVO> findInstancesByYearAndSem(long year,long semester) {
		List<Instance> instanceList = instanceRepository.findAll();
		List<InstanceVO> instanceVOList = new ArrayList<InstanceVO>();
		for(Instance i:instanceList) {
			InstanceVO instanceVO = new InstanceVO();
			long year1 = i.getYear();
			long sem1 = i.getSemester();
			if(year == year1 && semester == sem1) {
				instanceVO.setCourseCode(i.getCourse().getCourseCode());
				instanceVO.setCourseTitle(i.getCourse().getCourseTitle());
				instanceVO.setSemester(i.getSemester());
				instanceVO.setYear(i.getYear());
				instanceVOList.add(instanceVO);
			}
		}
		return instanceVOList;
	}

	@Override
	public List<InstanceVO> findInstanceBycourseIdYearAndSemester(long year, long semester, long courseId) {
		List<Instance> instanceList = instanceRepository.findAll();
		List<InstanceVO> instanceVOList = new ArrayList<InstanceVO>();
		for(Instance i:instanceList) {
			InstanceVO instanceVO = new InstanceVO();
			long courseId1 = i.getCourse().getCourseId();
			long year1 = i.getYear();
			long sem1 = i.getSemester();
			if(year == year1 && semester == sem1 && courseId == courseId1) {
				instanceVO.setCourseCode(i.getCourse().getCourseCode());
				instanceVO.setCourseTitle(i.getCourse().getCourseTitle());
				instanceVO.setSemester(i.getSemester());
				instanceVO.setYear(i.getYear());
				instanceVOList.add(instanceVO);
			}
		}
		return instanceVOList;
	}
	
	@Override
	public void deleteInstance(long year, long semester,long courseId) {
		List<Instance> instanceList = instanceRepository.findAll();
		for(Instance i:instanceList) {
			long courseId1 = i.getCourse().getCourseId();
			long year1 = i.getYear();
			long sem1 = i.getSemester();
			if(year == year1 && semester == sem1 && courseId == courseId1) {
				instanceRepository.deleteById(i.getInstanceId());
			}
		}
	}

	@Override
	public List<Instance> findAllInstances() {
		
		return instanceRepository.findAll();
	}

}
