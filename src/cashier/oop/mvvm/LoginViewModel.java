package cashier.oop.mvvm;
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

import cashier.oop.model.User;

import java.util.ArrayList;

public class LoginViewModel {

    public static boolean isLogin = false;

    public static void doLogout() {
        isLogin = false;
    }

    public final static int ROLE_ADMIN = 1;

    public static ArrayList<User> dummyUser() {
        ArrayList<User> data = new ArrayList<>();
        data.add(new User("admin", "admin", "admin", ROLE_ADMIN));
        return data;
    }

    public static void login(ArrayList<User> data, String username, String password, LoginListener listener) {
        if (username != null && password != null) {
            if (!username.equals("") && !password.equals("")) {
                for (User datum : data) {
                    if (username.equals(datum.getUsername()) && password.equals(datum.getPassword())) {
                        listener.onSuccesLogin(datum, "Berhasil Login");
                        isLogin = true;
                        break;
                    } else {
                        isLogin = false;
                        listener.onFailedLogin("Username atau Password Salah");
                    }
                }

            } else {
                isLogin = false;
                listener.onFailedLogin("Username atau Password Tidak Boleh Kosong");
            }
        } else {
            isLogin = false;
            listener.onFailedLogin("Username atau Password Tidak Boleh Kosong");
        }
    }

    public static void login(String username, String password, LoginListener listener) {
        login(dummyUser(), username, password, listener);
    }

}