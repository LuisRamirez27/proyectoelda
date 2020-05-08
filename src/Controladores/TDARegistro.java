package Controladores;

import java.sql.Connection;
import java.util.Date;

public class TDARegistro {
    int id_ing;
    Date fecha;
    String concepto;
    double monto;
    String tipo_monto;
    int no_casa;
    Connection conn;


    public TDARegistro() {
        conn=new MySQL().getConectar();
    }

    public TDARegistro(int no_casa, Date fecha, String concepto, double monto) {
        this.no_casa = no_casa;
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
    }

    public TDARegistro(int id_ing, Date fecha, String concepto, double monto, String tipo_monto, int no_casa) {
        this.id_ing = id_ing;
        this.fecha = fecha;
        this.concepto = concepto;
        this.monto = monto;
        this.tipo_monto = tipo_monto;
        this.no_casa = no_casa;
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

    public int getNo_casa() {
        return no_casa;
    }

    public void setNo_casa(int no_casa) {
        this.no_casa = no_casa;
    }
}
