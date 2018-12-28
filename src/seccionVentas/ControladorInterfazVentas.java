package seccionVentas;

import java.util.ArrayList;

import org.controlsfx.control.textfield.TextFields;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import application.Controlador;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.InputMethodEvent;
import javafx.util.Callback;
import modelo.Articulo;

public class ControladorInterfazVentas extends Controlador{

    @FXML
    private JFXTextField txtBuscador;

    @FXML
    private JFXButton botonBuscar;

    @FXML
    private JFXButton botonDetalles;

    @FXML
    private JFXTextField txtArticuloVendido;

    @FXML
    private JFXTextField txtTalle;

    @FXML
    private JFXTextField txtPrecio;

    @FXML
    private JFXButton botonAgregarVenta;

    @FXML
    private JFXButton botonEliminarVenta;

    @FXML
    private JFXTreeTableView<Articulo> tablaDeVentas;

    @FXML
    private TreeTableColumn<Articulo, String> columnaArticulo;

    @FXML
    private TreeTableColumn<Articulo, String> columnaTalle;

    @FXML
    private TreeTableColumn<Articulo, String> columnaPrecio;
    
    private ObservableList<Articulo> articulosVendidos = FXCollections.observableArrayList();
    
    public void inicializarTabla() {
    	articulosVendidos = this.getMain().getArticulosEnStock();
    	columnaArticulo.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Articulo,String>, ObservableValue<String>>(){
    		@Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Articulo, String> param) {
                return param.getValue().getValue().getNombre();
            }
    	});
    	
    	columnaTalle.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Articulo,String>, ObservableValue<String>>(){
    		@Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Articulo, String> param) {
                return param.getValue().getValue().getTalle();
            }
    	});
    	
    	columnaPrecio.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Articulo,String>, ObservableValue<String>>(){
    		@Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Articulo, String> param) {
                return param.getValue().getValue().getPrecioVenta();
            }
    	});
    	
    	final TreeItem<Articulo> root = new RecursiveTreeItem<Articulo>(articulosVendidos, RecursiveTreeObject::getChildren);
    	tablaDeVentas.getColumns().setAll(columnaArticulo, columnaTalle, columnaPrecio);
    	tablaDeVentas.setRoot(root);
    	tablaDeVentas.setShowRoot(false);
    	
    	inicializarTxtArticuloVendido();
    }
    
    public void inicializarSugeridos(ArrayList<String> articulosSugeridos) {
    	TextFields.bindAutoCompletion(txtArticuloVendido, articulosSugeridos);
    }
    
    public void inicializarTxtArticuloVendido() {
    	txtArticuloVendido.textProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				if(getMain().getArticulosSugeridos().contains(txtArticuloVendido.getText().toLowerCase())){
		    		FilteredList<Articulo> articulo = getMain().getArticulosEnStock().filtered(art -> art.getNombre().get().equals(eliminarTalleDeNombre(txtArticuloVendido.getText()).toLowerCase()));
		    		txtArticuloVendido.setText(articulo.get(0).getNombre().get());
		    		txtTalle.setText(articulo.get(0).getTalle().get().toUpperCase());
		    		txtPrecio.setText(articulo.get(0).getPrecioVenta().get());
		    	}
			}
        });
    }
    
    private String eliminarTalleDeNombre(String articulo) {
    	String articuloSinTalle = "";
    	for(int i = 0; (i < articulo.length()) && !(articulo.charAt(i) == ' ' && articulo.charAt(i+1) == '-'); i++) {
    		articuloSinTalle += articulo.charAt(i);
    	}
    	return articuloSinTalle;
    }
}
