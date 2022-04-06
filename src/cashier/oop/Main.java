package cashier.oop;

import cashier.oop.mvvm.MainViewModel;
import cashier.oop.ui.LoginUI;

public class Main {

    public static void main(String[] args) {
        // write your code here
        do {
            LoginUI.createUI();
        } while (!MainViewModel.isExit);
    }

}
