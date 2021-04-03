package ar.com.nacho.app.models.service;


import ar.com.nacho.app.models.entity.Student;

public interface IStudentService{
	
	public Student findById(Long id);

	public void save(Student student);
	
	
}
