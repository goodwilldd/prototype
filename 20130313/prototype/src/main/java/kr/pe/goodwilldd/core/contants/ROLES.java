package kr.pe.goodwilldd.core.contants;

public enum ROLES {
	USER("ROLE_USER"), ADMIN("ROLE_ADM"), SUPERADMIN("ROLE_SADM");

	private String roleName;

	private ROLES(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return this.roleName;
	}
}
