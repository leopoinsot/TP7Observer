package ejercicio5.modelo;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	private List<Observer> observadores = new ArrayList<>();

	public Observable(List<Observer> observadores) {
		this.observadores = observadores;
	}

	public void notificar(float monto) {
		for (Observer observer : observadores) {
			observer.actualizar(monto);
		}
	}
}
