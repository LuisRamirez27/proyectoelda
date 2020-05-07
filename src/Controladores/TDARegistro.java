package Controladores;

import java.sql.Connection;
import java.util.Date;

public class TDARegistro {
    int id_ing;
    Date fecha;
    String concepto;
    double monto;
    String tipo_monto;
    int numero_casa;
    Connection conn;


    public TDARegistro() {
        conn=new MySQL().getConectar();
    }

    public TDARegistro(Date fecha, String concepto, double monto) {
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
    }

    public TDARegistro(int id_ing, Date fecha, String concepto, double monto, String tipo_monto, int numero_casa) {
        this.id_ing = id_ing;
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
        this.tipo_monto = tipo_monto;
        this.numero_casa = numero_casa;
    }

    public int getId_ing() {
        return id_ing;
    }

    public void setId_ing(int id_ing) {
        this.id_ing = id_ing;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo_monto() {
        return tipo_monto;
    }

    public void setTipo_monto(String tipo_monto) {
        this.tipo_monto = tipo_monto;
    }

    public int getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(int numero_casa) {
        this.numero_casa = numero_casa;
    }
}
