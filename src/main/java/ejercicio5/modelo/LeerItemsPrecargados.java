package ejercicio5.modelo;

import java.util.ArrayList;
import java.util.List;

public class LeerItemsPrecargados implements LecturaDeItems {
	@Override
	public List<Plato> platosDisponibles() {
		List<Plato> platos = new ArrayList<>();
		var plato1 = new Plato("milanesa", 100000f);
		var plato2 = new Plato("ensalada", 20000f);
		var plato3 = new Plato("tarta", 80000f);
		var plato4 = new Plato("fideos", 50000f);
		var plato5 = new Plato("choclo", 70000f);
		platos.add(plato1);
		platos.add(plato2);
		platos.add(plato3);
		platos.add(plato4);
		platos.add(plato5);
		return platos;
	}

	@Override
	public List<Bebida> bebidasDisponibles() {
		var bebida1 = new Bebida(10000f, "cocacola");
		var bebida2 = new Bebida(20000f, "sprite");
		var bebida3 = new Bebida(30000f, "cola");
		var bebida4 = new Bebida(40000f, "fanta");
		var bebida5 = new Bebida(50000f, "mocoreta");
		List<Bebida> bebidas = new ArrayList<>();
		bebidas.add(bebida1);
		bebidas.add(bebida2);
		bebidas.add(bebida3);
		bebidas.add(bebida4);
		bebidas.add(bebida5);
		return bebidas;
	}
}