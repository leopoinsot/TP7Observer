package ejercicio4.main;

import ejercicio4.model.Ciudadano;
import ejercicio4.model.Concurso;
import ejercicio4.model.Email;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		var ciudadano = new Ciudadano(
				"45260989",
				"leonel",
				"poinsot",
				"leonrojo@gmail.com",
				"2920456789");

		var email = new Email();
		var concurso = new Concurso("345",
				"carrera de autos",
				LocalDate.now().minusDays(2),
				LocalDate.now().plusDays(2),
				email);
		concurso.inscribirUn(ciudadano);
	}
}
