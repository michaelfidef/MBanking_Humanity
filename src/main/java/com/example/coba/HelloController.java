package com.example.coba;

import com.example.coba.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Stack;

public class HelloController{
    @FXML
    private Label welcomeText;
    private Parent parent;
    private Stage stage;
    private Scene scene;

    // login
    @FXML
    private Button loginBTN;
    @FXML
    private TextField usernameTextfield;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginLabel;
    @FXML
    private Hyperlink toSignUp;

    // registrasi
    @FXML
    private Button lanjutRegis;
    @FXML
    private TextField namaRegis;
    @FXML
    private TextField NIKRegis;
    @FXML
    private TextField domRegis;
    @FXML
    private TextField tglLahirRegis;
    @FXML
    private TextField emailRegis;
    @FXML
    private TextField usernameRegis;
    @FXML
    private TextField passwordRegis;
    @FXML
    private TextField konfPasswordRegis;
    @FXML
    private Button okeBTNBlokr;
    @FXML
    private TextField PINRegis;
    @FXML
    private Hyperlink toSignIn;
    @FXML
    private Label regis1Label;
    @FXML
    private Label regis2Label;

    // home
    @FXML
    private Button codeBTN;
    @FXML
    private PasswordField PINverifBlokir;
    @FXML
    private TextField usernameBlokir;
    @FXML
    private Button homeBTN;
    @FXML
    private Button pesanBTN;
    @FXML
    private Button setingBTN;
    @FXML
    private Button informasiAkunBTN;
    @FXML
    private Button transaksiBTN;
    @FXML
    private Button blokirKartuBTN;
    @FXML
    private Label norekLabel;
    @FXML
    private Label saldoLabel;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    private AkunData akunData = new AkunData();
    private AkunTransaksi akunTransaksi = new AkunTransaksi();

    // blokir

    // login


