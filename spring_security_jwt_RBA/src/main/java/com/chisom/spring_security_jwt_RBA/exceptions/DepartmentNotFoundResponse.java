package com.chisom.spring_security_jwt_RBA.exceptions;

public class DepartmentNotFoundResponse {

    private String departmentName;

    public DepartmentNotFoundResponse(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
