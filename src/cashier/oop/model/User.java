package cashier.oop.model;
/*
 * Created by faisalamir on 03/04/22
 * cashier-cli-oop
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 FrogoBox Inc.
 * All rights reserved
 *
 */

public class User {

    private String username;
    private String password;
    private String nama;
    private int role;

    public User(String username, String password, String nama, int role) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.role = role;
    }

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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
