package com.oy.bookmark.dao;

import com.oy.bookmark.dao.model.Bookmark;

public interface BookmarkDao {
	public Bookmark creer(Bookmark bookmark);
	public void affiherBookmark();
	public Bookmark modifierBookmark(Bookmark bookmark);
	public void supprimerBookmark(Integer idBookmark);

}
