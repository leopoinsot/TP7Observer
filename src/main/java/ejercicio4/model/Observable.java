package ejercicio4.model;

import java.util.List;

public class Observable{
	private List<Observer> observadores;
	public Observable(List<Observer> observadores){
		this.observadores = observadores;
	}
	public void notificar(String inscripcion){
		for(Observer observer: observadores){
			observer.actualizar(inscripcion);
		}
	}
}
