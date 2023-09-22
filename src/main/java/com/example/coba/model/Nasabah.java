package com.example.coba.model;

public class Nasabah {
    private String nama;
    private String email;
    private String NIK;
    private String tglLahir;
    private String domisili;

    public Nasabah(String nama, String email, String NIK, String tglLahir, String domisili) {
        this.nama = nama;
        this.email = email;
        this.NIK = NIK;
        this.tglLahir = tglLahir;
        this.domisili = domisili;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }
}
