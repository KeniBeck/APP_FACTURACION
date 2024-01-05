package DAO;

import com.api.gestion.facturandoapp.Clases_cls.cls_empleado;
import com.api.gestion.facturandoapp.Clases_cls.cls_empresa;
import com.api.gestion.facturandoapp.Clases_cls.cls_facturaEmpleado;
import com.api.gestion.facturandoapp.Clases_cls.cls_facturaEmpresa;
import javafx.scene.control.Alert;
import javafx.stage.Window;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaEmpleadoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "3012";
    private static Window stage;

    public static List<cls_facturaEmpleado> obtenerFacturaEmpleado() {
        List<cls_facturaEmpleado> listaFacturaEmpleado = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "SELECT * FROM factura_empleado";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int idEmpleado = resultSet.getInt("id_empleado");
                        String nombreEmpresa = resultSet.getString("nombre_empleado");
                        LocalDate fechaEmision = resultSet.getDate("fecha_emision").toLocalDate();
                        String descripcion = resultSet.getString("descripcion");
                        int cantidad = resultSet.getInt("cantidad");
                        double valorUnitario = resultSet.getDouble("valor_unitario");
                        double valorTotal = resultSet.getDouble("valor_total");

                        cls_facturaEmpleado factura = new cls_facturaEmpleado(id, idEmpleado, nombreEmpresa, fechaEmision,
                                descripcion, cantidad, valorUnitario, valorTotal);
                        listaFacturaEmpleado.add(factura);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, puedes mostrar un mensaje de error al usuario si es necesario
        }

        return listaFacturaEmpleado;

    }

    public static void eliminarFacturaEmpleado(int id) {
        String sql = "DELETE FROM factura_empleado WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Factura eliminada con éxito.");
            } else {
                System.out.println("No se encontró la factura con id: " + id);
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar la factura: " + e.getMessage());
        }
    }

    public static void guardarFacturaEnBaseDeDatos(String idEmpleado, String nombreEmpleado, LocalDate fechaEmision, String descripcion, String cantidad, String valoru) {
        try {
            Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            // Preparar la consulta SQL
            String sql = "INSERT INTO factura_empleado (id, id_empleado, nombre_empleado, fecha_emision, descripcion, cantidad, valor_unitario, valor_total) " +
                    "VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

            // Obtener la fecha del DatePicker y convertirla a formato Date
            Date fechaEmisionDate = java.sql.Date.valueOf(fechaEmision);

            // Calcular el valor total
            double cantidadDouble = Double.parseDouble(cantidad);
            double valorUnitarioDouble = Double.parseDouble(valoru);
            double valorTotal = cantidadDouble * valorUnitarioDouble;

            // Crear la sentencia preparada
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idEmpleado);
            preparedStatement.setString(2, nombreEmpleado);
            preparedStatement.setDate(3, new java.sql.Date(fechaEmisionDate.getTime()));
            preparedStatement.setString(4, descripcion);
            preparedStatement.setString(5, cantidad);
            preparedStatement.setString(6, valoru);
            preparedStatement.setDouble(7, valorTotal);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            mostrarAlerta("Registro Facturas", "Factura Registrada", "Factura Registrada con exito ");

            // Cerrar recursos
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println("Error al guardar la factura: " + ex.getMessage());
        }
    }
    private static void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(stage);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);

        alert.showAndWait();
    }
}