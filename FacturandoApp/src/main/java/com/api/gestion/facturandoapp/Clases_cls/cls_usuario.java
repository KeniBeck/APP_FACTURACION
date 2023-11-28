package com.api.gestion.facturandoapp.Clases_cls;

public class cls_usuario {
private String str_nombres;
private int str_id;
private String str_fecha_nacimiento;
private String str_contraseña;

    public cls_usuario(String nombres, int id, String fecha_nacimiento, String contraseña) {
        this.str_nombres = nombres;
        this.str_id = id;
        this.str_fecha_nacimiento = fecha_nacimiento;
        this.str_contraseña = contraseña;
    }

    public String getStr_nombres() {
        return str_nombres;
    }

    public void setStr_nombres(String str_nombres) {
        this.str_nombres = str_nombres;
    }

    public int getStr_id() {
        return str_id;
    }

    public void setStr_id(int str_id) {
        this.str_id = str_id;
    }

    public String getStr_fecha_nacimiento() {
        return str_fecha_nacimiento;
    }

    public void setStr_fecha_nacimiento(String str_fecha_nacimiento) {
        this.str_fecha_nacimiento = str_fecha_nacimiento;
    }

    public String getStr_contraseña() {
        return str_contraseña;
    }

    public void setStr_contraseña(String str_contraseña) {
        this.str_contraseña = str_contraseña;
    }


}
