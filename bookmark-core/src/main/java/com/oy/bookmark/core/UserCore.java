package com.oy.bookmark.core;

import java.util.List;

import com.oy.bookmark.core.exception.BusinessException;
import com.oy.bookmark.dao.model.User;

public interface UserCore {

	public User createUser(User user) throws BusinessException;

	public User authentificationUser(String email, String password) throws BusinessException;
	public User findUser(Integer idUser) throws BusinessException;
	public User modifierUser(User user) throws BusinessException;
	public List<User> searchUser(String pattern_email) throws BusinessException;

}
