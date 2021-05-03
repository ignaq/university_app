package ar.com.nacho.app.models.service;

import ar.com.nacho.app.models.entity.User;


public interface IUserService {

	public User findByUsername(String username);
	
}
