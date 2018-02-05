package com.oy.bookmark.dao;

import java.util.ArrayList;
import java.util.List;

import com.oy.bookmark.dao.model.User;

public interface UserDao {
	public User createUser(User user);
	public User authentificationUser(String email, String password);
	public User checkEmailUser(String email);
	public User findUser(Integer idUser);
	public User modifierUser(User user);
	public List<User> searchUser(String pattern_email);
	public void supprimerUser(Integer idUser);
	

}
