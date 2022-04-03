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

public class Item extends BaseItem {

    protected String jenis;

    public Item(String idBarang, String namaBarang, String hargaBarang) {
        super(idBarang, namaBarang, hargaBarang);
    }

    public Item(String idBarang, String namaBarang, String hargaBarang, String jenis) {
        super(idBarang, namaBarang, hargaBarang);
        this.jenis = jenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

}