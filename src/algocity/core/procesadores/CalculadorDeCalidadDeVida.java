package algocity.core.procesadores;

import algocity.core.Configuracion;
import algocity.core.capas.Hectarea;

public class CalculadorDeCalidadDeVida implements Procesador {

	int indice;
	int cantidadResidenciales;
	int cantidadComerciales;
	int cantidadIndustriales;

	public CalculadorDeCalidadDeVida() {
		indice = Configuracion.IndiceVidaInicial;
		cantidadResidenciales = cantidadComerciales = cantidadIndustriales = 0;
	}

	public int getIndice() {
		return indice;
	}


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
}
