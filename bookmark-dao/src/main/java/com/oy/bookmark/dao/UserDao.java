package com.oy.bookmark.dao;

import com.oy.bookmark.dao.model.User;

public interface UserDao {
	public User createUser(User user);
	public User authentificationUser(String email, String password);
	public void affiherUser();
	public User modifierUser(User user);
	public void supprimerUser(Integer idUser);
	

}
