package ejercicio1_2_3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroMemoria implements Observer {
	private BufferedWriter bufferedWriter;

	RegistroMemoria(BufferedWriter bufferedWriter){
		this.bufferedWriter = bufferedWriter;
	}
	@Override
	public void actualizar(String temperatura) {
		LocalDateTime fechaActual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String fechaFormateada = fechaActual.format(formatter);
		String registro = String.format("%s Temperatura: %s\n", fechaFormateada, temperatura);
		try {
			bufferedWriter.write(registro);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
