package com.sehron.service.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private List<? extends GrantedAuthority> authorities;
	private String password;
	private String username;
	private boolean enabled;
	private int salt;

	private UserDetailsImpl() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
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
		return enabled;
	}

	public int getSalt() {
		return salt;
	}

	public static class Builder {
		private UserDetailsImpl template = new UserDetailsImpl();

		public Builder authorities(List<? extends GrantedAuthority> authorities) {
			template.authorities = authorities;
			return this;
		}

		public Builder password(String password) {
			template.password = password;
			return this;
		}

		public Builder username(String username) {
			template.username = username;
			return this;
		}

		public Builder enabled(boolean enabled) {
			template.enabled = enabled;
			return this;
		}

		public Builder salt(int salt) {
			template.salt = salt;
			return this;
		}

		public UserDetailsImpl build() {
			return template;
		}
	}
}
