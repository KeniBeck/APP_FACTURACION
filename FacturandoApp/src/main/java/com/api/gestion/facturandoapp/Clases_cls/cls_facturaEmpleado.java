package com.api.gestion.facturandoapp.Clases_cls;
import javafx.beans.property.*;

import java.time.LocalDate;
public class cls_facturaEmpleado {


private final SimpleIntegerProperty idFactura;
    private final SimpleIntegerProperty idEmpleado;
    private final SimpleStringProperty nombreEmpleado;
    private final SimpleObjectProperty<LocalDate> fechaEmision;
    private final SimpleStringProperty descripcion;
    private final SimpleIntegerProperty cantidad;
    private final SimpleDoubleProperty valorUnitario;
    private final SimpleDoubleProperty valorTotal;

    public cls_facturaEmpleado(int idFactura, int idEmpleado, String nombreEmpleado, LocalDate fechaEmision,
                               String descripcion, int cantidad, double valorUnitario, double valorTotal) {
        this.idFactura = new SimpleIntegerProperty(idFactura);
        this.idEmpleado = new SimpleIntegerProperty(idEmpleado);
        this.nombreEmpleado = new SimpleStringProperty(nombreEmpleado);
        this.fechaEmision = new SimpleObjectProperty<>(fechaEmision);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.cantidad = new SimpleIntegerProperty(cantidad);
        this.valorUnitario = new SimpleDoubleProperty(valorUnitario);
        this.valorTotal = new SimpleDoubleProperty(valorTotal);
    }

    public int getIdFactura() {
        return idFactura.get();
    }

    public SimpleIntegerProperty idFacturaProperty() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura.set(idFactura);
    }

    public int getIdEmpleado() {
        return idEmpleado.get();
    }

    public SimpleIntegerProperty idEmpleadoProperty() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado.set(idEmpleado);
    }

    public String getNombreEmpleado() {
        return nombreEmpleado.get();
    }

    public SimpleStringProperty nombreEmpleadoProperty() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado.set(nombreEmpleado);
    }

    public LocalDate getFechaEmision() {
        return fechaEmision.get();
    }

    public SimpleObjectProperty<LocalDate> fechaEmisionProperty() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision.set(fechaEmision);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public SimpleStringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public SimpleIntegerProperty cantidadProperty() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad.set(cantidad);
    }

    public double getValorUnitario() {
        return valorUnitario.get();
    }

    public SimpleDoubleProperty valorUnitarioProperty() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario.set(valorUnitario);
    }

    public double getValorTotal() {
        return valorTotal.get();
    }

    public SimpleDoubleProperty valorTotalProperty() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal.set(valorTotal);
    }
}

