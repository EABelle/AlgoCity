package algocity.vistas;

import javax.swing.JLabel;
import javax.swing.JPanel;

import algocity.core.construibles.CentralElectrica;
import algocity.core.construibles.Comercial;
import algocity.core.construibles.Construible;
import algocity.core.construibles.EstacionDeBombero;
import algocity.core.construibles.Industrial;
import algocity.core.construibles.PozoDeAgua;
import algocity.core.construibles.Residencial;

public class VistaDeInfo extends JPanel {

	JLabel info;

	public VistaDeInfo() {
		info = new JLabel();
		add(info);
		vaciarInfo();
	}

	public void setInfo(String mensaje) {
		info.setText(mensaje);
	}

	public void vaciarInfo() {
		info.setText(" ");
	}

	private void mensajeComun(Construible cons, String mensaje) {
		mensaje += " | Porcentaje de vida " + cons.getPorcetajeDeVida();
		setInfo(mensaje);
	}

	public void mostrarInfo(Residencial residencial) {
		String mensaje = "Residencial | Habitantes: " + residencial.habitantes();
		mensajeComun(residencial, mensaje);
	}

	public void mostrarInfo(CentralElectrica central) {
		String mensaje = "Central | Potencia displonible: " + central.getPotenciaDisponible();
		mensajeComun(central, mensaje);
	}

	public void mostrarInfo(Industrial industrial) {
		String mensaje = "Industrial | Puestos ocupados: " +
				industrial.puestosDeTrabajoOcupados() + "/" +
				industrial.puestosDeTrabajoDisponibles();
		mensajeComun(industrial, mensaje);
	}

	public void mostrarInfo(Comercial comercial) {
		mensajeComun(comercial, "Comercial");
	}

	public void mostrarInfo(EstacionDeBombero estacionDeBombero) {
		mensajeComun(estacionDeBombero, "Estacion de bomberos");
	}

	public void mostrarInfo(PozoDeAgua pozoDeAgua) {
		mensajeComun(pozoDeAgua, "Pozo de Agua");
	}

}
