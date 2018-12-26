package modelo;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Articulo extends RecursiveTreeObject<Articulo>{
	private StringProperty nombre;
	private DoubleProperty precioCosto;
	private DoubleProperty precioVenta;
	private StringProperty talle;
	private IntegerProperty cantidad;
	
	public Articulo() {}
	
	public Articulo(String nombre, double precioCosto, double precioVenta, String talle, int cantidad) {
		this.nombre = new SimpleStringProperty(nombre);
		this.precioCosto = new SimpleDoubleProperty(precioCosto);
		this.precioVenta = new SimpleDoubleProperty(precioVenta);
		this.talle = new SimpleStringProperty(talle);
		this.cantidad = new SimpleIntegerProperty(cantidad);
	}
	
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	
	public void setPrecioCosto(Double precioCosto) {
		this.precioCosto.set(precioCosto);
	}
	
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta.set(precioVenta);
	}
	
	public void setTalle(String talle) {
		this.talle.set(talle);
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad.set(cantidad);
	}

	public StringProperty getNombre() {
		return nombre;
	}

	public DoubleProperty getPrecioCosto() {
		return precioCosto;
	}

	public DoubleProperty getPrecioVenta() {
		return precioVenta;
	}

	public StringProperty getTalle() {
		return talle;
	}

	public IntegerProperty getCantidad() {
		return cantidad;
	}
	
}
