package algocity.core.procesadores;

import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.construibles.Arreglable;
import algocity.core.construibles.EstacionDeBombero;
import algocity.core.procesadores.ProcesadorDeDaniados;

public class ProcesadorDeBomberos {
	private Mapa mapa;

	public ProcesadorDeBomberos(Mapa mapa) {
		this.mapa = mapa;
		procesar();
	}
	
	private void procesar(){
		Iterator<Hectarea> iterBombero;
		Iterator<Hectarea> iterDaniado;
		ProcesadorDeDaniados procesadorDeDaniados = new ProcesadorDeDaniados();
		RutaPavimentada ruta = mapa.getRutaPavimentada();
		for(iterBombero = mapa.recorridoBomberos(); iterBombero.hasNext(); ) {
			Hectarea hectareaDeBombero = iterBombero.next();
			EstacionDeBombero bombero = (EstacionDeBombero)hectareaDeBombero.getConstruible();
			for(iterDaniado = mapa.recorridoDaniados(); iterDaniado.hasNext();) {
				Hectarea hectareaDaniada = iterDaniado.next();
				Arreglable daniado = (Arreglable) hectareaDaniada.getConstruible();
				if (ruta.existeConexionBFS(hectareaDeBombero.getFila(), 
					hectareaDeBombero.getColumna(),
					hectareaDaniada.getFila(),
					hectareaDaniada.getColumna())){
						bombero.reparar(daniado);
						procesadorDeDaniados.procesarDanios(mapa, hectareaDaniada);
				}
			}
		}
	}
	
}
