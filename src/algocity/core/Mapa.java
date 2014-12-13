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
	private ArrayList<Hectarea> recorridoSecuencial;




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
				hectarea.setX(x);
				hectarea.setY(y);
				agregarHectarea(hectarea);
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

	private void agregarHectarea(Hectarea hectarea) {
		hectareas[hectarea.getX()][hectarea.getY()] = hectarea;
		hectarea.setTendidos(redDeAgua, redElectrica);
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
		cargadoCompleto = true;
	}

	/**
	 * Llena el mapa de hectareas pasadas en la lista, las que no
	 * esten, se consideran hectareas llanas vacias.
	 */
	public void llenar(ArrayList<Hectarea> hectareas) {
		for (Iterator<Hectarea> iterator = hectareas.iterator(); iterator.hasNext();) {
			Hectarea hectarea = iterator.next();
			agregarHectarea(hectarea);
			Construible cons = hectarea.getConstruible();
			if (cons != null) {
				cons.procesarAgregado(this, hectarea.getX(), hectarea.getY());
			}
		}
		for (int x = 0; x < filas; x++) {
			for (int y = 0; y < columnas; y++) {
				if (this.hectareas[x][y] == null) {
					Hectarea hectarea = new HectareaLlana();
					hectarea.setX(x);
					hectarea.setY(y);
					agregarHectarea(hectarea);
				}
			}
		}
		cargadoCompleto = true;
	}

	public Iterator<Hectarea> recorridoSecuencial() {
		if (this.recorridoSecuencial == null) {
			ArrayList<Hectarea> recorrido = new ArrayList<Hectarea>();
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					recorrido.add(hectareas[i][j]);
				}
			}
			this.recorridoSecuencial = recorrido;
		}
		return this.recorridoSecuencial.iterator();
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

	public Iterator<Hectarea> RecorrerSoloEnUnRadio(int radio, int x, int y) {
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
	public void setRedElectrica(RedElectrica redElectrica) {
		this.redElectrica = redElectrica;
	}

	public RedDeAgua getRedDeAgua() {
		return redDeAgua;
	}
	public void setRedDeAgua(RedDeAgua redDeAgua) {
		this.redDeAgua = redDeAgua;
	}

	public RutaPavimentada getRutaPavimentada(){
		return rutaPavimentada;
	}
	public void setRutaPavimentada(RutaPavimentada rutaPavimentada) {
		this.rutaPavimentada = rutaPavimentada;
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

	public Iterator<Hectarea> recorridoGodzilla(int turno) {
		Iterator<Hectarea> recorrido = null;
		switch (turno % 6){
		case 0:
			recorrido = recorridoHorizontal();
			break;
		case 1:
			recorrido = recorridoVertical();
			break;
		case 2:
			recorrido = recorridoDiagonal1();
			break;
		case 3:
			recorrido = recorridoDiagonal2();
			break;
		case 4:
			recorrido = recorridoZigZagHorizontal();
			break;
		case 5:
			recorrido = recorridoZigZagVertical();
			break;
		}
		return recorrido;
	}

	private Iterator<Hectarea> recorridoHorizontal() {
		ArrayList<Hectarea> recorrido = new ArrayList<Hectarea>();
		Random rm = new Random();
		int fila = rm.nextInt(filas);
		for(int i = 0; i < columnas; i++) {
			recorrido.add(hectareas[fila][i]);
		}
		return recorrido.iterator();
	}

	private Iterator<Hectarea> recorridoVertical() {
		ArrayList<Hectarea> recorrido = new ArrayList<Hectarea>();
		Random rm = new Random();
		int columna = rm.nextInt(columnas);
		for(int i = 0; i < filas; i++) {
			recorrido.add(hectareas[i][columna]);
		}
		return recorrido.iterator();
	}

	private Iterator<Hectarea> recorridoDiagonal1() {
		ArrayList<Hectarea> recorrido = new ArrayList<Hectarea>();
		Random rm = new Random();
		int fila = rm.nextInt(filas);
		int columna = 0;
		while((fila < filas) && (columna < columnas)){
			recorrido.add(hectareas[fila][columna]);
			fila ++;
			columna ++;
		}
		return recorrido.iterator();
	}

	private Iterator<Hectarea> recorridoDiagonal2() {
		ArrayList<Hectarea> recorrido = new ArrayList<Hectarea>();
		Random rm = new Random();
		int fila = rm.nextInt(filas);
		int columna = 0;
		while((fila > 0) && (columna < columnas)){
			recorrido.add(hectareas[fila][columna]);
			fila --;
			columna ++;
		}
		return recorrido.iterator();
	}

	private Iterator<Hectarea> recorridoZigZagVertical() {
		ArrayList<Hectarea> recorrido = new ArrayList<Hectarea>();
		Random rm = new Random();
		int columna = rm.nextInt(columnas - 2) + 1;
		int fila = 0;
		while(fila < filas) {
			recorrido.add(hectareas[fila][columna]);
			fila ++;
			if (columna % 2 == 0){
				columna --;
			}else{
				columna ++;
			}
		}
		return recorrido.iterator();
	}

	private Iterator<Hectarea> recorridoZigZagHorizontal() {
		ArrayList<Hectarea> recorrido = new ArrayList<Hectarea>();
		Random rm = new Random();
		int fila = rm.nextInt(filas - 2) + 1;
		int columna = 0;
		while(columna < columnas) {
			recorrido.add(hectareas[fila][columna]);
			columna ++;
			if (fila % 2 == 0){
				fila --;
			}else{
				fila ++;
			}
		}
		return recorrido.iterator();
	}
}