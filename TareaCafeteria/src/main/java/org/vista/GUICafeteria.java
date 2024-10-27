package org.vista;

import org.data.GestorDatos;
import org.model.Cafeteria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICafeteria extends JFrame implements ActionListener {

	private final Cafeteria cafeteria;
	private JButton bAgregarCafe;
	private JButton bBuscarCafes;
	private JButton bDiscontinuarCafe;
	private JButton bEditarInformacion;

	public GUICafeteria() {
		GestorDatos file = new GestorDatos();
		this.cafeteria = file.leerArchivoCafeteria();
	}

	public void mostrarInterfaz() {
		configurarVentana();
		JPanel panel = crearPanel();
		agregarComponentes(panel);
		mostrarVentana(panel);
	}

	private void configurarVentana() {
		setTitle("Cafetería");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
	}

	private JPanel crearPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		JLabel titleLabel = new JLabel("Cafetería", SwingConstants.CENTER);
		configurarTitulo(titleLabel, gbc, panel);

		bAgregarCafe = crearBoton("Agregar Café", new Color(100, 200, 255));
		configurarBoton(bAgregarCafe, gbc, panel, 2);

		bBuscarCafes = crearBoton("Buscar Café", new Color(100, 255, 100));
		configurarBoton(bBuscarCafes, gbc, panel, 3);


		bDiscontinuarCafe = crearBoton("Discontinuar Café", new Color(255, 100, 100));
		configurarBoton(bDiscontinuarCafe, gbc, panel, 5);

		bEditarInformacion = crearBoton("Editar Información", new Color(255, 255, 100));
		configurarBoton(bEditarInformacion, gbc, panel, 6);

		return panel;
	}

	private void configurarTitulo(JLabel label, GridBagConstraints gbc, JPanel panel) {
		label.setFont(new Font("Arial", Font.BOLD, 20));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(label, gbc);
	}

	private JButton crearBoton(String texto, Color color) {
		JButton button = new JButton(texto);
		button.addActionListener(this);
		button.setBackground(color);
		return button;
	}

	private void configurarBoton(JButton button, GridBagConstraints gbc, JPanel panel, int gridY) {
		gbc.gridx = 0;
		gbc.gridy = gridY;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(button, gbc);
	}

	private void agregarComponentes(JPanel panel) {
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	private void mostrarVentana(JPanel panel) {
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bAgregarCafe) {
			dispose();
			new GUIAgregarCafe(this.cafeteria).mostrarInterfaz();
		} else if (e.getSource() == bBuscarCafes) {
			dispose();
			new GUIBuscarCafe(this.cafeteria);
		} else if (e.getSource() == bDiscontinuarCafe) {
			dispose();
			new GUIDiscontinuarCafe(this.cafeteria);
		} else if (e.getSource() == bEditarInformacion) {
			dispose();
			new GUIEditarInformacion(this.cafeteria).mostrarInterfaz();
		}
	}
}