package ar.edu.unrn.api;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public interface IApi {
	public void registrar(LocalDate fecha, LocalTime hora, double monto) throws IOException;
}
