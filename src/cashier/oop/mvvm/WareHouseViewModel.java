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

import static cashier.oop.util.Constant.INSTANCE.ITEM_JENIS_MAKANAN;

public class WareHouseViewModel {

    public static class INSTANCE {

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

        public static void showData(GetDataProductListener listener) {
            for (int i = 0; i < dataProduct.size(); i++) {
                listener.onShowDataProduct(i, dataProduct.get(i));
            }
        }

        public static void addDummyDataProduct() {
            tambahProduct("1","MartabakSapi",31000, ITEM_JENIS_MAKANAN);
            tambahProduct("2","MartabakSapiSpesial",39000, ITEM_JENIS_MAKANAN);
        }

    }

    public interface GetDataProductListener {
        void onShowDataProduct(int index, Item produk);
    }

}
