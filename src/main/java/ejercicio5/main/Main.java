package ejercicio5.main;

import ejercicio5.modelo.LeerItemsPrecargados;
import ejercicio5.ui.MenuRestaurante;
import ejercicio5.ui.PantallaGerente;

public class Main {
	public static void main(String[] args) {
		var items = new LeerItemsPrecargados();
		var pantallaGerente = new PantallaGerente();
		var pantallaMenu = new MenuRestaurante(items, pantallaGerente);
	}
}
