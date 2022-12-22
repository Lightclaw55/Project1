package com.revature.models;

public class Role {

    private int roleId;
    private String roleTitle;

    public Role() {
    }

    public Role(int roleId, String roleTitle) {
        this.roleId = roleId;
        this.roleTitle = roleTitle;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    @Override
    public String toString() {
        return "Role{" +
                "RoleId=" + roleId +
                ", RoleTitle='" + roleTitle + '\'' +
                '}';
    }
}
