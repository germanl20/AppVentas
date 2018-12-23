package application;

import java.io.IOException;

import interfazPrincipal.ControladorInterfazPrincipal;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private BorderPane rootLayout;
	
	public BorderPane getRootLayout() {
		return rootLayout;
	}

	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Ventas(cambiar)");
		mostrarInterfazPrincipal();
		mostrarSeccionCentro();
	}
	
	private void mostrarInterfazPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/interfazPrincipal/InterfazPrincipal.fxml"));
			rootLayout = (BorderPane) loader.load();
			ControladorInterfazPrincipal controlador = loader.getController();
			controlador.setMain(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarSeccionCentro() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("/seccionVentas/InterfazVentas.fxml"));
			BorderPane seccionVentas = (BorderPane) loader.load();
			rootLayout.setCenter(seccionVentas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
