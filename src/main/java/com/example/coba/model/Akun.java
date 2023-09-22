package com.example.coba.model;

public class Akun {
    private Nasabah nasabah;
    private String username;
    private String password;

    // rekening
    private String noRek;
    private String PIN;
    private long saldo;
    private long limit;

    public boolean isBlokir() {
        return isBlokir;
    }

    private boolean isBlokir = false;

    public Akun(Nasabah nasabah, String username, String password, String noRek, String PIN) {
        this.nasabah = nasabah;
        this.username = username;
        this.password = password;
        this.PIN = PIN;
        this.noRek = noRek;
        this.saldo = 1000000;
        this.limit = 5000000;
        this.isBlokir = false;
    }


    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    public void setBlokir(boolean blokir) {
        isBlokir = blokir;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getNoRek() {
        return noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }
}
