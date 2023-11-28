package DAO;

import com.api.gestion.facturandoapp.Clases_cls.cls_empresa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "3012";
    public static List<cls_empresa> obtenerEmpresas() {
        List<cls_empresa> listaEmpresas = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "SELECT * FROM empresa";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int nit_empresa = resultSet.getInt("nit");
                        String nombre = resultSet.getString("nombre_empresa");
                        Date fechaVinculacion = resultSet.getDate("fecha_vinculacion");

                        cls_empresa empresa = new cls_empresa(nit_empresa, nombre, fechaVinculacion.toLocalDate());
                        listaEmpresas.add(empresa);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones, puedes personalizarlo según tus necesidades
        }

        return listaEmpresas;
    }

    public static void guardarEmpresa(cls_empresa empresa) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "INSERT INTO empresa (nit, nombre_empresa, fecha_vinculacion) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, empresa.getNit());
                preparedStatement.setString(2, empresa.getNombreEmpresa());
                preparedStatement.setDate(3, Date.valueOf(empresa.getFechaVinculacion()));

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, puedes mostrar un mensaje de error al usuario si es necesario
        }
    }
    public static void eliminarEmpresa(int nitEmpresa) {
        String sql = "DELETE FROM empresa WHERE nit = ?";

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, nitEmpresa);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Empresa eliminada con éxito.");
            } else {
                System.out.println("No se encontró la empresa con NIT: " + nitEmpresa);
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar la empresa: " + e.getMessage());
        }
    }
}
