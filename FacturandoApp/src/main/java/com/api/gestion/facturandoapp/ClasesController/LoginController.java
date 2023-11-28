package com.api.gestion.facturandoapp.ClasesController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {
    public Button btn_ingresar;
    public TextField txt_usuario;
    public PasswordField txt_contraseña;

    private void abrirVentanaRegistro() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Registro.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // Cierra la ventana actual (ventana de inicio de sesión)
        Stage loginStage = (Stage) btn_ingresar.getScene().getWindow();
        loginStage.close();
    }
    public void crear_cuenta(MouseEvent mouseEvent) throws IOException {
        abrirVentanaRegistro();
    }

    public void onIngresar(ActionEvent actionEvent) {
        String usuario = txt_usuario.getText();
        String contrasena = txt_contraseña.getText();

        // Llama a un método que verifica las credenciales en tu base de datos
        boolean credencialesValidas = verificarCredenciales(usuario, contrasena);

        if (credencialesValidas) {
            // Si las credenciales son válidas, abre la ventana correspondiente
            abrirVentanaPrincipal(actionEvent);
        } else {
            // Si las credenciales no son válidas, muestra un mensaje de error
            mostrarAlerta("Credenciales incorrectas", "El usuario o la contraseña son incorrectos.");
        }
    }
    private boolean verificarCredenciales(String usuario, String contrasena) {
        String url = "jdbc:mysql://localhost:3306/mi_base_de_datos";
        String usuarioDB = "root";
        String contrasenaDB = "3012";

        try (Connection connection = DriverManager.getConnection(url, usuarioDB, contrasenaDB)) {
            String sql = "SELECT * FROM usuarios WHERE id = ? AND contraseña = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, contrasena);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Si hay algún resultado, las credenciales son válidas
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarAlerta("Error de conexión", "No se pudo conectar a la base de datos.");
        }

        return false;
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void abrirVentanaPrincipal(ActionEvent actionEvent) {
        try {
            // Carga la nueva escena (ventana) y configura el controlador si es necesario
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/allcontent.fxml"));
            Parent root = loader.load();


            // Configura el controlador de la nueva escena si es necesario
            // Puedes obtener el controlador después de cargar el FXML
            // Ejemplo: NuevoController controller = loader.getController();
            // controller.inicializarDatos(datosQueNecesites);

            // Muestra la nueva escena
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
