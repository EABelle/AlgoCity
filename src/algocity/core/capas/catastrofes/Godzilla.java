package algocity.core.capas.catastrofes;

import java.util.Iterator;
import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.construibles.CentralElectrica;
import algocity.core.construibles.Comercial;
import algocity.core.construibles.Industrial;
import algocity.core.construibles.Residencial;
import algocity.core.procesadores.ProcesadorDeDaniados;

public class Godzilla extends Catastrofe {
	Iterator<Hectarea> recorrido;
	
	public Godzilla(Iterator<Hectarea> recorrido){
		this.recorrido = recorrido;
	}

	@Override
	public void procesar(Mapa mapa) {
		while(recorrido.hasNext()) {
			Hectarea hectarea = recorrido.next();
			hectarea.teImpacta(this);
			ProcesadorDeDaniados procesadorDeDaniados = new ProcesadorDeDaniados();
			procesadorDeDaniados.procesarDanios(mapa, hectarea);
			RedElectrica redElectrica = mapa.getRedElectrica();
			redElectrica.eliminarNodo(hectarea.getFila(), hectarea.getColumna());
		}
	}
	
	@Override
	public boolean continua(){
		return recorrido.hasNext();
	}

	public void impactame(Comercial comercial) {
		comercial.daniar(75);	
	}

	public void impactame(CentralElectrica centralElectrica) {
		centralElectrica.daniar(35);
	}

	public void impactame(Industrial industrial) {
		industrial.daniar(40);
	}

	public void impactame(Residencial residencial) {
		residencial.daniar(100);
	}	
}
