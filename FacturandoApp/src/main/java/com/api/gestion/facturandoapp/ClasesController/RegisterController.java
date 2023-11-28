package com.api.gestion.facturandoapp.ClasesController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterController {
    public TextField txt_recontra;
    public CheckBox chkMostrarContrasena;

    @FXML
    public TextField txt_nombres;
    @FXML
    public TextField txt_id;
    @FXML
    public TextField txt_fecha;
    @FXML
    public TextField txt_telefono;
    @FXML
    public TextField txt_contra;
    private ActionEvent actionEvent;
    private Stage stage;
    private RegisterController registerController;




        // Método para guardar los datos en la base de datos
        public void guardarDatos() {
            // Obtén los valores de los campos de texto
            String nombre = txt_nombres.getText();
            String idStr = txt_id.getText();
            String fecha_nacimiento = txt_fecha.getText();
            String telefono = txt_telefono.getText();
            String contraseña = txt_contra.getText();
            String recontra = txt_recontra.getText();

            // Valida si los campos requeridos están llenos
            if (nombre.isEmpty() || idStr.isEmpty() || fecha_nacimiento.isEmpty() || telefono.isEmpty() || contraseña.isEmpty()) {
                // Puedes mostrar un mensaje de error o realizar alguna acción aquí
                mostrarAlerta("Error", "Faltan campos", "ingrese todos los campos requeridos.");
                return;

            } else if (!contraseña.equals(recontra)) {
                mostrarAlerta("Error", "Contraseñas no coinciden", "Las contraseñas ingresadas no coinciden.");
                return;
            } else if (contraseña.length() > 8 || recontra.length() > 8) {
                mostrarAlerta("Error", "Contraseña demasiado larga", "La contraseña debe tener como máximo 8 caracteres.");
                return;
            } else if (contraseña.length() < 8 || recontra.length() < 8) {
                mostrarAlerta("Error", "Contraseña muy corta", "La contraseña debe tener como máximo 8 caracter");
                return;

            }


            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Maneja el caso en el que la cadena no se pueda convertir a un entero
                System.out.println("El campo 'id' debe ser un número entero válido.");
                return;
            }

            // Intenta establecer la conexión a la base de datos
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "root", "3012")) {
                // Define la consulta SQL para insertar un nuevo usuario
                String sql = "INSERT INTO usuarios (id, nombre, telefono,fecha_nacimiento, contraseña) VALUES (?, ?, ?, ?, ?)";

                // Prepara la declaración SQL con parámetros
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, nombre);
                    preparedStatement.setString(3, telefono);
                    preparedStatement.setString(4, fecha_nacimiento);
                    preparedStatement.setString(5, contraseña);

                    // Ejecuta la declaración y guarda el nuevo usuario en la base de datos
                    int filasAfectadas = preparedStatement.executeUpdate();

                    if (filasAfectadas > 0) {
                        mostrarAlerta("Información", "REGISTRO DE USUARIO", "Usuario registrado con éxito. ¡Felicidades!");

                    } else {
                        System.out.println("Error al registrar el usuario.");
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
                // Manejo de excepciones, puedes mostrar un mensaje de error al usuario si es necesario
            }
        }

        // ... otros métodos y lógica de tu controlador
    @FXML
    public void onGuardar(ActionEvent event) {
        guardarDatos();
        }


    public void OnvolverLogin(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Cierra la ventana actual
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();

        // Muestra la ventana de login
        stage.show();
    }
    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(stage);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);

        alert.showAndWait();
    }
}


