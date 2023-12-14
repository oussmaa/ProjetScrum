package com.pfe.pfeoussama.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.pfe.pfeoussama.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String id;

	private String username;

	private String email;


	private String Numero;
	private String Image;
	@JsonIgnore
	private String password;

	private User user;

	private String Roles;

	public UserDetailsImpl(String id, String email,String username,  String password, String numero, String image, String roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.Numero = numero;
		this.Image=image;


		this.Roles = roles;
	}

	public static UserDetailsImpl build(User user) {


		return new UserDetailsImpl(
				user.getId(),
				user.getEmail(),
				user.getUsername(),

				user.getPassword(),
				user.getNumero(), user.getImage(),
				user.getRoles());
	}

	public String getRoles() {
		return Roles;
	}

	public void setRoles(String roles) {
		Roles = roles;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	public String getNumero() {
		return Numero;
	}


	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
