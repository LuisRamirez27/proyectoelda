package interfaces;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class interfazPrincipalEjemplo extends Stage {
    Button CapIngrAceptar=new Button("Aceptar");
    Button VerIngrAceptar=new Button("Aceptar");
    Button Salir=new Button("Aceptar");
    ImageView ImgVDolar,ImgVTabla,ImgVSalir;
    Label lblCapturar,lblVer,lblSalr,lblTitulo;
    VBox vbPrincipal=new VBox();
    HBox[] arrhbox=new HBox[3];
    Scene escena;

    public interfazPrincipalEjemplo() {
        CrearGUI();


    }
    public void CrearGUI(){
        for (int i=0;i<arrhbox.length;i++){
            arrhbox[i]=new HBox();
            arrhbox[i].setAlignment(Pos.CENTER);
        }
        ImgVDolar =new ImageView("/images/dolar.png");
        ImgVDolar.setFitHeight(40);
        ImgVDolar.setFitWidth(40);
        ImgVTabla=new ImageView("/images/ver.jpg");
        ImgVTabla.setFitHeight(40);
        ImgVTabla.setFitWidth(40);
        ImgVSalir=new ImageView("/images/salir.jpg");
        ImgVSalir.setFitHeight(40);
        ImgVSalir.setFitWidth(40);
        lblTitulo=new Label("Registro de ingresos");
        lblTitulo.setMaxSize(50,20);
        lblCapturar=new Label("Capturar ingreso");
        lblVer=new Label("Var ingresos");
        lblSalr=new Label("Salir");
        vbPrincipal.setAlignment(Pos.TOP_CENTER);
        arrhbox[0].getChildren().addAll(ImgVDolar,lblCapturar,CapIngrAceptar);
        arrhbox[1].getChildren().addAll(ImgVTabla,lblVer,VerIngrAceptar);
        arrhbox[2].getChildren().addAll(ImgVSalir,lblSalr,Salir);
        vbPrincipal.getChildren().addAll(lblTitulo,arrhbox[0],arrhbox[1],arrhbox[2]);
        escena=new Scene(vbPrincipal);
        setScene(escena);
        show();
    }
}
