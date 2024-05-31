package ejercicio4.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso extends Observable{
	private String id;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaCierreInscripcion;

	private List<Inscripcion> inscriptos = new ArrayList<>();

	public Concurso(String id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaCierreInscripcion, Observer...observadores) {
		super(List.of(observadores));
		this.id = id;
		this.nombre = nombre;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaCierreInscripcion = fechaCierreInscripcion;
	}
	public Concurso(String id,List<Observer> observadores) {
		super(observadores);
		this.id = id;
	}

	public boolean sigueVigenteFechaInscripcion() {
		LocalDate fechaActual = LocalDate.now();
		return (fechaActual.equals(fechaInicioInscripcion) || fechaActual.isAfter(fechaInicioInscripcion)) &&
				(fechaActual.equals(fechaCierreInscripcion) || fechaActual.isBefore(fechaCierreInscripcion));
	}
	public void inscribirUn(Ciudadano ciudadano){
		if(sigueVigenteFechaInscripcion()){
			var inscripcion = new Inscripcion(ciudadano,this);
			inscriptos.add(inscripcion);
			this.notificar(inscripcion.toString());
		}
	}
	public String obtenerId(){
		return id;
	}

	@Override
	public String toString() {
		return "Concurso{" +
				"id='" + id + '\'' +
				", nombre='" + nombre + '\'' +
				", fechaInicioInscripcion=" + fechaInicioInscripcion +
				", fechaCierreInscripcion=" + fechaCierreInscripcion +
				'}';
	}
}
