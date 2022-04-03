package cashier.oop;

import cashier.oop.mvvm.LoginViewModel;
import cashier.oop.model.User;

public class Main {

    public static void main(String[] args) {
        // write your code here

        LoginViewModel.INSTANCE.login("admin", "", new LoginViewModel.LoginListener() {
            @Override
            public void onSucces(User user, String message) {
                System.out.println(user.getNama());
                System.out.println(message);
            }

            @Override
            public void onFailed(String message) {
                System.out.println(message);
            }
        });

    }
}
