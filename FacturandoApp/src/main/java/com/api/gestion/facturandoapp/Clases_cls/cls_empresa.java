package com.api.gestion.facturandoapp.Clases_cls;

import java.time.LocalDate;

public class cls_empresa {
    private int nit;
    private String nombreEmpresa;
    private LocalDate fechaVinculacion;

    public cls_empresa(int nit, String nombreEmpresa, LocalDate fechaVinculacion) {
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.fechaVinculacion = fechaVinculacion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(LocalDate fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }
}
