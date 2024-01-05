package com.api.gestion.facturandoapp.Clases_cls;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class cls_empleado {
    private final SimpleIntegerProperty id_empleado;
    private final SimpleStringProperty nombre_empleado;
    private final SimpleObjectProperty<LocalDate> fecha_ingreso;
    private final SimpleObjectProperty<LocalDate> fecha_nacimiento;
    private final SimpleStringProperty cargo;
    private final SimpleStringProperty telefono;

    public cls_empleado(int id, String nombre, LocalDate fechaIngreso, LocalDate fechaNacimiento, String cargo, String telefono) {
        this.id_empleado = new SimpleIntegerProperty(id);
        this.nombre_empleado = new SimpleStringProperty(nombre);
        this.fecha_ingreso = new SimpleObjectProperty<>(fechaIngreso);
        this.fecha_nacimiento = new SimpleObjectProperty<>(fechaNacimiento);
        this.cargo = new SimpleStringProperty(cargo);
        this.telefono = new SimpleStringProperty(telefono);
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado.set(id_empleado);
    }

    public SimpleStringProperty nombre_empleadoProperty() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado.set(nombre_empleado);
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso.get();
    }

    public SimpleObjectProperty<LocalDate> fecha_ingresoProperty() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso.set(fecha_ingreso);
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento.get();
    }

    public SimpleObjectProperty<LocalDate> fecha_nacimientoProperty() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento.set(fecha_nacimiento);
    }

    public String getCargo() {
        return cargo.get();
    }

    public void setCargo(String cargo) {
        this.cargo.set(cargo);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public int getId_empleado() {
        return id_empleado.get();
    }
    public String getNombre_empleado (){
        return nombre_empleado.get();
    }

    public SimpleIntegerProperty id_empleadoProperty() {
        return id_empleado;
    }

    public SimpleIntegerProperty idProperty() {
        return id_empleado;
    }

    public SimpleStringProperty nombreProperty() {
        return nombre_empleado;
    }

    public SimpleObjectProperty<LocalDate> fechaIngresoProperty() {
        return fecha_ingreso;
    }

    public SimpleObjectProperty<LocalDate> fechaNacimientoProperty() {
        return fecha_nacimiento;
    }

    public SimpleStringProperty cargoProperty() {
        return cargo;
    }

    public SimpleStringProperty telefonoProperty() {
        return telefono;
    }

}

