package ar.com.nacho.app.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.nacho.app.models.dao.ITeacherDao;
import ar.com.nacho.app.models.entity.Teacher;
import ar.com.nacho.app.models.service.ITeacherService;

@Service
public class TeacherServiceImp implements ITeacherService {

	@Autowired
	private ITeacherDao teacherDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Teacher> findAll() {
		return (List<Teacher>) teacherDao.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Teacher findOne(Long id) {
		
		return teacherDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public void save(Teacher teacher) {
		teacherDao.save(teacher);
	}

}
