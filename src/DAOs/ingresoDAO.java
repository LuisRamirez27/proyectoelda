package DAOs;

import Controladores.TDARegistro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ingresoDAO {
    Connection conn;
    private static ObservableList<TDARegistro> data = FXCollections.observableArrayList();
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
}
