package cashier.oop;

import cashier.oop.model.Item;
import cashier.oop.model.User;
import cashier.oop.mvvm.LoginViewModel;
import cashier.oop.mvvm.WareHouseViewModel;

public class Main implements LoginViewModel.LoginListener, WareHouseViewModel.GetDataProductListener {

    public static void main(String[] args) {
        // write your code here
        LoginUI.INSTANCE.createUI(new Main());
    }

    @Override
    public void onSuccesLogin(User user, String message) {
        WareHouseViewModel.INSTANCE.addDummyDataProduct();
        WareHouseViewModel.INSTANCE.showData(new Main());
    }

    @Override
    public void onFailedLogin(String message) {

    }

    @Override
    public void onShowDataProduct(int index, Item produk) {
        System.out.println(index + ". " + produk.getNamaBarang());
    }

}
