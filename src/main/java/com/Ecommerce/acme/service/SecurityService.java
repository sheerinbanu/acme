package com.Ecommerce.acme.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
