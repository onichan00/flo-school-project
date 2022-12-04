package com.hva.helios.models.user;

public class LoginResponse {
    private Long id;
    private boolean isAdmin;
    private boolean isClient;
    private boolean isSpecialist;
    public LoginResponse() {

    }

    public LoginResponse(Long id, boolean isAdmin, boolean isClient, boolean isSpecialist) {
        this.id = id;
        this.isAdmin = isAdmin;
        this.isClient = isClient;
        this.isSpecialist = isSpecialist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isClient() {
        return isClient;
    }

    public void setClient(boolean client) {
        isClient = client;
    }

    public boolean isSpecialist() {
        return isSpecialist;
    }

    public void setSpecialist(boolean specialist) {
        isSpecialist = specialist;
    }
}
