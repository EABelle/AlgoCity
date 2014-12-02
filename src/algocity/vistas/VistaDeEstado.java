package algocity.vistas;

import java.awt.BorderLayout;
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
	private JLabel tiempoRestante;
	private ControladorPartida controladorPartida;
	private JLabel turno;
	private JButton pasarTurno;
	private JPanel miniMapa;
	private JButton guardarPartida;
	private JButton playPauseMusic;


	public VistaDeEstado(ControladorPartida controladorPartida) {
		this.controladorPartida = controladorPartida;
		inicializarPanelEstado();
//		inicializarMiniMapa();
	}

	private void inicializarPanelEstado() {
		setLayout(new GridLayout(2, 4));

		estado = new JLabel();
		mensaje = new JLabel();
		mensaje.setForeground(Color.darkGray);
		plata = new JLabel();
		turno = new JLabel();
		tiempoRestante = new JLabel();

		guardarPartida = new JButton("Guardar Partida");
		guardarPartida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controladorPartida.guardarPartida();
			}
		});

		pasarTurno = new JButton("Pasar Turno");
		pasarTurno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controladorPartida.pasarTurno();
			}
		});
		
		playPauseMusic = new JButton("Musica: Play/Pausa");
		playPauseMusic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorPartida.playPauseMusic();
				
			}
		});
		
		add(estado);
		add(mensaje);
		add(plata);
		add(guardarPartida);
		add(turno);
		//add(tiempoRestante);
		add(pasarTurno);
		add(playPauseMusic);
		

	}

	private void inicializarMiniMapa() {
		miniMapa = new JPanel();
		miniMapa.setBackground(Color.cyan);
		miniMapa.setSize(100, 100);
		add(miniMapa, BorderLayout.EAST);
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
	
	
	public void setTiempoRestante(int tiempoRestante) {
		this.tiempoRestante.setText(String.format("Tiempo Restante: %d", tiempoRestante));
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		Partida partida = (Partida) o;
		setPlata(partida.getPlata());
		setTurno(partida.getTurno());
		//setTiempoRestante(this.controladorPartida.getTiempoRestante());

	}


}
