package com.genesys.api.dao.entity;


public class MovilEntity {
	
	private String id;
	private String token;

	public String getId() {
		return id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", token=" + token + "]";
	}
	
}
