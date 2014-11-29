package algocity.core.procesadores;

import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.construibles.Edificio;
import algocity.core.construibles.Industrial;
import algocity.core.construibles.Residencial;

public abstract class CalculadorDeCalidadDeVida {

	private static final int MAXIMA_SALIDA = 20;
	private static final int INDICE_RESIDENCIA_COMERCIAL = 1;
	private static final int INDICE_RESIDENCIA_INDUSTRIAL = 1;

	public static void procesar (Mapa mapa){
		int indice = 0;
		Residencial residencial;
		Industrial industrial;
		Hectarea hectareaResidencial;
		Hectarea hectareaComercial;
		Hectarea hectareaIndustrial;	
		Iterator<Hectarea> residenciales = mapa.recorridoResidenciales();
		RutaPavimentada ruta = mapa.getRutaPavimentada();
		
		while (residenciales.hasNext()){
			hectareaResidencial = residenciales.next();
			residencial = (Residencial)hectareaResidencial.getConstruible();
			if(funcionaElEdificio(hectareaResidencial)){
				Iterator<Hectarea> comerciales = mapa.recorridoComerciales();
				Iterator<Hectarea> industriales = mapa.recorridoIndustriales();
				
				while (comerciales.hasNext()){
					hectareaComercial = comerciales.next();
					if (hayConexion(ruta, hectareaResidencial, hectareaComercial)){
						indice += INDICE_RESIDENCIA_COMERCIAL;
						break;
						
					}
				
				}
				
				while (industriales.hasNext()){
					hectareaIndustrial = industriales.next();
					if (hayConexion(ruta, hectareaResidencial, hectareaIndustrial)){
						industrial = (Industrial)hectareaIndustrial.getConstruible();
						if (industrial.puestosDeTrabajoDisponibles() >= residencial.trabajadores()){
							industrial.agregarTrabajadores(residencial.trabajadores());
							indice += INDICE_RESIDENCIA_INDUSTRIAL;
							break;
						}
					}
				}
				int habitantesNuevos = (int)((1 - residencial.danio()/100
						- indice/2) * (residencial.disponibilidad()/5));
				residencial.modificarCantidadDeHabitantes(habitantesNuevos);
			}else{
				residencial.quitarHabitantes(MAXIMA_SALIDA);
			}
		}
	}

	private static boolean funcionaElEdificio(Hectarea hectarea){
		Edificio edificio = (Edificio)hectarea.getConstruible();
		return edificio.cumpleRequerimientos(hectarea.redDeAguaConectada(),
				hectarea.rutaPavimentadaConectada(),
				hectarea.redElectricaConectada());
	}
	
	private static boolean hayConexion(RutaPavimentada ruta, Hectarea hectarea1,
						Hectarea hectarea2) {
		return ruta.existeConexionBFS(hectarea1.getColumna(), hectarea1.getFila()
				,hectarea2.getColumna(), hectarea2.getFila());
		
	}
	
/*	public CalculadorDeCalidadDeVida(Mapa mapa) {
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
