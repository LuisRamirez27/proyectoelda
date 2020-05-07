package sample;

import Controladores.MySQL;
import interfaces.CapturarIngresos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button BtnCaptura,BtnRegistros,BtnExit;
    @FXML
    ImageView Iv_Dolar,Iv_Tabla,Iv_Salir;

    Main main = new Main();
    Alert alert = new Alert(Alert.AlertType.NONE);
    Connection conn;
    Image image1 = new Image(getClass().getResourceAsStream("/images/D.png"));
    Image image2 = new Image(getClass().getResourceAsStream("/images/Registros.png"));
    Image image3 = new Image(getClass().getResourceAsStream("/images/cerrar.png"));

    EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(event.getSource() == BtnCaptura){
                main.primaryStage.hide();
                new CapturarIngresos();
            }else if(event.getSource() == BtnRegistros){

            }else if(event.getSource() == BtnExit){
                Close();
            }
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BtnCaptura.setOnAction(handler);
        BtnRegistros.setOnAction(handler);
        BtnExit.setOnAction(handler);
        Iv_Dolar.setImage(image1);
        Iv_Tabla.setImage(image2);
        Iv_Salir.setImage(image3);
    }

    private void Close(){
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMACION");
        alert.setContentText("¿Deseas salir del programa?");
        alert.showAndWait();
        if(alert.getResult() == ButtonType.CANCEL){
            alert.close();
        }else if(alert.getResult() == ButtonType.OK){
            System.exit(0);
        }
    }
}
