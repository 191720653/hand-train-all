package com.hand.entity;

public class Film {
	private int id;
	private String title;
	private String description;
	private String langusge;
	private int lan_id;
	public int getLan_id() {
		return lan_id;
	}
	public void setLan_id(int lan_id) {
		this.lan_id = lan_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLangusge() {
		return langusge;
	}
	public void setLangusge(String langusge) {
		this.langusge = langusge;
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", langusge=" + langusge + "]";
	}

}
