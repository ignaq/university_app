package ar.com.nacho.app.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import ar.com.nacho.app.models.dao.ICourseDao;
import ar.com.nacho.app.models.entity.Course;
import ar.com.nacho.app.models.service.ICourseService;

@Service
public class CourseServiceImp implements ICourseService {

	@Autowired 
	private ICourseDao courseDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Course> findAll() {
		return (List<Course>) courseDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Course findOne(Long id) {
		return courseDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Course course) {
		courseDao.save(course);	
	}


	@Override
	@Transactional
	public List<Course> findByOrderName() {
		
		return (List<Course>) courseDao.findAllByOrder();
	}

	@Override
	public List<Course> findCoursesByUser(Long id) {
		
		return (List<Course>) courseDao.courseByStudent(id);
	}

	@Override
	public Course findByHours(Long id, String schedule) {
		
		return courseDao.courseByHour(id, schedule);
	}


	
}
