package com.oy.bookmark.dao;

import java.util.List;

import com.oy.bookmark.dao.model.Group;
import com.oy.bookmark.dao.model.User;

public interface GroupDao {
	public Group creerGroup(Group group);
	public Group findGroup(Integer id_Group);
	public Group modifierGroup(Group group);
	public void supprimerGroup(Integer idGroup);
	public Group AjouterUserGroup(User user, Group group);

}
