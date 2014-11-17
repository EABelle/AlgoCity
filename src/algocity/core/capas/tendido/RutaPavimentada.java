package algocity.core.capas.tendido;

import java.util.ArrayList;
import java.util.Iterator;
import algocity.core.Partida;
import algocity.core.Partida.NodoEdificioDaniado;

public class RutaPavimentada extends Tendido {

	@Override
	public boolean agregarNodo(int coordenadaX, int coordenadaY){
		
		if ( this.nodoExiste(coordenadaX,coordenadaY) )
			return false;
		
		NodoTendido nodoNuevo = new NodoTendido(coordenadaX, coordenadaY);
		
		ArrayList<NodoTendido> vecinosPosibles = new ArrayList<NodoTendido>(); 
		vecinosPosibles.add(this.getNodo(coordenadaX+1, coordenadaY));
		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY+1));
		vecinosPosibles.add(this.getNodo(coordenadaX-1, coordenadaY));
		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY-1));
		
		Iterator<NodoTendido> iter = vecinosPosibles.iterator();
		
		while (iter.hasNext()){
			NodoTendido nodoActual = iter.next();
			if (nodoActual != null){
				hacerVecinos (nodoNuevo, nodoActual);
			}
		}
		
		this.nodos.add(nodoNuevo);
		return true;
	}

	public void mandarBomberos(Partida partida, 
			ArrayList<NodoEdificioDaniado> edificiosDaniados) {
		
		Iterator<Coordenada> coordenadasEstacionesDeBomberos = edificiosProveedores.iterator();
		Iterator<NodoEdificioDaniado> iterDaniados = edificiosDaniados.iterator();
		
		Coordenada coordBombero;
		NodoEdificioDaniado edificioDaniado;
		
		while (coordenadasEstacionesDeBomberos.hasNext()){
			coordBombero = coordenadasEstacionesDeBomberos.next();
			
			while (iterDaniados.hasNext()) {
				edificioDaniado = iterDaniados.next();
				if (existeConexionBFS(coordBombero.getX(), coordBombero.getY(),
						edificioDaniado.getX(), edificioDaniado.getY())) {
					partida.mandarBomberosDesdeHasta(coordBombero.getX(),
							coordBombero.getY(), edificioDaniado.getConstruible());
					
				}
			}
		}
		
	}

}