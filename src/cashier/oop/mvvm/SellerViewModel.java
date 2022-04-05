package cashier.oop.mvvm;
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
import cashier.oop.model.Penjualan;
import cashier.oop.util.Constant;

import java.util.ArrayList;

public class SellerViewModel {

    public static ArrayList<Penjualan> dataPenjualan = new ArrayList<>();

    public static boolean isLooping = true;

    public static void stopLoop() {
        isLooping = false;
    }

    public static void tambahPenjualan(String idPenjualan, ArrayList<Item> product) {
        dataPenjualan.add(new Penjualan(idPenjualan, product, Constant.getDateTimeNow()));
    }

    public static void hapusSemua() {
        dataPenjualan.removeAll(dataPenjualan);
    }

    public static void hapusPenjualanByDate(String tanggalPenjualan) {
        dataPenjualan.removeIf(n -> (n.getTanggal().equals(tanggalPenjualan)));
    }

    public static void hapusPenjualanById(String idPenjualan) {
        dataPenjualan.removeIf(n -> (n.getIdPenjualan().equals(idPenjualan)));
    }

    public static void ubahPenjualan(int index, Penjualan penjualan) {
        dataPenjualan.set(index, penjualan);
    }

    public static void showData(SellerListener.GetDataPenjualan listener) {
        if (dataPenjualan.isEmpty()) {
            listener.onEmptyDataPenjualan("Data produk kosong silahkan tambahkan produk");
        } else {
            for (int i = 0; i < dataPenjualan.size(); i++) {
                listener.onShowDataPenjualan(i, dataPenjualan.get(i));
            }
        }
    }

    public static void showData(String sortbyDate, SellerListener.GetDataPenjualan listener) {
        if (dataPenjualan.isEmpty()) {
            listener.onEmptyDataPenjualan("Data produk kosong silahkan tambahkan produk");
        } else {
            for (int i = 0; i < dataPenjualan.size(); i++) {
                if (dataPenjualan.get(i).getTanggal().equals(sortbyDate)) {
                    listener.onShowDataPenjualan(i, dataPenjualan.get(i));
                }
            }
        }
    }

}
