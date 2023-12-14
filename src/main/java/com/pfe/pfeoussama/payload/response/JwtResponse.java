package com.pfe.pfeoussama.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer ";
	private String id;
	private String username;
	private String email;
	private String Numero="dou";
	private   String Image;
	private String roles;



	public JwtResponse(String accessToken, String id, String username, String email, String roles, String numero, String image) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.Numero = numero;
		this.Image=image;
	}
	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}
	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoles() {
		return roles;
	}
}
