package com.api.gestion.facturandoapp.ClasesController;

import DAO.EmpleadoDAO;
import DAO.EmpresaDAO;
import DAO.FacturaEmpleadoDAO;
import DAO.FacturaEmpresaDAO;
import com.api.gestion.facturandoapp.ClasesController.ControlTablesView.EliminarEmpresaButtonCellFactory;
import com.api.gestion.facturandoapp.Clases_cls.cls_empleado;
import com.api.gestion.facturandoapp.Clases_cls.cls_empresa;
import com.api.gestion.facturandoapp.Clases_cls.cls_facturaEmpleado;
import com.api.gestion.facturandoapp.Clases_cls.cls_facturaEmpresa;
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
    public TableColumn<cls_empleado,Void> colEliminar;

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
    public TableColumn<cls_facturaEmpresa, Integer> coliDFacturaEmpresa;
    public TableColumn<cls_facturaEmpresa,Integer> colNItFactura;
    public TableColumn<cls_facturaEmpresa,String> colFacturaNombreEmprresa;
    public TableColumn<cls_facturaEmpresa,LocalDate> colFacturaFechaEmpresa;
    public TableColumn<cls_facturaEmpresa,String> colFacturaDescripcionEmpresa;
    public TableColumn<cls_facturaEmpresa,Integer> colFacturaCantidadEmpresa;
    public TableColumn<cls_facturaEmpresa,Double> colFacturaVUnitarioEmpresa;
    public TableColumn<cls_facturaEmpresa,Double> colFacturaVTotalEmpresa;
    public TableView table_facturaEmpresa;
    public TableColumn<cls_facturaEmpresa,Void> colFacturaEliminarEmpresa;
    public Pane panel_verFacturaEmpresa;
    public TableView<cls_facturaEmpleado> table_FacturaEmpleado;
    public TableColumn<cls_facturaEmpleado,Integer> colIdFacturaEmpleado;
    public TableColumn<cls_facturaEmpleado,Integer> colIdEmpleadoFactura;
    public TableColumn<cls_facturaEmpleado,String> colFacturaNombreEmpleado;
    public TableColumn<cls_facturaEmpleado,LocalDate> colFacturaFechaEmpleado;
    public TableColumn<cls_facturaEmpleado,String> colFacturaDescripcionEmpleado;
    public TableColumn<cls_facturaEmpleado,Integer> colFacturaCantidadEmpleado;
    public TableColumn<cls_facturaEmpleado,Double> colFacturaVUnitarioEmpleado;
    public TableColumn<cls_facturaEmpleado,Double> colFacturaVTotalEmpleado;
    public TableColumn<cls_facturaEmpleado,Void> colFacturaElminarEmpleado;


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
        panel_verFacturaEmpresa.setVisible(false);
        panel_verFacturaEmpresa.setManaged(false);

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
        int idStr = Integer.parseInt(txt_id.getText());
        LocalDate fecha_ingreso = date_ingreso.getValue();
        LocalDate fecha_nacimiento = date_nacimiento.getValue();
        String cargoText = txt_cargo.getText();
        String telefono = txt_telefono.getText();

        cls_empleado NuevoEmpleado = new cls_empleado(idStr,nombre,fecha_ingreso,fecha_nacimiento,cargoText,telefono);

        EmpleadoDAO.guardarEmpleado(NuevoEmpleado);
        mostrarAlerta("Regitro Empleados","Empleado registrado con exito","felicidades");

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

        // Configura las columnas para mostrar los datos
        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        colFechaIngreso.setCellValueFactory(cellData -> cellData.getValue().fechaIngresoProperty());
        colFechaNacimiento.setCellValueFactory(cellData -> cellData.getValue().fechaNacimientoProperty());
        colCargo.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());
        colTelefono.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        colEliminar.setCellFactory(param -> new TableCell<>() {
            private final Button btnEliminar = new Button("Eliminar");

            {
                btnEliminar.setOnAction(event -> {
                    cls_empleado empleado = (cls_empleado) getTableView().getItems().get(getIndex());
                    eliminarEmpleado(empleado);
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
        //tabla de factura empresa
        coliDFacturaEmpresa.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNItFactura.setCellValueFactory(new PropertyValueFactory<>("nitEmpresa"));
        colFacturaNombreEmprresa.setCellValueFactory(new PropertyValueFactory<>("nombreEmpresa"));
        colFacturaFechaEmpresa.setCellValueFactory(new PropertyValueFactory<>("fechaEmision"));
        colFacturaDescripcionEmpresa.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colFacturaCantidadEmpresa.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colFacturaVUnitarioEmpresa.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        colFacturaVTotalEmpresa.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        colFacturaEliminarEmpresa.setCellFactory(param -> new TableCell<>() {
            private final Button btnEliminar = new Button("Eliminar");

            {
                btnEliminar.setOnAction(event -> {
                    cls_facturaEmpresa FacturaEmpresa = (cls_facturaEmpresa) getTableView().getItems().get(getIndex());
                    eliminarFacturaEmpresa(FacturaEmpresa);
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
        cargarFacturaEmpresas();

        //tabla factura empleado
        colIdFacturaEmpleado.setCellValueFactory(new PropertyValueFactory<>("idFactura"));
        colIdEmpleadoFactura.setCellValueFactory(new PropertyValueFactory<>("idEmpleado"));
        colFacturaNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombreEmpleado"));
        colFacturaFechaEmpleado.setCellValueFactory(new PropertyValueFactory<>("fechaEmision"));
        colFacturaDescripcionEmpleado.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colFacturaCantidadEmpleado.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colFacturaVUnitarioEmpleado.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        colFacturaVTotalEmpleado.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        colFacturaElminarEmpleado.setCellFactory(param -> new TableCell<>() {
            private final Button btnEliminar = new Button("Eliminar");

            {
                btnEliminar.setOnAction(event -> {
                    cls_facturaEmpleado empleado = (cls_facturaEmpleado) getTableView().getItems().get(getIndex());
                    eliminarFacturaEmpleado(empleado);
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
        cargarFacturaEmpleado();

    }
    private void cargarFacturaEmpleado (){
        List<cls_facturaEmpleado> ListaFacturaEmpleado = FacturaEmpleadoDAO.obtenerFacturaEmpleado();
        table_FacturaEmpleado.getItems().setAll(ListaFacturaEmpleado);
    }
    private void cargarFacturaEmpresas(){
        List<cls_facturaEmpresa> listaFacturaEmpresa = FacturaEmpresaDAO.obtenerFacturasEmpresa();
        table_facturaEmpresa.getItems().setAll(listaFacturaEmpresa);
    }

    private void cargarEmpresas() {
        List<cls_empresa> listaEmpresas = EmpresaDAO.obtenerEmpresas();
        table_verEmpresa.getItems().setAll(listaEmpresas);
    }
    private void eliminarFacturaEmpleado (cls_facturaEmpleado facturaEmpleado){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro de que desea eliminar la factura? .");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            FacturaEmpleadoDAO.eliminarFacturaEmpleado(facturaEmpleado.getIdFactura());
            cargarFacturaEmpleado();
        }


    }
    private void eliminarFacturaEmpresa(cls_facturaEmpresa facturaEmpresa){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro de que desea eliminar la factura? .");

        // Obtener el resultado de la confirmación
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            FacturaEmpresaDAO.eliminarFacturaEmpresa(facturaEmpresa.getId());
            cargarFacturaEmpresas();
        }

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


    private void eliminarEmpleado(cls_empleado empleado) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro de que desea eliminar la empresa? Esta acción también eliminará sus facturas.");

        // Obtener el resultado de la confirmación
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            EmpleadoDAO.eliminarEmpleado(empleado.getId_empleado());
            EmpleadoDAO.obtenerEmpleado();
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


    private void seleccionarEmpleado(cls_empleado empleado) {
        txt_idEmpleadoFactura.setText(String.valueOf(empleado.getId_empleado()));
        txt_nombreEmpleadoFactura.setText(empleado.getNombre_empleado());
    }





    @FXML
    private void actualizarListaEmpleadosFactura() {
        // Llamar al método para obtener la lista de empleados desde la base de datos
        obtenerListaEmpleadoDesdeBaseDeDatos();
        // Limpiar y volver a llenar el menú desplegable


        for (cls_empleado empleado : listaEmpleados) {
            MenuItem menuItem = new MenuItem(empleado.getNombre_empleado());
            menuItem.setOnAction(e -> seleccionarEmpleado(empleado));
            menuButtonEmpleadosFactura.getItems().add(menuItem);
        }
    }

    public void onGuardarFactura(MouseEvent mouseEvent) {
        FacturaEmpleadoDAO.guardarFacturaEnBaseDeDatos(txt_idEmpleadoFactura.getText(), txt_nombreEmpleadoFactura.getText(), date_fechaEmisionFactura.getValue(), txtarea_descripcionFactura.getText()
                , txt_cantidadFactura.getText(), txt_vUnitarioFactura.getText());
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
    private void obtenerListaEmpleadoDesdeBaseDeDatos() {
        ObservableList<cls_empleado> listaEmpleado = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "SELECT * FROM empleado";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre_empleado");
                        LocalDate fechaVinculacion = resultSet.getDate("fecha_ingreso").toLocalDate();
                        LocalDate fechaNacimiento = resultSet.getDate("fecha_nacimiento").toLocalDate();
                        String cargo = resultSet.getString("cargo");
                        String telefono = resultSet.getString("telefono");



                        cls_empleado empleado = new cls_empleado(id, nombre, fechaVinculacion,fechaNacimiento,cargo,telefono);
                        listaEmpleado.add(empleado);

                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, puedes mostrar un mensaje de error al usuario si es necesario

        }
        menuButtonEmpleadosFactura.getItems().clear();

        for (cls_empleado empleado : listaEmpleado) {
            MenuItem menuItem = new MenuItem(empleado.getNombre_empleado());
            menuItem.setOnAction(event -> seleccionarEmpleado(empleado));
            menuButtonEmpleadosFactura.getItems().add(menuItem);
        }
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

    public void actualizarInterfaz() {
        // Paso 1: Obtener los datos actualizados de la base de datos
        List<cls_empresa> listaEmpresas = EmpresaDAO.obtenerEmpresas();
        List <cls_empleado> ListaEmpleado = EmpleadoDAO.obtenerEmpleado();

        // Paso 2: Actualizar la Interfaz Gráfica
        if (table_verEmpresa != null || Table_VerEmpleados != null)  {
            ObservableList<cls_empresa> observableList = FXCollections.observableArrayList(listaEmpresas);
            ObservableList<cls_empleado> observableList1 = FXCollections.observableArrayList(ListaEmpleado);
            table_verEmpresa.setItems(observableList);
            Table_VerEmpleados.setItems(observableList);
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
        FacturaEmpresaDAO.guardarFacturaEmpresaEnBaseDeDatos(txt_NitEmpresaFactura.getText(),txt_NombreEmpresaFactura.getText(),date_emisionFactureEmpresa.getValue(),
                textArea_descripcionFacturaEmpresa.getText(),txt_cantidadFacturaEmpresa.getText(),txt_vUnitarioFacturaEmpresa.getText() );
    }

    public void onVolverVerEmpresa(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_menuEmpresa);

    }

    public void OnVerEmpresa(MouseEvent mouseEvent) {
        ocultarPaneles();
        actualizarInterfaz();
        mostrarPanel(panel_verEmpresa);


    }
    public void OnVerFacturas(MouseEvent mouseEvent) {
        mostrarPanel(panel_menuVerFacturas);
    }

    public void OnVerFacturasEmpleados(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_verFacturaEmpresa);
    }

    public void OnVolverMenuFacturas(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_menuVerFacturas);
        mostrarPanel(Panel_realizraFacturas);
    }

    public void OnVerFacturasEmpresa(MouseEvent mouseEvent) {
        ocultarPaneles();
        mostrarPanel(panel_verFacturaEmpleado);
    }

    public void onListaEmpleados(MouseEvent mouseEvent) {
    }
}