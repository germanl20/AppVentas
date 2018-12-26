package interfazPrincipal.menuLateral;

import com.jfoenix.controls.JFXButton;

import application.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControladorMenuLateral extends Controlador{

    @FXML
    private JFXButton botonVentas;

    @FXML
    private JFXButton botonStock;

    @FXML
    private JFXButton botonCalculos;

    @FXML
    private JFXButton botonEstadisticas;

    @FXML
    private JFXButton botonConfiguracion;
    
    private JFXButton botonSeleccionado;

	@FXML
    private void initialize() {
    	this.botonSeleccionado = botonVentas;
    	botonSeleccionado.setId("boton-seleccionado");
    }
    
    private void seleccionarBoton(JFXButton botonSeleccionado){
    	this.botonSeleccionado.setId("");
    	botonSeleccionado.setId("boton-seleccionado");
    	this.botonSeleccionado = botonSeleccionado;
    }
    
    @FXML
    void clickCalculos(ActionEvent event) {
    	if(!botonSeleccionado.equals((JFXButton)event.getSource())) {
    		seleccionarBoton((JFXButton)event.getSource());
    	}
    }

    @FXML
    void clickConfiguracion(ActionEvent event) {
    	if(!botonSeleccionado.equals((JFXButton)event.getSource())) {
    		seleccionarBoton((JFXButton)event.getSource());
    	}
    }

    @FXML
    void clickEstadisticas(ActionEvent event) {
    	if(!botonSeleccionado.equals((JFXButton)event.getSource())) {
    		seleccionarBoton((JFXButton)event.getSource());
    	}
    }

    @FXML
    void clickStock(ActionEvent event) {
    	if(!botonSeleccionado.equals((JFXButton)event.getSource())) {
    		seleccionarBoton((JFXButton)event.getSource());
    	}
    }

    @FXML
    void clickVentas(ActionEvent event) {
    	if(!botonSeleccionado.equals((JFXButton)event.getSource())) {
    		seleccionarBoton((JFXButton)event.getSource());
        	this.getMain().cargarSeccionCentro(this.getMain().getSeccionVentas());
    	}
    }
}
