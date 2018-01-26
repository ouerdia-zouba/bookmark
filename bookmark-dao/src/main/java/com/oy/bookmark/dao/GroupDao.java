package com.oy.bookmark.dao;

import com.oy.bookmark.dao.model.Group;

public interface GroupDao {
	public Group creer(Group group);
	public void affiherGroup();
	public Group modifierGroup(Group group);
	public void supprimerGroup(Integer idGroup);
	

}
