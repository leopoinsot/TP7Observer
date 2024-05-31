package ejercicio1_2_3;

public class RegistroConsola implements Observer{
	@Override
	public void actualizar(String temperatura) {
		if(haceFrio(temperatura)){
			System.out.println("Hace frio, se encenderá la caldera");
		}else{
			System.out.println("Hace calor, se encenderá el aire acondicionado");
		}
	}
	private boolean haceFrio(String temperatura){
		// Extraer la parte numérica del string, asumiendo que está al principio
		String numero = temperatura.split(" ")[0].replace("°C", "").trim();
		// Convertir a double en lugar de int, para manejar temperaturas con decimales
		double temperaturaFormateado = Double.parseDouble(numero);
		return  temperaturaFormateado < 13;
	}
}
