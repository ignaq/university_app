package ar.com.nacho.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.nacho.app.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{

	public User findByUsername(String username);
}
