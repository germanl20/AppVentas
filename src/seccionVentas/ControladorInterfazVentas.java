package seccionVentas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import application.Controlador;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
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
    
    private ObservableList<Articulo> articulos;
    
    public void inicializarTabla() {
    	articulos = this.getMain().getArticulos();
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
                return param.getValue().getValue().getPrecioVenta().asString();
            }
    	});
    	
    	final TreeItem<Articulo> root = new RecursiveTreeItem<Articulo>(articulos, RecursiveTreeObject::getChildren);
    	tablaDeVentas.getColumns().setAll(columnaArticulo, columnaTalle, columnaPrecio);
    	tablaDeVentas.setRoot(root);
    	tablaDeVentas.setShowRoot(false);
    }
}
