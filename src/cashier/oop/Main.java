package cashier.oop;

import cashier.oop.model.User;
import cashier.oop.mvvm.LoginListener;
import cashier.oop.ui.LoginUI;
import cashier.oop.ui.WareHouseUI;

public class Main implements LoginListener {

    public static void main(String[] args) {
        // write your code here
        LoginUI.INSTANCE.createUI(new Main());
    }

    @Override
    public void onSuccesLogin(User user, String message) {
        WareHouseUI.INSTANCE.createUI();
    }

    @Override
    public void onFailedLogin(String message) {
        System.out.println(message);
    }

}
