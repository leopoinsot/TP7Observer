package ejercicio5.ui;

import ejercicio5.modelo.Observer;

import javax.swing.*;
import java.awt.*;

public class PantallaGerente extends JFrame implements Observer {
	private JLabel lblMontoFacturado;

	public PantallaGerente() {
		setTitle("Pantalla Gerente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		lblMontoFacturado = new JLabel("Monto Facturado: $0.00");
		lblMontoFacturado.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblMontoFacturado, BorderLayout.CENTER);
		setVisible(true);
	}

	@Override
	public void actualizar(float montoFacturado) {
		lblMontoFacturado.setText("Monto Facturado: $" + String.format("%.2f", montoFacturado));
		if (montoFacturado > 300000f) { //El enunciado dice si supera los 3000000 (>)
			lblMontoFacturado.setForeground(Color.RED);
		} else {
			lblMontoFacturado.setForeground(Color.BLACK);
		}
	}
}
