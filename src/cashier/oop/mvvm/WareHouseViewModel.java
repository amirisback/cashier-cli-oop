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

import java.util.ArrayList;

public class WareHouseViewModel {

    public static class INSTANCE {

        public static final String ITEM_JENIS_MAKANAN = "Makanan"; // Constant untuk pengecekan percabangan ketika item makanan
        public static final String ITEM_JENIS_MINUMAN = "Minuman"; // Constant untuk pengecekan percabangan ketika item minuman
        public static final String ITEM_JENIS_SNACK = "Snack"; // Constant untuk pengecekan percabangan ketika item snack

        public static final String BASE_ID_MAKANAN = "MAKANAN_";
        public static final String BASE_ID_MINUMAN = "MINUMAN_";
        public static final String BASE_ID_SNACK = "SNACK_";

        public static ArrayList<Item> dataProduct = new ArrayList<>();

        public static void tambahProduct(String idProduct, String namaProduct, int hargaProduct, String jenisProduct) {
            dataProduct.add(new Item(idProduct, namaProduct, hargaProduct, jenisProduct));
        }

        public static void hapusSemua() {
            dataProduct.removeAll(dataProduct);
        }

        public static void hapusProductByNama(String namaProduct) {
            dataProduct.removeIf(n -> (n.getNamaBarang().equals(namaProduct)));
        }

        public static void hapusProductById(String idProduct) {
            dataProduct.removeIf(n -> (n.getIdBarang().equals(idProduct)));
        }

        public static void hapusProductByJenis(String jenisProduct) {
            dataProduct.removeIf(n -> (n.getJenis().equals(jenisProduct)));
        }

        public static void hapusProductByHarga(int hargaBarang) {
            dataProduct.removeIf(n -> (n.getHargaBarang() == hargaBarang));
        }

        public static void ubahProduct(int index, Item produk) {
            dataProduct.set(index, produk);
        }

        public static void showData(WareHouseListener.GetDataProduct listener) {
            if (dataProduct.isEmpty()) {
                listener.onEmptyDataProduct("Data produk kosong silahkan tambahkan produk");
            } else {
                for (int i = 0; i < dataProduct.size(); i++) {
                    listener.onShowDataProduct(i, dataProduct.get(i));
                }
            }
        }

        public static void showData(String sortByJenis, WareHouseListener.GetDataProduct listener) {
            if (dataProduct.isEmpty()) {
                listener.onEmptyDataProduct("Data produk kosong silahkan tambahkan produk");
            } else {
                for (int i = 0; i < dataProduct.size(); i++) {
                    if (dataProduct.get(i).getJenis().equals(sortByJenis)) {
                        listener.onShowDataProduct(i, dataProduct.get(i));
                    }
                }
            }
        }

        public static void addDummyDataProduct() {
            tambahProduct(BASE_ID_MAKANAN + "1", "Martabak Sapi", 31000, ITEM_JENIS_MAKANAN);
            tambahProduct(BASE_ID_MAKANAN + "2", "Martabak Sapi Spesial", 39000, ITEM_JENIS_MAKANAN);
        }

    }

}
