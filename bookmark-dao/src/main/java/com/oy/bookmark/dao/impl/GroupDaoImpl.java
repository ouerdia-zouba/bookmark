package com.oy.bookmark.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.oy.bookmark.dao.GroupDao;
import com.oy.bookmark.dao.model.Group;
import com.oy.bookmark.dao.model.User;

public class GroupDaoImpl extends Dao implements GroupDao {

	public GroupDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public Group creerGroup(Group group) {
		em.persist(group);
		return group;
	}

	public Group findGroup(Integer id_Group) {
		Group group = em.find(Group.class, id_Group);
		return group;
	}

	public Group modifierGroup(Group group) {
		Group groupDB = em.find(Group.class, group.getIdGroup());
		groupDB.setName(group.getName());
		return groupDB;
	}

	public void supprimerGroup(Integer idGroup) {
		Group group = em.find(Group.class, idGroup);
		em.remove(group);

	}

	public Group AjouterUserGroup(User user, Group group) {
		if (group.getUsers() == null) {
			List<User> users = new ArrayList<User>();
			users.add(user);
			group.setUsers(users);
		} else {
			group.getUsers().add(user);
		}
		return group;

	}

}
