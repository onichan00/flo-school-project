package com.hva.helios.models;

import java.util.Objects;

public class Language {
    private int id;
    private String name;
    private int level;

    public Language(int id) {
        this.id = id;

        this.name = "Not given";
        this.level = 0;
    }

    public Language(int id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("%d/%s/%d", id, name, level);
    }

    /**
     * Method that will check if two languages are equal based on the id
     * @param o - Object of other language
     * @return - True if the id matches
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return id == language.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }
}
