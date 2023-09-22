package com.example.coba.model;

import com.example.coba.model.Akun;

public class Transaksi {
    private String noTransaksi;
    private String tglTransaksi;
    private long nominal;

    // transfer
    private String noRekTujuan="";
    private String bankTujuan="";

    // pembayaran
    private String noPembayaran="";

    private String namaUniv="";
    private String NIM="";

    private String namaPT="";
    private String noPelanggan="";

    private String noTagihan="";

    public Transaksi(String noTransaksi, String tglTransaksi, long nominal, String noRekTujuan, String bankTujuan, String noPembayaran, String namaUniv, String NIM, String namaPT, String noPelanggan, String noTagihan) {
        this.noTransaksi = noTransaksi;
        this.tglTransaksi = tglTransaksi;
        this.nominal = nominal;
        this.noRekTujuan = noRekTujuan;
        this.bankTujuan = bankTujuan;
        this.noPembayaran = noPembayaran;
        this.namaUniv = namaUniv;
        this.NIM = NIM;
        this.namaPT = namaPT;
        this.noPelanggan = noPelanggan;
        this.noTagihan = noTagihan;
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public long getNominal() {
        return nominal;
    }

    public void setNominal(long nominal) {
        this.nominal = nominal;
    }

    public String getNoRekTujuan() {
        return noRekTujuan;
    }

    public void setNoRekTujuan(String noRekTujuan) {
        this.noRekTujuan = noRekTujuan;
    }

    public String getBankTujuan() {
        return bankTujuan;
    }

    public void setBankTujuan(String bankTujuan) {
        this.bankTujuan = bankTujuan;
    }

    public String getNoPembayaran() {
        return noPembayaran;
    }

    public void setNoPembayaran(String noPembayaran) {
        this.noPembayaran = noPembayaran;
    }

    public String getNamaUniv() {
        return namaUniv;
    }

    public void setNamaUniv(String namaUniv) {
        this.namaUniv = namaUniv;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNamaPT() {
        return namaPT;
    }

    public void setNamaPT(String namaPT) {
        this.namaPT = namaPT;
    }

    public String getNoPelanggan() {
        return noPelanggan;
    }

    public void setNoPelanggan(String noPelanggan) {
        this.noPelanggan = noPelanggan;
    }

    public String getNoTagihan() {
        return noTagihan;
    }

    public void setNoTagihan(String noTagihan) {
        this.noTagihan = noTagihan;
    }
}
