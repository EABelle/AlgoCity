package algocity.vistas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class MenuPanel extends JPanel {

	JSpinner inputFilas;
	JSpinner inputColumnas;
	JButton botonComenzar;

	public MenuPanel() {

		botonComenzar = new JButton("Comenzar partida");
		inputFilas = new JSpinner();
		inputFilas.setValue(10);
		inputColumnas = new JSpinner();
		inputColumnas.setValue(10);
        add(inputColumnas, BorderLayout.LINE_START);
		add(inputFilas, BorderLayout.LINE_END);
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
