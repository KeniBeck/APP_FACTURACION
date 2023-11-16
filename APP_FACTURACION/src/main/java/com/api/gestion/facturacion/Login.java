package com.api.gestion.facturacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {
    private static Stage main = new Stage();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Facturacion");
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
    }

public static Stage getStage(){
        return main;
    }
    public static void main(String[] args) {
        launch();
    }
}