package sample;

import interfaces.CapturarIngresos;
import interfaces.interfazPrincipalEjemplo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static  Stage primaryStage;
    Stage stage = new Stage();

    @Override
    public void start(Stage _primaryStage) throws Exception{
        primaryStage = _primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Captura de Ingresos");
        primaryStage.setScene(new Scene(root,400,275));
        primaryStage.show();
        //new interfazPrincipalEjemplo();
        //new CapturarIngresos();
    }

    public void cargar(FXMLLoader loader, Object controller, ActionEvent event, Boolean size, String titulo) {
        try {
            Parent root= null;
            loader.setController(controller);
            root=loader.load();
            Scene scene=new Scene(root);
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.setMaximized(size);
            stage.show();
            ((Stage)(((Button) event.getSource()).getScene().getWindow())).hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
