package DAOs;

import Controladores.MySQL;
import Controladores.TDARegistro;
import com.mysql.jdbc.MySQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ingresoDAO {
    Connection conn=new MySQL().getConectar();
    private static ObservableList<TDARegistro> data = FXCollections.observableArrayList();
//----------------------------------------------------------------------------------------------------------------------
    public ObservableList<TDARegistro> findAll() {
        ObservableList<TDARegistro> registros = FXCollections.observableArrayList();
        try {
            String query = "select * from ingreso";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            TDARegistro r = null;
            while (rs.next()) {
                r = new TDARegistro(
                        rs.getDate("fecha"),
                        rs.getString("concepto"),
                        rs.getDouble("monto")
                );
                registros.add(r);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return registros;
    }
//----------------------------------------------------------------------------------------------------------------------
    public double selectMontoMensual(){
        double monto=0;
        try {

            String query = "select sum(monto) montoXmes from ingreso where month(fecha)=month(now()) and year(fecha)=year(now());";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            monto=rs.getDouble("montoXmes");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return monto;
    }
//----------------------------------------------------------------------------------------------------------------------
    public double selectMontoTotal(){
        double monto=0;
        try {

            String query = "select sum(monto) montoTotal from ingreso";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            monto=rs.getDouble("montoTotal");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return monto;
    }
//----------------------------------------------------------------------------------------------------------------------
    public boolean insert(Date fecha,String concepto, double monto){
        try{
            String query="insert into ingreso (fecha,concepto,monto)" +
                    "values ("+fecha+",'"+concepto+"',"+monto+");";
            Statement statement=conn.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
        }
        catch (Exception e){

        }

        return true;

    }
}
