package com.ctw.glue.unit;

import java.util.List;
import java.util.Objects;

public class Unit {

    private String name;
    private String description;
    private String id;
    private List<String> teams;

    public Unit() {
    }

    public Unit(String name, String description, String id, List<String> teams) {
        this.name = name;
        this.description = description;
        this.id = id;
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

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    public List<String> getTeams() { return teams; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Unit)) {
            return false;
        }

        Unit other = (Unit) obj;

        return Objects.equals(other.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
