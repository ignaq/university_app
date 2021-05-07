package ar.com.nacho.app.models.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;


import ar.com.nacho.app.models.entity.Course;

public interface ICourseDao extends CrudRepository<Course, Long> {
	
	
	
	
	List<Course> findAllByOrderByNameAsc();
	

	List<Course> findAllByStudentsIdEquals(Long id);
	
	
	Course findByStudentsIdAndSchedule(Long id, String schedule);

	
	
}
