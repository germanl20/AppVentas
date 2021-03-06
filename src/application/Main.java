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
	private ObservableList<Articulo> articulosEnStock = FXCollections.observableArrayList();
	private BorderPane seccionVentas;
	private ControladorInterfazPrincipal controladorInterfazPrincipal;

	public ControladorInterfazPrincipal getControladorInterfazPrincipal() {
		return controladorInterfazPrincipal;
	}

	public BorderPane getSeccionVentas() {
		return seccionVentas;
	}

	public ObservableList<Articulo> getArticulosEnStock() {
		return articulosEnStock;
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
			controladorInterfazPrincipal = loader.getController();
			controladorInterfazPrincipal.setMain(this);
			controladorInterfazPrincipal.inicializarMenuLateral();
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
			controlador.inicializarSugeridos();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void inicializarArticulos() { //trae el stock desde LA BASE DE DATOS
		articulosEnStock.add(new Articulo("camisa", "150", "300", "s", 3));
		articulosEnStock.add(new Articulo("camisa", "150", "350", "m", 3));
    	articulosEnStock.add(new Articulo("jean", "220", "450", "38", 5));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
