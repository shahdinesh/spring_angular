package com.dinesh.newboot.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String username;
	private final String name;

	public JwtResponse(String jwttoken, String username, String name) {
		this.jwttoken = jwttoken;
		this.username = username;
		this.name = name;
	}
	public String getJwttoken() {
		return jwttoken;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}
}