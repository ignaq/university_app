package ar.com.nacho.app.models.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.nacho.app.models.dao.IUserDao;
import ar.com.nacho.app.models.entity.User;
import ar.com.nacho.app.models.service.IUserService;

@Service
public class UserServiceImp implements IUserService{

	@Autowired
	IUserDao userDao;
	
	@Override
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

}
