package com.example.coba.model;

import java.util.HashMap;
import java.util.Map;

public class AkunData {
    private static Map<String, Akun> akunMap = new HashMap<>();

    public AkunData() {

    }

    public void tambahAkun(Akun akun) {
        akunMap.put(akun.getUsername(), akun);
    }
    public Akun getAkun(String username) {
        return akunMap.get(username);
    }
    public void hapusAkun(String username) {
        akunMap.remove(username);
    }

    public Boolean verifikasiAkun(String username, String password) {
        Akun tmp = getAkun(username);
        return tmp != null && tmp.getPassword().equals(password);
    }
    public Boolean verifikasiPIN(String username, String pin) {
        Akun tmp = getAkun(username);
        return tmp.getPIN().equals(pin);
    }
}
