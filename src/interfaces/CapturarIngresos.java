package interfaces;

import Controladores.TDARegistro;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class CapturarIngresos extends Stage {
    Label lblFecha,lblConcepto,lblMonto,lblTitulo,lblTotalMes,lblSaldoTotal;
    Button btnGuardar;
    TextField txtConcepto,txtMonto,txtTotalMes,txtSaldoTotal;
    DatePicker dpFecha;
    TableView tableView;
    TableColumn clmFecha,clmConcepto,clmMonto;
    GridPane principal;
    Scene escena;

    public void CrearGUI(){
        principal=new GridPane();
        lblFecha=new Label("Fecha");
        lblConcepto=new Label("Concepto");
        lblMonto=new Label("Monto");
        lblTitulo=new Label("Registro de Pago");
        lblTotalMes=new Label("Total Ingresos del mes");
        lblSaldoTotal=new Label("Saldo Total en caja");
//----------------------------------------------------------------------------------------------------------------------
        txtConcepto=new TextField();
        txtMonto=new TextField();
        txtTotalMes=new TextField();
        txtSaldoTotal=new TextField();
//----------------------------------------------------------------------------------------------------------------------
        tableView=new TableView();
        clmFecha=new TableColumn("Fecha");
        clmConcepto=new TableColumn("Concepto");
        clmMonto=new TableColumn("Monto");
        tableView.getColumns().addAll(clmFecha,clmConcepto,clmMonto);
//----------------------------------------------------------------------------------------------------------------------
        btnGuardar=new Button("Guardar");
        dpFecha=new DatePicker();
        escena=new Scene(principal);
//----------------------------------------------------------------------------------------------------------------------
        principal.add(lblTitulo,2,0,3,1);
        principal.add(lblFecha,0,1);
        principal.add(lblConcepto,0,2);
        principal.add(lblMonto,0,3);
        principal.add(dpFecha,1,1);
        principal.add(txtConcepto,1,2);
        principal.add(txtMonto,1,3);
        principal.add(btnGuardar,1,4);
        principal.add(tableView,2,1,1,5);
        principal.add(lblTotalMes,3,1);
        principal.add(txtTotalMes,3,2);
        principal.add(lblSaldoTotal,3,3);
        principal.add(txtSaldoTotal,3,4);
        principal.setVgap(30);
        principal.setHgap(10);
        principal.setAlignment(Pos.CENTER);
        principal.autosize();
//----------------------------------------------------------------------------------------------------------------------
        txtTotalMes.setDisable(true);
        txtSaldoTotal.setDisable(true);
        setScene(escena);
        setMaximized(true);
        setTitle("Registro de Pago");
        btnGuardar.setOnAction(event -> Guardar());
        show();
    }

    private void Guardar() {
        TDARegistro registro =new TDARegistro();

    }

    public CapturarIngresos() {
        CrearGUI();
    }
}
