package ejercicio1_2_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		var clima = new WeatherChannelService(
				"e19c126b96f269f9f3df66434b872e15",
				"https://api.openweathermap.org/data/2.5/weather");
		var registroMemoria = new RegistroMemoria(new BufferedWriter(new FileWriter("C:\\Users\\leonr\\OneDrive\\Escritorio\\temperaturas.txt",true)));
		var RegistroConsola= new RegistroConsola();
		var medidor = new Medidor(clima);
		medidor.leerTemperatura();
		var decoradorMedidor = new DecoradorMedidor(medidor,registroMemoria,RegistroConsola);
		decoradorMedidor.leerTemperatura();
	}
}