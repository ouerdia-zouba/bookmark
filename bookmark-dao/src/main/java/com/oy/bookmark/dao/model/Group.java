package com.oy.bookmark.dao.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.boot.registry.selector.spi.StrategyCreator;

public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_group")
	private Integer id_group;
	private String name;
	public Integer getId_group() {
		return id_group;
	}
	public void setId_group(Integer id_group) {
		this.id_group = id_group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Group() {
		super();
	}

}
