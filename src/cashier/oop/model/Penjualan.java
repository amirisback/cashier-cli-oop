package cashier.oop.model;
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

import java.util.ArrayList;

public class Penjualan {
    private String idPenjualan;
    private ArrayList<Item> product;
    private int totalTagihan = 0;

    public Penjualan(String idPenjualan, ArrayList<Item> product) {
        this.idPenjualan = idPenjualan;
        this.product = product;
        for (int i = 0; i < product.size(); i++) {
            totalTagihan = totalTagihan + product.get(i).hargaBarang;
        }
    }

    public String getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(String idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public ArrayList<Item> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Item> product) {
        this.product = product;
    }

    public int getTotalTagihan() {
        return totalTagihan;
    }

    public void setTotalTagihan(int totalTagihan) {
        this.totalTagihan = totalTagihan;
    }

}