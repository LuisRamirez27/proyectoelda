package interfaces;

import Controladores.TDARegistro;
import DAOs.ingresoDAO;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.Main;

import javax.xml.transform.sax.SAXSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CapturarIngresos extends Stage {
    Label lblFecha,lblConcepto,lblMonto,lblTitulo,lblTotalMes,lblSaldoTotal,lblnoCasa;
    Button btnGuardar,btnRegresar;
    TextField txtConcepto,txtMonto,txtTotalMes,txtSaldoTotal,txtnoCasa;
    DatePicker dpFecha;
    TableView tableView;
    ComboBox cmbing;
    TableColumn<TDARegistro,String> clmnoCasa,clmFecha,clmConcepto,clmMonto;
    GridPane principal;
    Scene escena;
    int no_casa;
    String concepto,fecha1;
    double monto;

    Alert alert = new Alert(Alert.AlertType.NONE);

    public void CrearGUI(){
        principal=new GridPane();
        lblFecha=new Label("Fecha");
        lblConcepto=new Label("Concepto");
        lblMonto=new Label("Monto");
        lblTitulo=new Label("Registro de Ingreso/Egreso");
        lblTotalMes=new Label("Total Ingresos del mes");
        lblSaldoTotal=new Label("Saldo Total en caja");
        lblSaldoTotal.setId("Total");
        lblnoCasa= new Label("No° Casa");
//----------------------------------------------------------------------------------------------------------------------
        txtConcepto=new TextField();
        txtMonto=new TextField();
        txtTotalMes=new TextField();
        txtTotalMes.setText(String.valueOf(new ingresoDAO().selectMontoMensual()));
        txtSaldoTotal=new TextField();
        txtSaldoTotal.setText(String.valueOf(new ingresoDAO().selectMontoTotal()));
        txtSaldoTotal.setId("Total");
        txtnoCasa = new TextField();
//----------------------------------------------------------------------------------------------------------------------
        tableView=new TableView();
        clmnoCasa= new TableColumn<>("No° Casa");
        clmnoCasa.setCellValueFactory(new PropertyValueFactory<>("no_casa"));
        clmFecha=new TableColumn("Fecha");
        clmFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        clmConcepto=new TableColumn("Concepto");
        clmConcepto.setCellValueFactory(new PropertyValueFactory<>("concepto"));
        clmMonto=new TableColumn("Monto");
        clmMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        tableView.setItems(new ingresoDAO().findAll());
        tableView.getColumns().addAll(clmnoCasa,clmFecha,clmConcepto,clmMonto);
//----------------------------------------------------------------------------------------------------------------------
        btnGuardar=new Button("Guardar");
        cmbing=new ComboBox();
        cmbing.getItems().addAll("Ingreso","Egreso");
        btnRegresar = new Button("Regresar");
        dpFecha=new DatePicker();
        dpFecha.setPromptText("dd/mm/aa");
        escena=new Scene(principal);
//----------------------------------------------------------------------------------------------------------------------
        principal.add(lblTitulo,2,0,3,1);
        principal.add(lblFecha,0,1);
        principal.add(lblConcepto,0,2);
        principal.add(lblMonto,0,3);
        principal.add(dpFecha,1,1);
        principal.add(txtConcepto,1,2);
        principal.add(txtMonto,1,3);
        principal.add(txtnoCasa,1,4);
        principal.add(lblnoCasa,0,4);
        principal.add(cmbing,1,5);
        principal.add(new Label("Tipo"),0,5);
        principal.add(btnGuardar,1,6);
        principal.add(tableView,2,1,1,5);
        principal.add(lblTotalMes,3,1);
        principal.add(txtTotalMes,3,2);
        principal.add(lblSaldoTotal,3,3);
        principal.add(txtSaldoTotal,3,4);
        principal.add(btnRegresar,3,5);
        principal.setVgap(30);
        principal.setHgap(10);
        principal.setAlignment(Pos.CENTER);
        principal.autosize();
//----------------------------------------------------------------------------------------------------------------------
        txtTotalMes.setEditable(false);
        txtSaldoTotal.setEditable(false);
        escena.getStylesheets().add("css/estilo.css");
        setScene(escena);
        setMaximized(true);
        setTitle("Registro de Pago");

        btnGuardar.setOnAction(event -> {
            if(validacion()){
                try{
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    ingresoDAO agregar = new ingresoDAO();
                    no_casa = Integer.parseInt(txtnoCasa.getText());
                    concepto = txtConcepto.getText();
                    monto = Double.parseDouble(txtMonto.getText());
                    fecha1 = dpFecha.getEditor().getText();
                    TDARegistro registro=new TDARegistro();
                    registro.setConcepto(concepto);
                    registro.setMonto(monto);
                    registro.setNo_casa(no_casa+"");
                    registro.setFecha(formato.parse(fecha1));
                    alert.setAlertType(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmar informacion");
                    alert.setContentText("No de casa: "+registro.getNo_casa()+"\n" +
                                         "Fecha: "+formato.format(registro.getFecha())+"\n" +
                                         "Monto: "+monto+"\n" +
                                         "Concepto: "+concepto);
                    alert.setHeaderText("La siguiente informacion es correcta?");
                    alert.showAndWait();
                    if (alert.getResult()==ButtonType.OK){
                        if (cmbing.getValue()=="Egreso")
                            monto=monto*-1;
                        agregar.insert(no_casa,dpFecha.getValue()+"",concepto,monto,cmbing.getValue()+"");
                        tableView.refresh();
                        txtTotalMes.setText(String.valueOf(agregar.selectMontoMensual()));
                        txtSaldoTotal.setText(String.valueOf(agregar.selectMontoTotal()));
                        txtnoCasa.clear();
                        txtConcepto.clear();
                        txtMonto.clear();
                        dpFecha.setValue(null);
                        cmbing.getSelectionModel().clearSelection();
                    }
                    if (alert.getResult()==ButtonType.CANCEL){
                        alert.close();
                    }

                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });

        btnRegresar.setOnAction(event -> {
            this.close();
            Stage stage = new Stage();
            try{
                Main main = new Main();
                main.start(stage);
            }catch (Exception e){}
        });
        show();
    }


    public CapturarIngresos() {
        CrearGUI();
    }

    public boolean validacion(){
        if(txtConcepto.getText().length()==0 || txtMonto.getText().length()==0 || txtnoCasa.getText().length()==0 || dpFecha.getValue()==null){
            ALERTA();
            return false;
        }else{
            return true;
        }
    }

    private void ALERTA(){
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText("Favor de llenar todos los campos");
        alert.showAndWait();
    }

}
