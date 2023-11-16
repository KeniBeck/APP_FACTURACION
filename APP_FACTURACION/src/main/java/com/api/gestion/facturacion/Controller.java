package com.api.gestion.facturacion;

import com.api.gestion.facturacion.model.Empleado;
import com.api.gestion.facturacion.servicio.EmpleadoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class Controller {


    public TextField txt_usuario;
    public TextField txt_contraseña;
    public Label label_recuperar;
    public Button btn_ingresar;
    public Label label_crear;


    private void abrirVentanaRegistro() throws IOException {

    }

    public void onRegistrar(MouseEvent mouseEvent) {
        //EmpleadoService.guardarEmpleado(new Empleado(12, "Maria", "Admin", 34, 45.5, 43.2));
    }


    public void crear_cuenta(MouseEvent mouseEvent) throws IOException {

        try {
            Registro registro = new Registro();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Parent root = FXMLLoader.load(getClass().getResource("/Registro.fxml"));
        Stage stage = Login.getStage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    }





