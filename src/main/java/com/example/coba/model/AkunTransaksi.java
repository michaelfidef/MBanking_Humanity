package com.example.coba.model;

import java.util.HashMap;
import java.util.Map;

public class AkunTransaksi {
    private static Map<String, Transaksi> transaksiMap = new HashMap<>();

    public void tambahTransaksi(Transaksi transaksi) {
        transaksiMap.put(transaksi.getNoTransaksi(), transaksi);
    }
    public Transaksi getTransaksi(String noTransaksi) {
        return transaksiMap.get(noTransaksi);
    }

}
