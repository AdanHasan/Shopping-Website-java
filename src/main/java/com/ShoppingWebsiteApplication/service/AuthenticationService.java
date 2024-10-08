package com.ShoppingWebsiteApplication.service;


import com.ShoppingWebsiteApplication.security.model.AuthenticationRequest;
import com.ShoppingWebsiteApplication.security.model.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;
}