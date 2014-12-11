package algocity.core.capas.catastrofes;

import java.util.Iterator;
import java.util.Random;

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
	static boolean presente;

	public Godzilla(Iterator<Hectarea> recorrido){
		this.recorrido = recorrido;
		presente = true;
	}

	@Override
	public void procesar(Mapa mapa) {
		if(recorrido.hasNext()) {
			Hectarea hectarea = recorrido.next();
			hectarea.teImpacta(this);
			ProcesadorDeDaniados procesadorDeDaniados = new ProcesadorDeDaniados();
			procesadorDeDaniados.procesarDanios(mapa, hectarea);
			RedElectrica redElectrica = mapa.getRedElectrica();
			redElectrica.eliminarNodo(hectarea);
		}else {
			presente = false;
		}
	}

	@Override
	public boolean continua(){
		return recorrido.hasNext();
	}

	public void impactarEn(Comercial comercial) {
		comercial.daniar(75);
	}

	public void impactarEn(CentralElectrica centralElectrica) {
		centralElectrica.daniar(35);
	}

	public void impactarEn(Industrial industrial) {
		industrial.daniar(40);
	}

	public void impactarEn(Residencial residencial) {
		residencial.daniar(100);
	}

	public static void inicializar(){
		presente = false;
	}

	public static boolean aparecer() {
		Random rn = new Random();
		if (!presente&(rn.nextInt(49) % 12 == 0)) {
			presente = true;
		}
		return presente;
	}
}
