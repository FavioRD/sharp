package clases;

public class Venta {	
	public String producto;
	public double precio;
	private int cantidad;
	//constructor
	public Venta(String producto, double precio, int cantidad) {
		super();
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	//metodos clasicos
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	//metodos generales
	public double subTotal() {
		return cantidad*precio;
	}
	
	public double descuento() {
		if(cantidad>3) 
			return precio*0.2;
		return 0;
		}
	
	public double total() {
		return subTotal()-descuento();
	}
}

	


