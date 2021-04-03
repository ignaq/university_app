package ar.com.nacho.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.nacho.app.models.entity.Teacher;

public interface ITeacherDao extends CrudRepository<Teacher, Long> {

}
