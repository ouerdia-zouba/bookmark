package com.oy.bookmark.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookmark")
public class Bookmark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bookmark")
	private Integer idBookmark;
	private String name;
	private String url;
	private String comment;
	@JoinColumn(name = "id_group", referencedColumnName = "id_group") // on pourra enlever referencedColumnName
	@ManyToOne
	private Group group;

	public Integer getIdBookmark() {
		return idBookmark;
	}

	public void setIdBBookmark(Integer idBookmark) {
		this.idBookmark = idBookmark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Bookmark() {
		super();
	}

	public Bookmark(String name, String url, String comment, Group group) {
		super();
		this.name = name;
		this.url = url;
		this.comment = comment;
		this.group = group;
	}

}
