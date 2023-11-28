package com.api.gestion.facturandoapp.ConexionDataBase;

import java.sql.*;

public class OperacionesBD {
    public static void insertarRegistro(int id, Date fecha, int numero, String contrasena) {
        String query = "INSERT INTO tu_tabla (id, fecha, numero, contrasena) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.setDate(2, fecha);
            statement.setInt(3, numero);
            statement.setString(4, contrasena);

            statement.executeUpdate();
            System.out.println("Registro insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
