package com.laborator.proiect.auth;

public interface Authenticable {
    String DEFAULT_TOKEN = "Medical Room";
    String getHashPassword();
    String getUserName();
    String getToken();
}
