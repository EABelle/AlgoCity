package algocity.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import algocity.core.capas.Hectarea;
import algocity.core.capas.HectareaAgua;
import algocity.core.capas.HectareaLlana;
import algocity.core.capas.tendido.RedDeAgua;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.construibles.Construible;

public class Mapa {

	private Hectarea[][] hectareas;
	private int x;
	private int y;
	private int filas;
	private int columnas;
	private boolean cargadoCompleto;
	private ArrayList<Hectarea> residenciales;
	private ArrayList<Hectarea> comerciales;
	private ArrayList<Hectarea> industriales;
	private ArrayList<Hectarea> daniadas;
	/*----------------EN DANIADAS-------------
	 *  HAY QUE VER COMO AGREGARLO CUANDO SE DANIA ALGO
	 * Y COMO SACARLO CUANDO SE TERMINA DE REPARAR
	 * */
	private ArrayList<Hectarea> centrales;
	private ArrayList<Hectarea> bomberos;
	private RedDeAgua redDeAgua;
	private RedElectrica redElectrica;
	private RutaPavimentada rutaPavimentada;




	public Mapa(int filas, int columnas){
		hectareas = new Hectarea[filas][columnas];
		x = 0;
		y = 0;
		this.filas = filas;
		this.columnas = columnas;
		cargadoCompleto = false;
		residenciales = new ArrayList<Hectarea>();
		comerciales = new ArrayList<Hectarea>();
		industriales = new ArrayList<Hectarea>();
		daniadas = new ArrayList<Hectarea>();
		centrales = new ArrayList<Hectarea>();
		bomberos = new ArrayList<Hectarea>();
		redDeAgua = new RedDeAgua();
		redElectrica = new RedElectrica();
		rutaPavimentada = new RutaPavimentada();
	}

	public boolean cargarHectareaNueva(Hectarea hectarea) {

		if (x < filas) {
			if (y < columnas){
				hectareas[x][y] = hectarea;
				hectarea.setFila(x);
				hectarea.setColumna(y);
				hectarea.setTendidos(redDeAgua, redElectrica);
				y ++;
			} else {
				x ++;
				y = 0;
				cargarHectareaNueva (hectarea);
			}
		}
		else cargadoCompleto = true;
		return cargadoCompleto;
	}
	public boolean cargado() {
		return cargadoCompleto;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}


	/**
	 *  Llena el mapa de hectareas
	 *  TODO: Agregar algun criterio de llenado
	 */
	public void llenar() {
		int numero;
		Random rn = new Random();
		while(!this.cargado()) {
			Hectarea hectarea;
			numero = rn.nextInt(5);
			if (numero % 5 == 0) {
				hectarea = new HectareaAgua();
			} else {
				hectarea = new HectareaLlana();
			}
			this.cargarHectareaNueva(hectarea);
		}
	}

	public Iterator<Hectarea> recorridoSecuencial() {
		ArrayList<Hectarea> recorrido = new ArrayList<Hectarea>();
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				recorrido.add(hectareas[i][j]);
			}
		}
		return recorrido.iterator();
	}
	public Iterator<Hectarea> recorrerEnUnRadio(int radio, int x, int y) {
		ArrayList<Hectarea> recorrido = new ArrayList<Hectarea>();
		int fila, columna;
		for(int i = 0; i <= 2 * radio; i++) {
			for (int j = 0; j <= 2 * radio; j++) {
				fila = x - radio + i;
				columna = y - radio + j;
				if((fila >= 0) && (fila < getFilas()) &&
				   (columna >= 0) && (columna < getColumnas()))
					recorrido.add(hectareas[fila][columna]);
			}
		}
		return recorrido.iterator();
	}

	public Iterator<Hectarea> RecorrerSoloEnUnRadio(int radio,
		int x, int y) {
		int i;
		ArrayList<Hectarea> recorrido = new ArrayList<Hectarea>();
		if ((y - radio) >= 0) {
			for (i = 0; i <= 2 * radio; i ++) {
				if (((x - radio + i) >= 0) &&
					((x - radio + i) < filas))
					recorrido.add(hectareas[x - radio + i][y - radio]);
			}
		}
		if ((y + radio) < columnas) {
			for (i = 0; i <= 2 * radio; i ++) {
				if (((x - radio + i) >= 0) &&
					((x - radio + i) < filas))
					recorrido.add(hectareas[x - radio + i][y + radio]);
			}
		}
		if ((x - radio) >= 0) {
			for (i = 1; i < 2 * radio; i ++) {
				if (((y - radio + i) >= 0) &&
					((y - radio + i) < columnas))
					recorrido.add(hectareas[x - radio][y - radio + i]);
			}
		}
		if ((x + radio) < filas) {
			for (i = 1; i < 2 * radio; i ++) {
				if (((y - radio + i) >= 0) &&
					((y - radio + i) < columnas))
					recorrido.add(hectareas[x - radio][y - radio + i]);
			}
		}
		return recorrido.iterator();

	}

	public Iterator<Hectarea> recorridoResidenciales() {
		return residenciales.iterator();
	}

	public Iterator<Hectarea> recorridoComerciales() {
		return comerciales.iterator();
	}

	public Iterator<Hectarea> recorridoIndustriales() {
		return industriales.iterator();
	}

	public Iterator<Hectarea> recorridoCentrales() {
		return centrales.iterator();
	}

	public Iterator<Hectarea> recorridoDaniados() {
		return daniadas.iterator();
	}

	public Iterator<Hectarea> recorridoBomberos() {
		return bomberos.iterator();
	}

	public boolean agregarConstruible(Construible construible, int x, int y) {
		return hectareas[x][y].agregarConstruible(construible);
	}

	public boolean borrarConstruible(int x, int y) {
		return hectareas[x][y].borrarConstruible();
	}

	public Hectarea getHectarea(int fila, int columna) {
		return hectareas[fila][columna];
	}

	public RedElectrica getRedElectrica() {
		return redElectrica;
	}

	public RedDeAgua getRedDeAgua() {
		return redDeAgua;
	}

	public RutaPavimentada getRutaPavimentada(){
		return rutaPavimentada;
	}

	public ArrayList<Hectarea> getHectareasResidenciales() {
		return residenciales;
	}

	public ArrayList<Hectarea> getHectareasComerciales() {
		return comerciales;
	}

	public ArrayList<Hectarea> getHectareasIndustriales() {
		return industriales;
	}

	public ArrayList<Hectarea> getHectareasDaniadas() {
		return daniadas;
	}

	public ArrayList<Hectarea> getHectareasDeCentralElectrica() {
		return centrales;
	}

	public ArrayList<Hectarea> getHectareasDeBomberos() {
		return bomberos;
	}
}
