package ar.com.nacho.app.models.service;

import java.util.List;


import ar.com.nacho.app.models.entity.Teacher;

public interface ITeacherService {
	
	public List<Teacher> findAll();
	
	public Teacher findOne(Long id);
	
	public void save(Teacher teacher);

}
