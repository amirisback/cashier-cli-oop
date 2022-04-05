package cashier.oop.model;
/*
 * Created by faisalamir on 04/04/22
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

abstract class BaseItem {

    protected String idBarang;
    protected String namaBarang;
    protected int hargaBarang;

    public BaseItem(String idBarang, String namaBarang, int hargaBarang) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
}
