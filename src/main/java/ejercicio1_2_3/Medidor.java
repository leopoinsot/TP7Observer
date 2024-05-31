package ejercicio1_2_3;

public class Medidor implements Temperatura{
	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima) {
		this.clima = clima;
	}
	@Override
	public String leerTemperatura() {
		//leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		return this.temperatura;
	}
}
