package kr.pe.goodwilldd.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationModel implements UserDetails {

	private String username;
	private String password;
	private boolean lock;
	private boolean accountExpired;
	private boolean credentialExpried;
	private boolean use;
	private Collection<? extends GrantedAuthority> authorities;

	/**
	 * 
	 */
	private static final long serialVersionUID = 6566746604750997139L;

	public AuthenticationModel() {

	}

	public AuthenticationModel(String username, String password, boolean lock,
			boolean accountExpired, boolean credentialExpried, boolean use,
			Collection<? extends GrantedAuthority> authrity) {
		this.username = username;
		this.password = password;
		this.lock = lock;
		this.accountExpired = accountExpired;
		this.credentialExpried = credentialExpried;
		this.use = use;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountExpired;
	}

	public void setAccountNonExpried(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public void setAccountNonLocked(boolean lock) {
		this.lock = lock;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.lock;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialExpried;
	}

	public void setCredentialsNonExpried(boolean credentialExpried) {
		this.credentialExpried = credentialExpried;
	}

	@Override
	public boolean isEnabled() {
		return this.use;
	}

	public void setEnabled(boolean use) {
		this.use = use;
	}

	public void setEnabled() {
		setEnabled(true);
	}

	public void setDisabled() {
		setEnabled(false);
	}
}
