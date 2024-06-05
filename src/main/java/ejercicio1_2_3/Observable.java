package ejercicio1_2_3;

import java.util.List;

public class Observable {
	private List<Observer> observables;

	public Observable(List<Observer> observables) {
		this.observables = observables;
	}

	protected void notificar(String informacion) {
		for (Observer observer : observables) {
			observer.actualizar(informacion);
		}
	}
}
