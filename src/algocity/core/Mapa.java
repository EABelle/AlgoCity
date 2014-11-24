package algocity.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import algocity.core.capas.Hectarea;
import algocity.core.capas.HectareaAgua;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.Arreglable;
import algocity.core.construibles.CentralElectrica;
import algocity.core.construibles.Construible;
import algocity.core.procesadores.CalculadorDeCalidadDeVida;
import algocity.core.procesadores.ManejadorDeHabitantes;
import algocity.core.procesadores.Procesador;

public class Mapa {

	private Hectarea[][] hectareas;
	private int x;
	private int y;
	private int filas;
	private int columnas;
	private boolean cargadoCompleto;

	public Mapa(int filas, int columnas){
		this.hectareas = new Hectarea[filas][columnas];
		this.x = 0;
		this.y = 0;
		this.filas = filas;
		this.columnas = columnas;
		this.cargadoCompleto = false;
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
/*
	public boolean agregarConstruible (Construible construible, int x, int y) {
		if ( (x >= 0) && (x < filas) && (y >= 0) && (y <= columnas))
			return hectareas[x][y].agregarConstruible(construible);
		return false;
	}
*/
	public boolean cargado() {
		return cargadoCompleto;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}
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
	public void recorrerseSecuencialmente(ArrayList<Procesador> procesadores) {
		for (int i = 0; i < hectareas.length; i++) {
			for (int j = 0; j < hectareas.length; j++) {
				for (Iterator iterator = procesadores.iterator(); iterator
						.hasNext();) {
					((Procesador) iterator.next()).procesarHectarea(this.getHectarea(i, j));
				}
			}
		}
	}

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
/*
	public String EnXYhayUn(int x, int y) {
		return hectareas[x][y].contieneUn();
	}
*/
	public Hectarea getHectarea(int fila, int columna) {
		return hectareas[fila][columna];
	}

}
