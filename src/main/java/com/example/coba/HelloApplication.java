package com.example.coba;

import com.example.coba.model.Akun;
import com.example.coba.model.AkunData;
import com.example.coba.model.Nasabah;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 720);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        AkunData akunData = new AkunData();

        Nasabah nasabah1 = new Nasabah("Michael Fidef", "michael.fidef@gmail.com", "0987654321", "25/12/2002", "Yogyakarta");
        Nasabah nasabah2 = new Nasabah("Angela Gracia", "angela.gracia@gmail.com", "0988877711", "21/01/2002", "Yogyakarta");

        Akun akun1 = new Akun(nasabah1, "fidef", "fidef", "123123", "2525");
        Akun akun2 = new Akun(nasabah2, "angela","angela", "11122","1234");

        akunData.tambahAkun(akun1);
        akunData.tambahAkun(akun2);


        launch();
    }
}