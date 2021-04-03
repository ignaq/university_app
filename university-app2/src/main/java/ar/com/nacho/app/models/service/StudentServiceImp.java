package ar.com.nacho.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.nacho.app.models.dao.IStudentDao;
import ar.com.nacho.app.models.entity.Student;

@Service
public class StudentServiceImp implements IStudentService{

	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public Student findById(Long id) {
		return studentDao.findById(id).orElse(null);
	}

	@Override
	public void save(Student student) {
		studentDao.save(student);
		
	}

	
}
