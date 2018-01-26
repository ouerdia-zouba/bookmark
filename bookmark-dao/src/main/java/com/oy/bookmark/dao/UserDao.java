package com.oy.bookmark.dao;

import com.oy.bookmark.dao.model.User;

public interface UserDao {
	public User create(User user);
	public void authentificationUser(String username, String password);
	public void affiherUser();
	public User modifierUser(User user);
	public void supprimerUser(Integer idUser);
	

}
