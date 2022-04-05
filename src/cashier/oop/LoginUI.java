package cashier.oop;

import cashier.oop.mvvm.LoginViewModel;

import java.util.Scanner;

import static cashier.oop.util.Constant.INSTANCE.*;

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


public class LoginUI {

    public static class INSTANCE {

        public static void createUI(LoginViewModel.LoginListener listener) {
            System.out.println(LINE_BORDER);
            System.out.println("SELAMAT DATANG DI " + STORE_NAME.toUpperCase());
            System.out.println("UNTUK MEMULAI APLIKASI " + APP_NAME.toUpperCase());
            System.out.println("SILAHKAN LOGIN UNTUK MELANJUTKAN");
            System.out.println(LINE_BORDER);
            Scanner inputLogin = new Scanner(System.in);
            System.out.print("Username : ");
            String username = inputLogin.nextLine();
            System.out.print("Password : ");
            String password = inputLogin.next();
            System.out.println(LINE_BORDER);
            LoginViewModel.INSTANCE.login(username, password, listener);
        }

    }


}
