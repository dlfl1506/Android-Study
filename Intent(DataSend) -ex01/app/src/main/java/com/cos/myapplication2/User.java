package com.cos.myapplication2;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;

    // Alt + insert 키 누르면 게터세터,생성자 를 바로 만들수있음 !!   ( sts tool에  시프트 +알트 + s 랑 똑같다)

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