    public void loginBTNonaction(ActionEvent e) throws IOException {
        checkLogin();
        if(checkLogin()) {
            System.out.println(Data.akun.getUsername()); // cek akun
            System.out.println(Data.akun.getNoRek()); // cek norek
            System.out.println(Data.akun.getSaldo()); // cek saldo
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("halamanUtama.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public Boolean checkLogin() {
        Boolean valid = false;
        if (akunData.verifikasiAkun(usernameTextfield.getText(), passwordField.getText())){
            Data.akun = (Akun) akunData.getAkun(usernameTextfield.getText());
            valid = true;
        }
        else if (usernameTextfield.getText().isEmpty() || passwordField.getText().isEmpty()){
            loginLabel.setText("Silahkan mengisi username dan password");
        }
        else {
            loginLabel.setText("Username atau Password Salah");
        }
        return valid;
    }
    // logout

    public void logoutBTNonaction(ActionEvent a) throws IOException{
        Parent  root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage)((Node)a.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void signInLinkonaction(ActionEvent a) throws IOException{
        Parent  root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage)((Node)a.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // registrasi
    public void signUpLinkonaction(ActionEvent a) throws IOException{
        Parent  root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registrasi1.fxml")));
        stage = (Stage)((Node)a.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void lanjutRegisBTNonaction(ActionEvent a) throws IOException {
        checkRegis1();
        if(checkRegis1()) {
            simpanNasabah();
            Parent  root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registrasi2.fxml")));
            stage = (Stage)((Node)a.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public Boolean checkRegis1() {
        Boolean valid = false;
        if (namaRegis.getText().isEmpty() || NIKRegis.getText().isEmpty() || domRegis.getText().isEmpty() || tglLahirRegis.getText().isEmpty() || emailRegis.getText().isEmpty()) {
            regis1Label.setText("Silahkan mengisi semua data");
        }
        else {
            valid = true;
        }
        return valid;
    }
    public void simpanNasabah() {
        String nama = namaRegis.getText();
        String NIK = NIKRegis.getText();
        String tglLahir = tglLahirRegis.getText();
        String email = emailRegis.getText();
        String dom = domRegis.getText();

        Nasabah nasabahBaru = new Nasabah(nama, email, NIK, tglLahir, dom);
        Data.nasabah = (Nasabah) nasabahBaru;
    }

    public void selesaiRegisBTNonaction(ActionEvent a) throws IOException {
        checkRegis2();
        if (checkRegis2()) {
            simpanAkun();
            Parent  root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            stage = (Stage)((Node)a.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public Boolean checkRegis2() {
        Boolean valid = false;
        if (usernameRegis.getText().isEmpty() || passwordRegis.getText().isEmpty() || konfPasswordRegis.getText().isEmpty() || PINRegis.getText().isEmpty()) {
            regis2Label.setText("Silahkan mengisi data");
        }
        else if (!passwordRegis.getText().equals(konfPasswordRegis.getText())) {
            regis2Label.setText("Password tidak sama");
        }
        else {

            valid = true;
        }
        return valid;
    }
    public void simpanAkun() {
        String uname = usernameRegis.getText();
        String pass = passwordRegis.getText();
        String PIN = PINRegis.getText();
        String noRek;
        int m = (int) Math.pow(10, 8 - 1);
        m = m + new Random().nextInt(9 * m);
        noRek = String.valueOf(m);

        Akun akunBaru = new Akun(Data.nasabah, uname, pass, noRek, PIN);
        akunData.tambahAkun(akunBaru);
        System.out.println(akunData.getAkun(uname).getUsername()); // cek akunData
    }
    // home



    public void homeBTNonaction(ActionEvent ae) throws IOException{
        Parent  root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("halamanUtama.fxml")));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setLabel() {
        String norek = Data.akun.getNoRek();
        String msaldo = Long.toString(Data.akun.getSaldo());
        norekLabel.setText(Data.akun.getNoRek()+"");
        saldoLabel.setText(Data.akun.getSaldo()+"");
    }

    // setting

    public void settingBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("setting.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // informasi akun

    public void infoAkunBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("infoAkun.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // transaksi
    public void transaksiBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("transaksi.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void transferBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("transfer.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void pembayaranBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pembayaran.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void dataTransferBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("daftarDataTransfer.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // transfer

    public void tfAntarBankBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("trAntarBank.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void tfAntarRekBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tfAntarRek.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void lanjutanTransferBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inputPin.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // pembayaran
    public void bayarPDAMBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pembayaranPdamIpl.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void bayarPendidikanBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pembayaranPendidikan.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void bayarPLNBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pembayaranPln.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void lanjutanPembayaranBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inputPin.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // daftar data transfer

    public void daftarTfAntarBankBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("daftarTfAntarBank.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void daftarTfAntarRekBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("daftarTfAntarRek.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void simpanDataBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("simpanData.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // pesan

    public void pesanBTNonaction(ActionEvent ae) throws IOException{
        Parent  root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("notifikasi.fxml")));
        stage = (Stage)((Node)ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void statusTransaksiBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("statusTransaksi.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void notifikasiBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("notifikasi.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // mutasi

    public void mutasiBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mutasi.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // blokir kartu
    public void blokirKartuBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("blokirKartu.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void lanjutanBlokirBTNonaction(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PinBlokir.fxml")));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void validasiBlokirBTNonaction(ActionEvent e) throws IOException{
        boolean isBlokir = blokir();
        if (isBlokir){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
@FXML
private Label textBlokir;
    public boolean blokir() {
        String pin = PINverifBlokir.getText();
        String username = usernameBlokir.getText();
        boolean verifikasi = akunData.verifikasiPIN(username,pin);
        if (verifikasi) {
            akunData.hapusAkun(Data.akun.getUsername());
            Data.akun = null;
            return true;
        }else {
            textBlokir.setText("Username dan password salah!");
            return false;
        }
    }
}