package ejercicio5.ui;

import ejercicio5.modelo.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;

public class MenuRestaurante extends Observable {
	private JPanel contentPane;
	private JComboBox<Integer> comboBoxMesas;
	private JComboBox<Plato> comboBoxPlatos;
	private JComboBox<Bebida> comboBoxBebidas;
	private JButton btnAgregarPlato;
	private JButton btnAgregarBebida;
	private JButton btnPagar;
	private JTextArea txtAreaPedido;
	private float montoTotal = 0;
	private JLabel lblMontoTotal;
	private LecturaDeItems leerItems;

	public MenuRestaurante(LecturaDeItems leerItems, Observer... observadores) {
		super(List.of(observadores));
		this.leerItems = leerItems;
		var frame = new JFrame("Restaurante");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		formElements();
		layout();
		frame.setVisible(true);
	}

	private void formElements() {
		comboBoxMesas = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			comboBoxMesas.addItem(i);
		}
		comboBoxPlatos = new JComboBox<>();
		llenarComboPlatos();
		comboBoxBebidas = new JComboBox<>();
		llenarComboBebidas();

		btnAgregarPlato = new JButton("Agregar Plato");
		btnAgregarPlato.addActionListener(e -> {
			Plato platoSeleccionado = (Plato) comboBoxPlatos.getSelectedItem();
			if (platoSeleccionado != null) {
				txtAreaPedido.append(platoSeleccionado.nombre() + " - $" + platoSeleccionado.precio() + "\n");
				montoTotal += platoSeleccionado.precio();
				actualizarMontoTotal();
			}
		});

		btnAgregarBebida = new JButton("Agregar Bebida");
		btnAgregarBebida.addActionListener(e -> {
			Bebida bebidaSeleccionada = (Bebida) comboBoxBebidas.getSelectedItem();
			if (bebidaSeleccionada != null) {
				txtAreaPedido.append(bebidaSeleccionada.nombre() + " - $" + bebidaSeleccionada.precio() + "\n");
				montoTotal += bebidaSeleccionada.precio();
				actualizarMontoTotal();
			}
		});

		txtAreaPedido = new JTextArea();
		lblMontoTotal = new JLabel("Monto Total: $0.00");
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(e -> mostrarOpcionesDePago());
	}

	private void layout() {
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(txtAreaPedido, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(comboBoxMesas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(comboBoxPlatos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnAgregarPlato)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(comboBoxBebidas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnAgregarBebida)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnPagar))
										.addComponent(lblMontoTotal))
								.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(comboBoxMesas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxPlatos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAgregarPlato)
										.addComponent(comboBoxBebidas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAgregarBebida)
										.addComponent(btnPagar))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(txtAreaPedido, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(lblMontoTotal)
								.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void actualizarMontoTotal() {
		lblMontoTotal.setText("Monto Total: $" + String.format("%.2f", montoTotal));
	}

	private void llenarComboPlatos() {
		var platos = leerItems.platosDisponibles();
		if (platos.isEmpty()) {
			System.out.println("No se encontraron platos disponibles.");
		} else {
			platos.forEach(p -> comboBoxPlatos.addItem(p));
			System.out.println("Platos cargados correctamente.");
		}
	}

	private void llenarComboBebidas() {
		var bebidas = leerItems.bebidasDisponibles();
		if (bebidas.isEmpty()) {
			System.out.println("No se encontraron bebidas disponibles.");
		} else {
			bebidas.forEach(b -> comboBoxBebidas.addItem(b));
			System.out.println("Bebidas cargadas correctamente.");
		}
	}

	private void mostrarOpcionesDePago() {
		String[] opcionesDePago = {"Visa", "MasterCard", "Comarca Plus", "Tarjeta Generica"};
		String metodoSeleccionado = (String) JOptionPane.showInputDialog(
				contentPane,
				"Seleccione el método de pago:",
				"Opciones de Pago",
				JOptionPane.PLAIN_MESSAGE,
				null,
				opcionesDePago,
				opcionesDePago[0]);
		if (metodoSeleccionado != null) {
			JOptionPane.showMessageDialog(contentPane, "Monto total a pagar: $" + montoTotal + "\nMétodo de pago: " + metodoSeleccionado);
			notificar(montoTotal);
			montoTotal = 0;
			txtAreaPedido.setText("");
			actualizarMontoTotal();
		}
	}
}
