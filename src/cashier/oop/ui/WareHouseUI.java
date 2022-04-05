package cashier.oop.ui;
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

import cashier.oop.model.Item;
import cashier.oop.mvvm.LoginViewModel;
import cashier.oop.mvvm.MainViewModel;
import cashier.oop.mvvm.WareHouseListener;
import cashier.oop.mvvm.WareHouseViewModel;

import java.util.Scanner;

import static cashier.oop.util.Constant.LINE_BORDER;

public class WareHouseUI implements WareHouseListener.GetDataProduct {

    private static final Scanner sc = new Scanner(System.in);

    public static void createUI() {
        do {
            System.out.println(">> Data Master Menu");
            System.out.println(LINE_BORDER);
            System.out.println("1. Melihat Daftar Product");
            System.out.println("2. Menambah Product");
            System.out.println("3. Mengubah Product");
            System.out.println("4. Menghapus Product");
            System.out.println("5. Menambah Product (Dummy)");
            System.out.println("8. Logout");
            System.out.println("9. Exit Program");
            System.out.println(LINE_BORDER);
            System.out.print("Menu Pilihan \t\t : ");
            int menu = sc.nextInt();
            if (menu == 1) {
                showProductUI();
            } else if (menu == 2) {
                addProductUI();
            } else if (menu == 3) {

            } else if (menu == 4) {

            } else if (menu == 5) {
                WareHouseViewModel.addDummyDataProduct();
            } else if (menu == 8) {
                WareHouseViewModel.stopLoop();
                LoginViewModel.doLogout();
            } else if (menu == 9) {
                WareHouseViewModel.stopLoop();
                MainViewModel.doExit();
            }
        } while (WareHouseViewModel.isLooping);

    }

    public static void addProductUI() {

        String idProduk = "";
        String jenisProduk = "";

        System.out.print("Nama Produk \t\t: ");
        String namaProduk = sc.next();
        System.out.print("Harga Produk \t\t: ");
        int hargaProduk = sc.nextInt();

        System.out.println("Silahkan Pilih Jenis Produk");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.println("3. Snack");
        System.out.print("Jenis Produk \t\t: ");
        int inputJenis = sc.nextInt();
        if (inputJenis == 1) {
            idProduk = WareHouseViewModel.BASE_ID_MAKANAN + WareHouseViewModel.dataProduct.size();
            jenisProduk = WareHouseViewModel.ITEM_JENIS_MAKANAN;
        } else if (inputJenis == 2) {
            idProduk = WareHouseViewModel.BASE_ID_MINUMAN + WareHouseViewModel.dataProduct.size();
            jenisProduk = WareHouseViewModel.ITEM_JENIS_MINUMAN;
        } else if (inputJenis == 3) {
            idProduk = WareHouseViewModel.BASE_ID_SNACK + WareHouseViewModel.dataProduct.size();
            jenisProduk = WareHouseViewModel.ITEM_JENIS_SNACK;
        }

        WareHouseViewModel.tambahProduct(idProduk, namaProduk, hargaProduk, jenisProduk);

    }

    public static void showProductUI() {
        System.out.println(LINE_BORDER);
        WareHouseViewModel.showData(new WareHouseUI());
        System.out.println(LINE_BORDER);
    }

    @Override
    public void onShowDataProduct(int index, Item produk) {
        System.out.println((index + 1) + ". " + produk.getIdBarang() + "\t" + produk.getNamaBarang() + "\t\t" + produk.getHargaBarang() + "\t" + produk.getJenis());
    }

    @Override
    public void onEmptyDataProduct(String message) {
        System.out.println(message);
    }

}