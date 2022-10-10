package org.bcquintela.glue.employee;

import java.util.List;
import java.util.Objects;

public class Employee {

    private String name;
    private String employeeNo;
    private String id;
    private String unit;
    private List<String> projects;
    private List<String> expertise;

    public Employee() {
    }

    public Employee(String name, String employeeNo, String id, String unit, List<String> projects,
                    List<String> expertise) {
        this.name = name;
        this.employeeNo = employeeNo;
        this.id = id;
        this.unit = unit;
        this.projects = projects;
        this.expertise = expertise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setExpertise(List<String> expertise) {
        this.expertise = expertise;
    }

    public List<String> getExpertise() {
        return expertise;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;

        return Objects.equals(other.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
