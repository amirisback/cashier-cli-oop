package cashier.oop;

import cashier.oop.model.User;
import cashier.oop.mvvm.LoginListener;
import cashier.oop.mvvm.LoginViewModel;
import cashier.oop.mvvm.MainViewModel;
import cashier.oop.ui.LoginUI;
import cashier.oop.ui.WareHouseUI;

public class Main implements LoginListener {

    public static void main(String[] args) {
        // write your code here
        do {
            LoginUI.INSTANCE.createUI(new Main());
        } while (!MainViewModel.isExit);
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
