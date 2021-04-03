package ar.com.nacho.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.nacho.app.models.entity.Student;

public interface IStudentDao extends CrudRepository<Student, Long> {

}
