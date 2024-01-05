package DAO;

import com.api.gestion.facturandoapp.Clases_cls.cls_empleado;
import com.api.gestion.facturandoapp.Clases_cls.cls_empresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "3012";

    public static List<cls_empleado> obtenerEmpleado() {
        List<cls_empleado> listaEmpleado = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "SELECT * FROM empleado";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre_empleado");
                        Date fechaIngreso = resultSet.getDate("fecha_ingreso");
                        Date fechaNacimiento = resultSet.getDate("fecha_nacimiento");
                        String cargo = resultSet.getString("cargo");
                        String telefono = resultSet.getString("telefono");



                        cls_empleado empleado = new cls_empleado(id, nombre, fechaIngreso.toLocalDate(),fechaNacimiento.toLocalDate(),cargo,telefono);
                        listaEmpleado.add(empleado);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones, puedes personalizarlo según tus necesidades
        }

        return listaEmpleado;
    }
    public static void guardarEmpleado(cls_empleado empleado) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "INSERT INTO empleado (id, nombre_empleado, fecha_ingreso, fecha_nacimiento, cargo, telefono) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, empleado.getId_empleado());
                preparedStatement.setString(2, empleado.getNombre_empleado());
                preparedStatement.setDate(3, Date.valueOf(empleado.getFecha_ingreso()));
                preparedStatement.setDate(4, Date.valueOf(empleado.getFecha_nacimiento()));
                preparedStatement.setString(5,empleado.getCargo());
                preparedStatement.setString(6,empleado.getTelefono());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, puedes mostrar un mensaje de error al usuario si es necesario
        }
    }
    public static void eliminarEmpleado(int idEmpleado) {
        String sql = "DELETE FROM empleado WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idEmpleado);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Empleado eliminada con éxito.");
            } else {
                System.out.println("No se encontró la empresa con NIT: " + idEmpleado);
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar la empresa: " + e.getMessage());
        }
    }
}
