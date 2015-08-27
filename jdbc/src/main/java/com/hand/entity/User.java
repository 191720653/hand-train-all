package com.hand.entity;

public class User extends IdEntity {

	private String name;
	private String password;
	private String addredss;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddredss() {
		return addredss;
	}

	public void setAddredss(String addredss) {
		this.addredss = addredss;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", addredss=" + addredss + ", id=" + id + "]";
	}

}
