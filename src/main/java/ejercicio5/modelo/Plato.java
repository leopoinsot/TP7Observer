package ejercicio5.modelo;

public class Plato {
	private String nombre;
	private float precio;

	public Plato(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public String nombre() {
		return nombre;
	}

	public float precio() {
		return precio;
	}

	@Override
	public String toString() {
		return nombre;
	}
}