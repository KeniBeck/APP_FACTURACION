package com.api.gestion.facturandoapp.ClasesController;

import DAO.EmpresaDAO;
import com.api.gestion.facturandoapp.ClasesController.ControlTablesView.EliminarEmpresaButtonCellFactory;
import com.api.gestion.facturandoapp.Clases_cls.cls_empleado;
import com.api.gestion.facturandoapp.Clases_cls.cls_empresa;
import com.api.gestion.facturandoapp.Clases_cls.cls_facturaEmpleado;
import impl.org.controlsfx.autocompletion.SuggestionProvider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Window;
import javafx.util.Callback;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class AllcontentController implements Initializable  {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "3012";
    public StackPane stackPane_opciones;
    public Pane pane_opActive;
    public StackPane stack_opcines;
    public Pane pane_opciones;
    public Pane panel_aggActive;
    public Pane panel_opEmpleados;
    public TextField txt_id;
    public TextField txt_nombres;
    public DatePicker date_ingreso;
    public DatePicker date_nacimiento;
    public TextField txt_cargo;
    public TextField txt_telefono;
    public Pane Panel_VerEmpleados;
    public TableView Table_VerEmpleados;
    public TableColumn colEliminar;

    public TableColumn colFechaEmision;
    public MenuButton menuButtonEmpleadosFactura;
    public TextField txt_idFactura;
    public TextField txt_idEmpleadoFactura;
    public TextField txt_nombreEmpleadoFactura;
    public TextArea txtarea_descripcionFactura;
    public TextField txt_cantidadFactura;
    public TextField txt_vUnitarioFactura;
    public TextField txt_vTotal;
    public DatePicker date_fechaEmisionFactura;
    public Pane Panel_realizraFacturas;
    public Pane panel_tableFacturar;
    public Button btn_RealizarFacturaEmpleado;
    public Button btn_ActulizarPanelFactura;
    public  TextField txt_NitEmpresa;
    public  TextField txt_nombreEmpresa;
    public  DatePicker date_fechaVinculacion;
    public Pane panel_RegistroEmpleado;
    public Pane panel_menuEmpresa;
    public Pane panel_FacturaEmpresa;
    public MenuButton menuButtonEmpresaFactura;
    public TextField txt_NitEmpresaFactura;
    public TextField txt_NombreEmpresaFactura;
    public Button btn_actulizarFacturaEmpresa;
    public DatePicker date_emisionFactureEmpresa;
    public TextArea textArea_descripcionFacturaEmpresa;
    public TextField txt_cantidadFacturaEmpresa;
    public TextField txt_vUnitarioFacturaEmpresa;
    public TextField txt_vTotalFacturaEmpresa;
    public Pane panel_verEmpresa;
    public TableView <cls_empresa> table_verEmpresa;
    public TableColumn <cls_empresa,Integer> colNitEmpresa;
    public TableColumn<cls_empresa,String> colNombreEmpresa;
    public TableColumn <cls_empresa,LocalDate>colFechaVinculacion;
    public TableColumn<cls_empresa, Void> colEliminarEmpresa;
    public Pane panel_menuVerFacturas;
    public Pane panel_verFacturaEmpleado;
    private Window stage;
    @FXML
    private TableColumn<cls_empleado,Integer> colId;

    @FXML
    private TableColumn<cls_empleado,String> colNombre;

    @FXML
    private TableColumn< cls_empleado,LocalDate> colFechaIngreso;

    @FXML
    private TableColumn< cls_empleado,LocalDate> colFechaNacimiento;

    @FXML
    private TableColumn< cls_empleado,String> colCargo;

    @FXML
    private TableColumn< cls_empleado,String> colTelefono;



    public void OnOpcionClick(MouseEvent mouseEvent) {
        // Aquí decides si debes ocultar o mostrar el panel
            ocultarPaneles();
            mostrarPanel(pane_opActive);
    }

    public void OnSalirClick(MouseEvent mouseEvent) {
    }

    public void onCerrarSecionclick(MouseEvent mouseEvent) {
    }

    private void mostrarPanel(Pane panel) {
        panel.setVisible(true);
        panel.setManaged(true);
    }

    private void ocultarPaneles() {
        pane_opActive.setVisible(false);
        pane_opActive.setManaged(false);
        panel_opEmpleados.setVisible(false);
        panel_opEmpleados.setManaged(false);
        panel_aggActive.setVisible(false);
        panel_aggActive.setManaged(false);
        Panel_VerEmpleados.setVisible(false);
        Panel_VerEmpleados.setManaged(false);
        Panel_realizraFacturas.setVisible(false);
        Panel_realizraFacturas.setManaged(false);
        panel_tableFacturar.setVisible(false);
        panel_tableFacturar.setManaged(false);
        panel_menuEmpresa.setVisible(false);
        panel_menuEmpresa.setManaged(false);
        panel_RegistroEmpleado.setVisible(false);
        panel_RegistroEmpleado.setManaged(false);
        panel_FacturaEmpresa.setVisible(false);
        panel_FacturaEmpresa.setManaged(false);
        panel_verEmpresa.setVisible(false);
        panel_verEmpresa.setManaged(false);
        panel_menuVerFacturas.setVisible(false);
        panel_menuVerFacturas.setManaged(false);
        panel_verFacturaEmpleado.setVisible(false);
        panel_verFacturaEmpleado.setManaged(false);

        // Agrega más líneas para ocultar otros paneles si es necesario
    }

    public void ImageClick_Empleado(MouseEvent mouseEvent) {
            ocultarPaneles();
            mostrarPanel(panel_opEmpleados);
    }

    public void OnAggEmpleado(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_aggActive);
    }

    public void labelButon_aggEmpleadoClick(MouseEvent mouseEvent) {

        ocultarPaneles();
        mostrarPanel(panel_aggActive);

    }

    public void OnVolverOpEmpleadoRegistro(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_opEmpleados);
    }



    public void OnRegistrarEmpleado(MouseEvent mouseEvent) {
        guardarDatos();
    }

    public void guardarDatos() {
        // Obtén los valores de los campos de texto
        String nombre = txt_nombres.getText();
        String idStr = txt_id.getText();
        LocalDate fecha_ingreso = date_ingreso.getValue();
        LocalDate fecha_nacimiento = date_nacimiento.getValue();
        String cargoText = txt_cargo.getText();
        String telefono = txt_telefono.getText();


        // Valida si los campos requeridos están llenos
        if (nombre.isEmpty() || idStr.isEmpty() || fecha_ingreso == null || fecha_nacimiento == null || cargoText.isEmpty() || telefono.isEmpty()) {
            // Puedes mostrar un mensaje de error o realizar alguna acción aquí
            mostrarAlerta("Error", "Faltan campos", "ingrese todos los campos requeridos.");
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
                String sql = "INSERT INTO empleado (id, nombre_empleado, fecha_ingreso,fecha_nacimiento,cargo,telefono) VALUES (?, ?, ?, ?, ?,?)";

                // Prepara la declaración SQL con parámetros
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, nombre);
                    preparedStatement.setString(3, String.valueOf(fecha_ingreso));
                    preparedStatement.setString(4, String.valueOf(fecha_nacimiento));
                    preparedStatement.setString(5, cargoText);
                    preparedStatement.setString(6, telefono);

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
    
    private void cargarDatosDesdeBaseDeDatos() {
        // Aquí debes obtener los datos de la base de datos y agregarlos a la TableView
        // Utiliza un servicio o DAO para interactuar con la base de datos y obtener la lista de empleados
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "root", "3012")) {
            String sql = "SELECT * FROM empleado";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre_empleado");
                        LocalDate fechaIngreso = resultSet.getDate("fecha_ingreso").toLocalDate();
                        LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate();
                        String cargo = resultSet.getString("cargo");
                        String telefono = resultSet.getString("telefono");

                        cls_empleado empleado = new cls_empleado(id, nombre, fechaIngreso, fechaNacimiento, cargo, telefono);
                        Table_VerEmpleados.getItems().add(empleado);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, puedes mostrar un mensaje de error al usuario si es necesario
        }
    }
    private void mostrarAlerta(String titulo, String encabezado, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(stage);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(contenido);

        alert.showAndWait();
    }

    public void OnVerTablaEmpleado(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(Panel_VerEmpleados);
    }
    private ObservableList<cls_empleado> listaEmpleados = FXCollections.observableArrayList();
    private ObservableList<cls_empresa> listaEmpresa = FXCollections.observableArrayList();
    private ObservableList<cls_facturaEmpleado> listaFacturas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        obtenerListaEmpleadosDesdeBaseDeDatos();
        obtenerListaEmpresaDesdeBaseDeDatos();

        // Configura las columnas para mostrar los datos
        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        colFechaIngreso.setCellValueFactory(cellData -> cellData.getValue().fechaIngresoProperty());
        colFechaNacimiento.setCellValueFactory(cellData -> cellData.getValue().fechaNacimientoProperty());
        colCargo.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());
        colTelefono.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        colEliminar.setCellFactory(buttonTableCellFactory);
        colEliminar.setSortable(false);

        // Carga los datos desde la base de datos
        cargarDatosDesdeBaseDeDatos();
        btn_ActulizarPanelFactura.setOnAction(event -> actualizarListaEmpleadosFactura());
        btn_actulizarFacturaEmpresa.setOnAction(event -> actualizarListaEmpresaFactura());

        //tabla de empresa
        colNitEmpresa.setCellValueFactory(new PropertyValueFactory<>("nit"));
        colNombreEmpresa.setCellValueFactory(new PropertyValueFactory<>("nombreEmpresa"));
        colFechaVinculacion.setCellValueFactory(new PropertyValueFactory<>("fechaVinculacion"));
        colEliminarEmpresa.setCellFactory(param -> new TableCell<>() {
            private final Button btnEliminar = new Button("Eliminar");

            {
                btnEliminar.setOnAction(event -> {
                    cls_empresa empresa = getTableView().getItems().get(getIndex());
                    eliminarEmpresa(empresa);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btnEliminar);
                }
            }
        });

        cargarEmpresas();

    }

    private void cargarEmpresas() {
        List<cls_empresa> listaEmpresas = EmpresaDAO.obtenerEmpresas();
        table_verEmpresa.getItems().setAll(listaEmpresas);
    }
    private void eliminarEmpresa(cls_empresa empresa) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro de que desea eliminar la empresa? Esta acción también eliminará sus facturas.");

        // Obtener el resultado de la confirmación
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            EmpresaDAO.eliminarEmpresa(empresa.getNit());
            cargarEmpresas();
        }
    }

    private final Callback<TableColumn<cls_empleado, Void>, TableCell<cls_empleado, Void>> buttonTableCellFactory = new Callback<>() {
        @Override
        public TableCell<cls_empleado, Void> call(final TableColumn<cls_empleado, Void> param) {
            return new TableCell<>() {
                private final Button button = new Button("Eliminar");

                {
                    button.setOnAction(event -> {
                        cls_empleado empleado = getTableView().getItems().get(getIndex());
                        eliminarEmpleado(empleado);
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(button);
                    }
                }
            };
        }
    };
    private void eliminarEmpleado(cls_empleado empleado) {
        int idEmpleado = empleado.getId_empleado();

        // Muestra un cuadro de diálogo de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de Eliminación");
        alert.setHeaderText("¿Estás seguro de que quieres eliminar este empleado?");
        alert.setContentText("La eliminación del empleado también eliminará las facturas asociadas.");

        // Obtén la respuesta del usuario desde el cuadro de diálogo
        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

        // Procede con la eliminación solo si el usuario confirma
        if (result == ButtonType.OK) {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_base_de_datos", "root", "3012")) {
                String sql = "DELETE FROM empleado WHERE id = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, idEmpleado);

                    int filasAfectadas = preparedStatement.executeUpdate();

                    if (filasAfectadas > 0) {
                        mostrarAlerta("Información", "ELIMINACIÓN DE EMPLEADO", "Empleado eliminado con éxito.");
                    } else {
                        System.out.println("No se afectaron filas. No se encontró un empleado con el ID proporcionado.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error al eliminar el empleado.");
                e.printStackTrace();
            }
        }
    }
    public void OnVolverVerEmpleados(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_opEmpleados);
    }


    public void OnActualizarVerEmpleados(MouseEvent mouseEvent) {
        Table_VerEmpleados.getItems().clear();

        // Vuelve a cargar los datos desde la base de datos
        cargarDatosDesdeBaseDeDatos();
    }

   private void obtenerListaEmpleadosDesdeBaseDeDatos() {
        ObservableList<cls_empleado> listaEmpleados = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "SELECT * FROM empleado";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre_empleado");
                        LocalDate fechaIngreso = resultSet.getDate("fecha_ingreso").toLocalDate();
                        LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate();
                        String cargo = resultSet.getString("cargo");
                        String telefono = resultSet.getString("telefono");

                        cls_empleado empleado = new cls_empleado(id, nombre, fechaIngreso, fechaNacimiento, cargo, telefono);
                        listaEmpleados.add(empleado);

                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, puedes mostrar un mensaje de error al usuario si es necesario

        }
       menuButtonEmpleadosFactura.getItems().clear();

        for (cls_empleado empleado : listaEmpleados) {
            MenuItem menuItem = new MenuItem(empleado.getNombre_empleado());
            menuItem.setOnAction(event -> seleccionarEmpleado(empleado));
            menuButtonEmpleadosFactura.getItems().add(menuItem);
        }
   }
    private void seleccionarEmpleado(cls_empleado empleado) {
        txt_idEmpleadoFactura.setText(String.valueOf(empleado.getId_empleado()));
        txt_nombreEmpleadoFactura.setText(empleado.getNombre_empleado());
    }


    private void guardarFacturaEnBaseDeDatos(String idEmpleado, String nombreEmpleado, LocalDate fechaEmision,
                                      String descripcion, String cantidad, String valorUnitario) {
        try {
            Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            // Preparar la consulta SQL
            String sql = "INSERT INTO factura_empleado (id, id_empleado, nombre_empleado, fecha_emision, descripcion, cantidad, valor_unitario, valor_total) " +
                    "VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

            // Obtener la fecha del DatePicker y convertirla a formato Date
            Date fechaEmisionDate = java.sql.Date.valueOf(fechaEmision);

            // Calcular el valor total
            double cantidadDouble = Double.parseDouble(cantidad);
            double valorUnitarioDouble = Double.parseDouble(valorUnitario);
            double valorTotal = cantidadDouble * valorUnitarioDouble;

            // Crear la sentencia preparada
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idEmpleado);
            preparedStatement.setString(2, nombreEmpleado);
            preparedStatement.setDate(3, new java.sql.Date(fechaEmisionDate.getTime()));
            preparedStatement.setString(4, descripcion);
            preparedStatement.setString(5, cantidad);
            preparedStatement.setString(6, valorUnitario);
            preparedStatement.setDouble(7, valorTotal);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            mostrarAlerta("Registro Facturas","Factura Registrada","Factura Registrada con exito ");

            // Cerrar recursos
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println("Error al guardar la factura: " + ex.getMessage());
        }
    }
    @FXML
    private void actualizarListaEmpleadosFactura() {
        // Llamar al método para obtener la lista de empleados desde la base de datos
        obtenerListaEmpleadosDesdeBaseDeDatos();

        // Limpiar y volver a llenar el menú desplegable

        for (cls_empleado empleado : listaEmpleados) {
            MenuItem menuItem = new MenuItem(empleado.getNombre_empleado());
            menuItem.setOnAction(e -> seleccionarEmpleado(empleado));
            menuButtonEmpleadosFactura.getItems().add(menuItem);
        }
    }

    public void onGuardarFactura(MouseEvent mouseEvent) {
        guardarFacturaEnBaseDeDatos(txt_idEmpleadoFactura.getText(), txt_nombreEmpleadoFactura.getText(), date_fechaEmisionFactura.getValue(), txtarea_descripcionFactura.getText()
                , txt_cantidadFactura.getText(), txt_vUnitarioFactura.getText()
        );
    }
    void guardarEmpresa() {
        int nit = Integer.parseInt(txt_NitEmpresa.getText());
        String nombreEmpresa = txt_nombreEmpresa.getText();
        LocalDate fechaVinculacion = date_fechaVinculacion.getValue();

        cls_empresa nuevaEmpresa = new cls_empresa(nit, nombreEmpresa, fechaVinculacion);
        EmpresaDAO.guardarEmpresa(nuevaEmpresa);

        // Puedes agregar lógica adicional aquí, como mostrar un mensaje de éxito al usuario.
        mostrarAlerta("Empresas","Empresa Registrada","Empresa registrada con exito");
    }
    private void obtenerListaEmpresaDesdeBaseDeDatos() {
        ObservableList<cls_empresa> listaEmpresa = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "SELECT * FROM empresa";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int nit = resultSet.getInt("nit");
                        String nombre = resultSet.getString("nombre_empresa");
                        LocalDate fechaVinculacion = resultSet.getDate("fecha_vinculacion").toLocalDate();



                        cls_empresa empresa = new cls_empresa(nit, nombre, fechaVinculacion);
                        listaEmpresa.add(empresa);

                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, puedes mostrar un mensaje de error al usuario si es necesario

        }
        menuButtonEmpresaFactura.getItems().clear();

        for (cls_empresa empresa : listaEmpresa) {
            MenuItem menuItem = new MenuItem(empresa.getNombreEmpresa());
            menuItem.setOnAction(event -> seleccionarEmpresa(empresa));
            menuButtonEmpresaFactura.getItems().add(menuItem);
        }
    }
    private void seleccionarEmpresa(cls_empresa empresa) {
        txt_NitEmpresaFactura.setText(String.valueOf(empresa.getNit()));
        txt_NombreEmpresaFactura.setText(empresa.getNombreEmpresa());
    }
    @FXML
    private void actualizarListaEmpresaFactura() {
        // Llamar al método para obtener la lista de empleados desde la base de datos
        obtenerListaEmpresaDesdeBaseDeDatos();

        // Limpiar y volver a llenar el menú desplegable

        for (cls_empresa empresa : listaEmpresa) {
            MenuItem menuItem = new MenuItem(empresa.getNombreEmpresa());
            menuItem.setOnAction(e -> seleccionarEmpresa(empresa));
            menuButtonEmpleadosFactura.getItems().add(menuItem);
        }
    }
    private void guardarFacturaEmpresaEnBaseDeDatos(String idEmpresa, String nombreEmpresa, LocalDate fechaEmision,
                                             String descripcion, String cantidad, String valorUnitario) {
        try {
            Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            // Preparar la consulta SQL
            String sql = "INSERT INTO factura_empresa (id, nit_empresa, nombre_empresa, fecha_emision, descripcion, cantidad, valor_unitario, valor_total) " +
                    "VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

            // Obtener la fecha del DatePicker y convertirla a formato Date
            Date fechaEmisionDate = java.sql.Date.valueOf(fechaEmision);

            // Calcular el valor total
            double cantidadDouble = Double.parseDouble(cantidad);
            double valorUnitarioDouble = Double.parseDouble(valorUnitario);
            double valorTotal = cantidadDouble * valorUnitarioDouble;

            // Crear la sentencia preparada
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idEmpresa);
            preparedStatement.setString(2, nombreEmpresa);
            preparedStatement.setDate(3, new java.sql.Date(fechaEmisionDate.getTime()));
            preparedStatement.setString(4, descripcion);
            preparedStatement.setString(5, cantidad);
            preparedStatement.setString(6, valorUnitario);
            preparedStatement.setDouble(7, valorTotal);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            mostrarAlerta("Registro Facturas","Factura Registrada","Factura Registrada con exito ");

            // Cerrar recursos
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println("Error al guardar la factura: " + ex.getMessage());
        }
    }
    public void onVolverFacturaEmpleado(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(Panel_realizraFacturas);
    }

    public void OnRealizarFacturaEmpleado(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_tableFacturar);

    }

    public void OnRealizarFacturaMenu(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(Panel_realizraFacturas);
    }

    public void OnSalirMenus(MouseEvent mouseEvent) {
        ocultarPaneles();
    }

    public void OnGuardarEmpresa(MouseEvent mouseEvent) {
        guardarEmpresa();
    }

    public void OnVolverRegistroEmpresa(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_menuEmpresa);
    }

    public void OnAgregarEmpresa(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_RegistroEmpleado);
    }

    public void OnMenuEmpresa(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_menuEmpresa);
    }

    public void OnFacturaEmpresa(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_FacturaEmpresa);
    }
    public void OnGuardarFacturaEmpresa(MouseEvent mouseEvent) {
        guardarFacturaEmpresaEnBaseDeDatos(txt_NitEmpresaFactura.getText(),txt_NombreEmpresaFactura.getText(),date_emisionFactureEmpresa.getValue(),
                textArea_descripcionFacturaEmpresa.getText(),txt_cantidadFacturaEmpresa.getText(),txt_vUnitarioFacturaEmpresa.getText() );
    }

    public void onVolverVerEmpresa(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_menuEmpresa);

    }

    public void OnVerEmpresa(MouseEvent mouseEvent) {
        mostrarPanel(panel_verEmpresa);
        ocultarPaneles();
    }
    public void OnVerFacturas(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_menuVerFacturas);
    }

    public void OnVerFacturasEmpleados(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_verFacturaEmpleado);
    }
}