package org.bcquintela.glue.expertise;

import java.util.Objects;

public class Expertise {

    private String name;
    private String id;

    public Expertise() {
    }

    public Expertise(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Expertise)) {
            return false;
        }

        Expertise other = (Expertise) obj;

        return Objects.equals(other.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
