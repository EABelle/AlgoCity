package algocity.vistas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algocity.controladores.ControladorPartida;
import algocity.core.Partida;

public class VistaDeEstado extends JPanel implements Observer {

	private JLabel estado;
	private JLabel mensaje;
	private JLabel plata;
	private ControladorPartida controladorPartida;
	private JLabel turno;
	private JButton pasarTurno;


	public VistaDeEstado(ControladorPartida controladorPartida) {
		this.controladorPartida = controladorPartida;
		setLayout(new GridLayout(2, 3));
		inicializarse();
	}

	private void inicializarse() {
		estado = new JLabel();
		mensaje = new JLabel();
		mensaje.setForeground(Color.darkGray);
		plata = new JLabel();
		turno = new JLabel();
		JLabel menu = new JLabel("Menu");
		pasarTurno = new JButton("Pasar Turno");
		pasarTurno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorPartida.pasarTurno();
			}
		});
		add(estado);
		add(mensaje);
		add(plata);
		add(menu);
		add(turno);
		add(pasarTurno);
	}

	public void setEstado(String estado) {
		this.estado.setText(estado);
	}

	public void setMensaje(String text) {
		this.mensaje.setText(text);
	}

	public void setPlata(int plata) {
		this.plata.setText(String.format("Plata: %d", plata));
	}

	public void setTurno(int turno) {
		this.turno.setText(String.format("Turno: %d", turno));
	}

	@Override
	public void update(Observable o, Object arg) {
		Partida partida = (Partida) o;
		setPlata(partida.getPlata());
		setTurno(partida.getTurno());
	}

}
