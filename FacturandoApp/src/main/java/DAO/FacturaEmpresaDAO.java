package DAO;

import com.api.gestion.facturandoapp.Clases_cls.cls_empresa;
import com.api.gestion.facturandoapp.Clases_cls.cls_facturaEmpresa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaEmpresaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "3012";
    // ... (mismo código que en la clase EmpresaDAO, adaptado para facturas de empresa)

    public static List<cls_facturaEmpresa> obtenerFacturasEmpresa() {
        List<cls_facturaEmpresa> listaFacturas = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "SELECT * FROM factura_empresa";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int nitEmpresa = resultSet.getInt("nit_empresa");
                        String nombreEmpresa = resultSet.getString("nombre_empresa");
                        LocalDate fechaEmision = resultSet.getDate("fecha_emision").toLocalDate();
                        String descripcion = resultSet.getString("descripcion");
                        int cantidad = resultSet.getInt("cantidad");
                        double valorUnitario = resultSet.getDouble("valor_unitario");
                        double valorTotal = resultSet.getDouble("valor_total");

                        cls_facturaEmpresa factura = new cls_facturaEmpresa(id, nitEmpresa, nombreEmpresa, fechaEmision,
                                descripcion, cantidad, valorUnitario, valorTotal);
                        listaFacturas.add(factura);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, puedes mostrar un mensaje de error al usuario si es necesario
        }

        return listaFacturas;
    }
}

