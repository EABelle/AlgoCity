package algocity.vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import algocity.core.Jugador;

public class PanelGuardarPartida extends JPanel {

	private Jugador jugador;
	private JList<String> partidasList;
	private JTextField textField;
	private JButton botonRuta;


	public PanelGuardarPartida(Jugador jugador) {
		this.jugador = jugador;
		setLayout(new GridLayout(3, 1, 20, 20));
	    textField = new JTextField(30);
	    add(textField);
	    inicializarBoton();
	    inicializarPartidas();
	}

	private void inicializarBoton() {
		botonRuta = new JButton("Crear nueva partida");
		botonRuta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Seleccione ruta");
			    chooser.setAcceptAllFileFilterUsed(false);
			    if (chooser.showOpenDialog(botonRuta) == JFileChooser.APPROVE_OPTION) {
			    	textField.setText(chooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		add(botonRuta);
	}

	private void inicializarPartidas() {
		ArrayList<String> partidas = jugador.getPartidas();
		String[] partidasArray = partidas.toArray(new String[partidas.size()]);
		if (partidas != null) {
			partidasList = new JList<String>(partidasArray);

			partidasList.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	textField.setText(partidasList.getSelectedValue().toString());
	                }
	            }

	        });
	        add(new JScrollPane(partidasList));
		}
	}

	public String mostrarPanel() {
		int result = JOptionPane.showConfirmDialog(null, this,
	               "Seleccione donde guardar la partida", JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	    	return textField.getText();
	    }
		return null;
	}

}
