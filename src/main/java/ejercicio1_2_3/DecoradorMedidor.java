package ejercicio1_2_3;

import java.util.List;

public class DecoradorMedidor extends Observable implements Temperatura{
	private Medidor medidor;
	public DecoradorMedidor(Medidor medidor, Observer...observables){
		super(List.of(observables));
		this.medidor = medidor;
	}
	@Override
	public String leerTemperatura() {
		String tem = medidor.leerTemperatura();
		this.notificar(tem);
		return tem;
	}
}
