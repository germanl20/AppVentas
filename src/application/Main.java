package application;

import java.io.IOException;

import interfazPrincipal.ControladorInterfazPrincipal;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import modelo.Articulo;
import seccionVentas.ControladorInterfazVentas;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private BorderPane rootLayout;
	private ObservableList<Articulo> articulos = FXCollections.observableArrayList();
	private BorderPane seccionVentas;
	
	public BorderPane getSeccionVentas() {
		return seccionVentas;
	}

	public ObservableList<Articulo> getArticulos() {
		return articulos;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Ventas(cambiar)");
		mostrarInterfazPrincipal();
		inicializarArticulos();
		cargarSeccionVentas();
	}
	
	private void mostrarInterfazPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/interfazPrincipal/InterfazPrincipal.fxml"));
			rootLayout = (BorderPane) loader.load();
			ControladorInterfazPrincipal controlador = loader.getController();
			controlador.setMain(this);
			controlador.inicializarMenuLateral();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cargarSeccionCentro(BorderPane seccionCentro) {
		rootLayout.setCenter(seccionCentro);
	}
	
	public void cargarSeccionVentas() {
		try {
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("/seccionVentas/InterfazVentas.fxml"));
			BorderPane seccionVentas = (BorderPane) loader.load();
			rootLayout.setCenter(seccionVentas);
			this.seccionVentas = seccionVentas;
			ControladorInterfazVentas controlador = loader.getController();
			controlador.setMain(this);
			controlador.inicializarTabla();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void inicializarArticulos() {
		articulos.add(new Articulo("Camisa", 150, 300, "S", 3));
    	articulos.add(new Articulo("Jean", 220, 450, "38", 5));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
