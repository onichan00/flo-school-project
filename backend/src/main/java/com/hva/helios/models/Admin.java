package com.hva.helios.models;

public class Admin implements ProfileExtension {
    private String[] rights;

    public Admin(String[] rights) {
        this.rights = rights;
    }
}
