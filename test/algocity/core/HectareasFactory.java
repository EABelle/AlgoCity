package algocity.core;

import algocity.core.capas.Hectarea;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.Comercial;
import algocity.core.construibles.Construible;
import algocity.core.construibles.Industrial;
import algocity.core.construibles.Residencial;

public class HectareasFactory {
	
	public HectareaLlana getHectareaLlana() {
		HectareaLlana hectarea = new HectareaLlana();
		return hectarea;
	}
	
	public HectareaLlana getHectareaLlana(Construible casa) {
		HectareaLlana hectarea = new HectareaLlana();
		//prepararConstruible(casa);
		hectarea.agregarConstruible(casa);
		return hectarea;
	}
	/*
	private void prepararConstruible(Construible casa) {
		casa.conectarARedDeAgua();
		casa.conectarARedElectrica();
		casa.conectarARutaPavimentada();
	}*/
	
	public Hectarea getHectareaConResidencial() {
		Construible casa = new Residencial();
		return getHectareaLlana(casa);
	}
	public Hectarea getHectareaConIndustrial() {
		Construible casa = new Industrial();
		return getHectareaLlana(casa);
	}
	public Hectarea getHectareaConComercial() {
		Construible casa = new Comercial();
		return getHectareaLlana(casa);
	}
	
}
