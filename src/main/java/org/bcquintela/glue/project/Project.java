package org.bcquintela.glue.project;

import java.util.List;
import java.util.Objects;

public class Project {

    private String name;
    private String description;
    private String id;
    private String unit;
    private List<String> teams;

    public Project() {
    }

    public Project(String name, String description, String id, String unit, List<String> teams) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.unit = unit;
        this.teams = teams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    public List<String> getTeams() {
        return teams;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Project)) {
            return false;
        }

        Project other = (Project) obj;

        return Objects.equals(other.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
