package org.dropsjtu.backend.login;

public class AuthResult {
    private int code = -1;       // 0 ok, 1 username/password wrong
    private String token = "";

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
