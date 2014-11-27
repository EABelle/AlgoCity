package algocity.vistas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class MenuPanel extends JPanel {

	JSpinner inputFilas;
	JSpinner inputColumnas;
	JButton botonComenzar;

	public MenuPanel() {

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
		setSize(300, 300);
	}

	public JButton getBotonComenzar() {
		return botonComenzar;
	}

	public int getFilas() {
		return (int) inputFilas.getValue();
	}

	public int getColumnas() {
		return (int) inputColumnas.getValue();
	}

}
