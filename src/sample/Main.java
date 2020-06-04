package sample;

import interfaces.CapturarIngresos;
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
    //esto es solo un comentario sin sentido

    @Override
    public void start(Stage _primaryStage) throws Exception{
        primaryStage = _primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Interfaz principal");
        primaryStage.setScene(new Scene(root,400,275));
        primaryStage.isMaximized();
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        //
    }

}
