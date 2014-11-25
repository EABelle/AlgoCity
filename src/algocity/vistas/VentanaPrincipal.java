package algocity.vistas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;

public class VentanaPrincipal extends JFrame {

	JSpinner inputFilas;
	JSpinner inputColumnas;
	JButton botonComenzar;

	public VentanaPrincipal() {

		this.setTitle("AlgoCity v0.1");
		botonComenzar = new JButton("Comenzar partida");
		inputFilas = new JSpinner();
		inputFilas.setValue(10);
		inputColumnas = new JSpinner();
		inputColumnas.setValue(10);
        add(inputColumnas, BorderLayout.LINE_START);
		add(inputFilas, BorderLayout.LINE_END);
		add(botonComenzar, BorderLayout.PAGE_END);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
