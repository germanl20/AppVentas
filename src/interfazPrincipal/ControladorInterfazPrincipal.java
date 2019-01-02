package interfazPrincipal;

import java.io.IOException;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;

import application.Controlador;
import application.Main;
import interfazPrincipal.menuLateral.ControladorMenuLateral;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ControladorInterfazPrincipal extends Controlador{
    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private JFXDrawer drawer;
    
    @FXML
    private Text txtTotalVentas;
    
    @FXML
    private void initialize() {
    }
	
	public void inicializarMenuLateral() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/interfazPrincipal/menuLateral/MenuLateral.fxml"));
			VBox menuLateral = (VBox)loader.load();
			ControladorMenuLateral controladorMenu = loader.getController();
			controladorMenu.setMain(this.getMain());
			drawer.setSidePane(menuLateral);
		} catch (IOException e) {
			e.printStackTrace();
		}
		HamburgerNextArrowBasicTransition hamburgerTransicion = new HamburgerNextArrowBasicTransition(hamburger);
		hamburgerTransicion.setRate(-1);
		hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
				hamburgerTransicion.setRate(hamburgerTransicion.getRate() * -1);
				hamburgerTransicion.play();
				if(drawer.isClosed()) {
					drawer.open();
					TranslateTransition t = new TranslateTransition(Duration.seconds(0.4), this.getMain().getRootLayout().getCenter());
					t.setToX(0);
					t.play();
				}
				else {
					drawer.close();
					TranslateTransition t = new TranslateTransition(Duration.seconds(0.4), this.getMain().getRootLayout().getCenter());
					t.setToX(-100);
					t.play();
				}
		});
		drawer.open();
	}
	
	public void incrementarTotalVentas() {
		int nuevoMonto = Integer.parseInt(txtTotalVentas.getText());
		nuevoMonto += 1;
		txtTotalVentas.setText(Integer.toString(nuevoMonto));
	}
}
