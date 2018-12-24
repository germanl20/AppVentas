package interfazPrincipal;

import java.io.IOException;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;

import application.Main;
import interfazPrincipal.menuLateral.ControladorMenuLateral;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class ControladorInterfazPrincipal {
	private Main main;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    
    @FXML
    private void initialize() {
    }
    
	public Main getMain() {
		return main;
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void inicializarMenuLateral() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/interfazPrincipal/menuLateral/MenuLateral.fxml"));
			VBox menuLateral = (VBox)loader.load();
			ControladorMenuLateral controladorMenu = loader.getController();
			controladorMenu.setMain(this.main);
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
					TranslateTransition t = new TranslateTransition(Duration.seconds(0.4), main.getRootLayout().getCenter());
					t.setToX(0);
					t.play();
				}
				else {
					drawer.close();
					TranslateTransition t = new TranslateTransition(Duration.seconds(0.4), main.getRootLayout().getCenter());
					t.setToX(-100);
					t.play();
				}
		});
		drawer.open();
	}
}
