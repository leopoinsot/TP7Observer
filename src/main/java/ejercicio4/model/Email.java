package ejercicio4.model;

public class Email implements Observer{

	@Override
	public void actualizar(String inscripcion) {
		System.out.println("El email fue enviado: "+ inscripcion);
	}
}
