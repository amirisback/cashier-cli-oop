package cashier.oop.ui;

import cashier.oop.core.CoreUI;
import cashier.oop.model.User;
import cashier.oop.mvvm.LoginListener;
import cashier.oop.mvvm.LoginViewModel;

import static cashier.oop.util.Constant.*;


/*
 * Created by faisalamir on 05/04/22
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


public class LoginUI extends CoreUI implements LoginListener {

    public static void createUI() {
        System.out.println(LINE_BORDER);
        System.out.println("SELAMAT DATANG DI " + STORE_NAME.toUpperCase());
        System.out.println("UNTUK MEMULAI APLIKASI " + APP_NAME.toUpperCase());
        System.out.println("SILAHKAN LOGIN UNTUK MELANJUTKAN");
        System.out.println(LINE_BORDER);

        System.out.print("Username : ");
        String username = sc.nextLine();
        System.out.print("Password : ");
        String password = sc.next();

        System.out.println(LINE_BORDER);
        LoginViewModel.login(username, password, new LoginUI());
    }

    @Override
    public void onSuccesLogin(User user, String message) {
        do {
            WareHouseUI.createUI();
        } while (LoginViewModel.isLogin);
    }

    @Override
    public void onFailedLogin(String message) {
        System.out.println(message);
    }
}
