package ar.com.nacho.app.models.service;

import java.util.List;

import ar.com.nacho.app.models.entity.Course;

public interface ICourseService {

	public List<Course> findAll();
	
	public List<Course> findByOrderName();
	
	public Course findOne(Long id);
	
	public void save(Course course);
	
	public List<Course> findCoursesByUser(Long id);
	
	public Course findByHours(Long id, String schedule);
}
