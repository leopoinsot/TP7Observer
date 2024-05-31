package ejercicio5.modelo;

public class Bebida {
	private double precio;
	private String marca;

	public Bebida(double precio, String marca) {
		this.precio = precio;
		this.marca = marca;
	}

	public String nombre() {
		return marca;
	}

	public double precio() {
		return precio;
	}

	@Override
	public String toString() {
		return marca;
	}
}