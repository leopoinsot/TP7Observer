package ejercicio4.model;

public class Inscripcion {
	private Ciudadano ciudadano;
	private Concurso concurso;

	public Inscripcion(Ciudadano ciudadano, Concurso concurso) {
		this.ciudadano = ciudadano;
		this.concurso = concurso;
	}

	@Override
	public String toString() {
		return "Inscripcion{" +
				"ciudadano=" + ciudadano +
				", concurso=" + concurso +
				'}';
	}
}
