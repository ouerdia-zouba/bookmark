package com.oy.bookmark.core.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.oy.bookmark.core.UserCore;
import com.oy.bookmark.core.exception.BusinessException;
import com.oy.bookmark.dao.GroupDao;
import com.oy.bookmark.dao.UserDao;
import com.oy.bookmark.dao.impl.GroupDaoImpl;
import com.oy.bookmark.dao.impl.UserDaoImpl;
import com.oy.bookmark.dao.model.Group;
import com.oy.bookmark.dao.model.User;

public class UserCoreImpl implements UserCore {

	private UserDao userDao = new UserDaoImpl();
	private GroupDao groupeDao = new GroupDaoImpl();

	public User createUser(User user) throws BusinessException {
		if (user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new BusinessException("la données email est obligatoire");
		}
		if (user.getUsername() == null || user.getUsername().isEmpty()) {
			throw new BusinessException("la données username est obligatoire");
		}
		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new BusinessException("la données password est obligatoire");
		}

		if (userDao.checkEmailUser(user.getEmail()) != null) {
			throw new BusinessException("cette adresse mail existe déjà");
		}

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(user.getPassword().getBytes());
			user.setPassword(digest.toString());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("erreur inatendue");
		}

		User userResponse = userDao.createUser(user);

		Group group = groupeDao.creerGroup(new Group("default"));
		groupeDao.AjouterUserGroup(userResponse, group);

		return userResponse;
	}

	public User authentificationUser(String email, String password) throws BusinessException {
		User user = userDao.authentificationUser(email, password);
		if (user == null) {
			throw new BusinessException("l'utilisateur n'existe pas");
		}
		return user;
	}

	public User findUser(Integer idUser) throws BusinessException {
		User user = userDao.findUser(idUser);
		if (user == null) {
			throw new BusinessException("l'utilisateur n'existe pas");

		}
		return user;

	}

	public User modifierUser(User user) throws BusinessException {
		User userDB = userDao.findUser(user.getIdUser());
		if (userDB == null) {
			throw new BusinessException("l'utilisateur n'existe pas");
		}

		if (user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new BusinessException("la données email est obligatoire");
		}
		if (user.getUsername() == null || user.getUsername().isEmpty()) {
			throw new BusinessException("la données username est obligatoire");
		}
		userDB = userDao.modifierUser(user);
		return userDB;

	}

	public List<User> searchUser(String pattern_email) throws BusinessException {
		if (pattern_email.length() < 3) {
			throw new BusinessException("le petterne de recherche doit contenir au moins 3 caractères");
		}

		List<User> users = userDao.searchUser(pattern_email);

		return users;
	}

	public void supprimerUser(Integer idUser) throws BusinessException {
		User user = userDao.findUser(idUser);
		if (user == null) {
			throw new BusinessException("l'utilisateur n'existe pas");
		}
		userDao.supprimerUser(idUser);
	}

}
