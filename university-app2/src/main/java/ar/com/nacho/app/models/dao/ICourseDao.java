package ar.com.nacho.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.com.nacho.app.models.entity.Course;

public interface ICourseDao extends CrudRepository<Course, Long> {
	
	
	@Query(value="SELECT * FROM courses order by courses.name", nativeQuery = true)
	List<Course> findAllByOrder();
	
	
	@Query(value="SELECT * FROM courses, course_student where courses.id=course_student.course_id and course_student.student_id = ? " , nativeQuery = true)
	List<Course> courseByStudent(Long id);
	
	
	
	@Query(value="SELECT * FROM courses, course_student where courses.id=course_student.course_id and course_student.student_id = ? and courses.schedule like ?" ,
			nativeQuery = true)
	Course courseByHour(Long id, String schedule);

}
