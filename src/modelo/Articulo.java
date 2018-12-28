package modelo;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Articulo extends RecursiveTreeObject<Articulo>{
	private StringProperty nombre;
	private StringProperty precioCosto;
	private StringProperty precioVenta;
	private StringProperty talle;
	private IntegerProperty cantidad;
	
	public Articulo() {}
	
	public Articulo(String nombre, String precioCosto, String precioVenta, String talle, int cantidad) {
		this.nombre = new SimpleStringProperty(nombre);
		this.precioCosto = new SimpleStringProperty(precioCosto);
		this.precioVenta = new SimpleStringProperty(precioVenta);
		this.talle = new SimpleStringProperty(talle);
		this.cantidad = new SimpleIntegerProperty(cantidad);
	}
	
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	
	public void setPrecioCosto(String precioCosto) {
		this.precioCosto.set(precioCosto);
	}
	
	public void setPrecioVenta(String precioVenta) {
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

	public StringProperty getPrecioCosto() {
		return precioCosto;
	}

	public StringProperty getPrecioVenta() {
		return precioVenta;
	}

	public StringProperty getTalle() {
		return talle;
	}

	public IntegerProperty getCantidad() {
		return cantidad;
	}
	
}
