package algocity.vistas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class MenuPanel extends JPanel {

	private JSpinner inputFilas;
	private JSpinner inputColumnas;
	private JButton botonComenzar;
	private JButton botonUsuario;

	public MenuPanel() {

		inicializar();
		setSize(300, 300);
	}

	private void inicializar() {
		botonComenzar = new JButton("Comenzar partida");
		botonComenzar = new JButton("Comenzar partida");
		JLabel labelFilas = new JLabel("Filas");
		inputFilas = new JSpinner();
		inputFilas.setValue(20);
		JLabel labelColumnas = new JLabel("Columnas");
		inputColumnas = new JSpinner();
		inputColumnas.setValue(20);
		add(labelFilas, BorderLayout.LINE_END);
		add(inputFilas, BorderLayout.LINE_END);
		add(labelColumnas, BorderLayout.LINE_START);
		add(inputColumnas, BorderLayout.LINE_START);
		add(botonComenzar, BorderLayout.PAGE_END);
	}

	public JButton getBotonComenzar() {
		return botonComenzar;
	}

	public JButton getBotonUsuario() {
		return botonUsuario;
	}

	public int getFilas() {
		return (int) inputFilas.getValue();
	}

	public int getColumnas() {
		return (int) inputColumnas.getValue();
	}

}
