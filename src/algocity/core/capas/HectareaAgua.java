package algocity.core.capas;

import algocity.core.construibles.Construible;
import algocity.core.construibles.ConstruibleEnAgua;
import algocity.core.construibles.PozoDeAgua;
import algocity.vistas.VistaDeHectarea;

public class HectareaAgua extends Hectarea {

	PozoDeAgua pozoDeAgua;

	@Override
	public boolean agregarConstruible(Construible construible) {
		try{
			return agregarConstruibleEnAgua ((ConstruibleEnAgua)construible);
		} catch (Exception e){
			//System.out.println("NO ES CONSTRUIBLE EN AGUA");
			return false;
		}
	}

	private boolean agregarConstruibleEnAgua(ConstruibleEnAgua construible) {
		if (this.construible == null){
			this.construible = construible;
			this.hayCambio();
			return true;
		}
		return false;

	}
	
	@Override
	public boolean setConexionElectrica(boolean conexionElectrica) {
		return false;
	}
	
	@Override
	public boolean setConexionRuta(boolean conexionRuta) {
		return false;
	}

	@Override
	public void dibujarse(VistaDeHectarea vistaDeHectarea) {
		vistaDeHectarea.dibujarHectarea(this);
	}

}
