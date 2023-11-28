package com.api.gestion.facturandoapp.ConexionDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaBD {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Intenta establecer la conexión
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "root", "3012");

            // Comprueba si la conexión fue exitosa
            if (conexion != null && !conexion.isClosed()) {
                System.out.println("¡Conexión exitosa a la base de datos!");

                // Puedes realizar más acciones aquí, como ejecutar consultas, etc.

            } else {
                System.err.println("¡Error en la conexión!");
            }

        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();

        } finally {
            // Intenta cerrar la conexión en el bloque finally para asegurarte de que se cierre incluso en caso de excepción
            try {
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                    System.out.println("Conexión cerrada correctamente.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

