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
import algocity.core.procesadores.Procesador;

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
	private ArrayList<Hectarea> centrales;
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
		redDeAgua = new RedDeAgua();
		redElectrica = new RedElectrica();
		rutaPavimentada = new RutaPavimentada();
	}

	public boolean cargarHectareaNueva(Hectarea hectarea) {

		if (x < filas) {
			if (y < columnas){
				hectareas[x][y] = hectarea;
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
			numero = rn.nextInt(3);
			if (numero % 3 == 0) {
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



	public void agregarConstruible(Construible construible, int x, int y) {
		hectareas[x][y].agregarConstruible(construible);
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

	private void aplicarProcesadoresAHectarea(int fila, int columna,
			ArrayList<Procesador> procesadores) {
		for (Iterator<Procesador> iterator = procesadores.iterator(); iterator
				.hasNext();) {
			iterator.next().procesarHectarea(this.getHectarea(fila, columna));
		}
	}

	/*
	public boolean agregarConstruible (Construible construible, int x, int y) {
		if ( (x >= 0) && (x < filas) && (y >= 0) && (y <= columnas))
			return hectareas[x][y].agregarConstruible(construible);
		return false;
	}
*/

/*
	public void conectarHectareaARedElectrica(int i, int j) {
		hectareas[i][j].conectarRedElectrica();
	}

	public boolean cercanoACentralElecrica(int x, int y) {
		return hectareas[x][y].redElectricaConectada();
	}

	public boolean rutaPavimentadaConectada(int x, int y) {
		return hectareas[x][y].rutaPavimentadaConectada();
	}
*/

/*	public void procesarEnUnRadio(int radio, int x, int y,
			ArrayList<Procesador> procesadores) {
		int fila, columna;
		for(int i = 0; i <= 2 * radio; i++) {
			for (int j = 0; j <= 2 * radio; j++) {
				fila = x - radio + i;
				columna = y - radio + j;
				if((fila >= 0) && (fila < getFilas()) &&
				   (columna >= 0) && (columna < getColumnas()))
					aplicarProcesadoresAHectarea(fila, columna, procesadores);
			}
		}
	}*/

/*	public void procesarTurno(Partida partida) {
		int i, j;

		// Esto no deberia estar aca, pero es un ejemplo de uso
		CalculadorDeCalidadDeVida calc = new CalculadorDeCalidadDeVida();
		ManejadorDeHabitantes man = new ManejadorDeHabitantes();

		for (i = 0; i < filas; i++){
			for (j = 0; j < columnas; j++){
				Hectarea hectarea = hectareas[i][j];
				hectarea.procesarTurno(partida, i, j);
				man.procesarHectarea(hectarea);
				calc.procesarHectarea(hectarea);
			}
		}

		man.setHabitantes(200);
		calc.finalizarProceso();
		man.finalizarProceso();

	}

	public void mandarBomberosDesdeHasta(int x, int y, Arreglable arreglable) {
		hectareas[x][y].mandarBomberoHasta(arreglable);
	}

	public CentralElectrica getCentral(int x, int y) {
		return (CentralElectrica)hectareas[x][y].getConstruible();
	}

	public void impactarEn(int x, int y, float danio) {
		hectareas[x][y].impactar(danio);
	}
*/
/*
	public String EnXYhayUn(int x, int y) {
		return hectareas[x][y].contieneUn();
	}
*/

}
