package com.oy.bookmark.dao;

import com.oy.bookmark.dao.model.Bookmark;

public interface BookmarkDao {
	public Bookmark creerBookmark(Bookmark bookmark);
	public Bookmark findBookmark(Integer idBookmark);
	public Bookmark modifierBookmark(Bookmark bookmark);
	public void supprimerBookmark(Integer idBookmark);

}
