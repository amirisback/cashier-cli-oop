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
import cashier.oop.mvvm.WareHouseListener;
import cashier.oop.mvvm.WareHouseViewModel;
import cashier.oop.util.Constant;

import java.util.Scanner;

public class WareHouseUI implements WareHouseListener.GetDataProduct {

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public void onShowDataProduct(int index, Item produk) {
        System.out.println(index + ". " + produk.getNamaBarang() + "\t" + produk.getHargaBarang() + "\t" + produk.getJenis());
    }

    @Override
    public void onEmptyDataProduct(String message) {
        System.out.println(message);
    }

    public static class INSTANCE {

        public static void createUI() {
            System.out.println("");
            System.out.println("1. Melihat Daftar Product");
            System.out.println("2. Menambah Product");
            System.out.println("3. Mengubah Product");
            System.out.println("4. Menghapus Product");
            System.out.println("8. Logout");
            System.out.println("9. Exit Program");
            System.out.println(Constant.INSTANCE.LINE_BORDER);
            System.out.print("Menu Pilihan \t\t : ");
            int menu = sc.nextInt();
            if (menu == 1) {
                showProductUI();
            } else if (menu == 2) {
                addProductUI();
            }
        }

        public static void addProductUI() {

            String idProduk = "";
            String jenisProduk = "";

            System.out.print("Nama Produk : ");
            String namaProduk = sc.nextLine();
            System.out.print("Harga Produk : ");
            int hargaProduk = sc.nextInt();

            System.out.println("Silahkan Pilih Jenis Produk");
            System.out.println("1. Makanan");
            System.out.println("2. Minuman");
            System.out.println("3. Snack");
            System.out.print("Jenis Produk : ");
            int inputJenis = sc.nextInt();
            if (inputJenis == 1) {
                idProduk = WareHouseViewModel.INSTANCE.BASE_ID_MAKANAN + WareHouseViewModel.INSTANCE.dataProduct.size();
                jenisProduk = WareHouseViewModel.INSTANCE.ITEM_JENIS_MAKANAN;
            } else if (inputJenis == 2) {
                idProduk = WareHouseViewModel.INSTANCE.BASE_ID_MINUMAN + WareHouseViewModel.INSTANCE.dataProduct.size();
                jenisProduk = WareHouseViewModel.INSTANCE.ITEM_JENIS_MINUMAN;
            } else if (inputJenis == 3) {
                idProduk = WareHouseViewModel.INSTANCE.BASE_ID_SNACK + WareHouseViewModel.INSTANCE.dataProduct.size();
                jenisProduk = WareHouseViewModel.INSTANCE.ITEM_JENIS_SNACK;
            }

            WareHouseViewModel.INSTANCE.tambahProduct(idProduk, namaProduk, hargaProduk, jenisProduk);

        }

        public static void showProductUI() {
            WareHouseViewModel.INSTANCE.showData(new WareHouseUI());
        }

    }

}