package algocity.core.procesadores;

import algocity.core.Configuracion;
import algocity.core.Mapa;
import algocity.core.capas.Hectarea;

public class CalculadorDeCalidadDeVida {

	int indice;
	int cantidadResidenciales;
	int cantidadComerciales;
	int cantidadIndustriales;
	private Mapa mapa;

	public CalculadorDeCalidadDeVida(Mapa mapa) {
		indice = Configuracion.IndiceVidaInicial;
		cantidadResidenciales = cantidadComerciales = cantidadIndustriales = 0;
		this.mapa = mapa;
	}

	public int getIndice() {
		return indice;
	}

/*
	@Override
	public void procesarHectarea(Hectarea hectarea) {
		String tipo = hectarea.contieneUn();
		if (tipo == null) {
			return;
		}
		if (tipo.equals("Residencial")) {
			cantidadResidenciales++;
		} else if (tipo.equals("Comercial")) {
			cantidadComerciales++;
		} else if (tipo.equals("Industrial")) {
			cantidadIndustriales++;
		}
	}

	public void finalizarProceso() {
		indice -= (cantidadResidenciales - (cantidadComerciales + cantidadIndustriales) / 2);
	}
	*/
}
