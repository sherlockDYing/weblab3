package com.lab3.demo.request;
//对应 RequestBody 的类不能有 Constructor，这是 jackson 库的一个限制
public class UserLoginRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
