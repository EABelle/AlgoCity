package algocity.core.capas;

import algocity.core.capas.tendido.RedDeAgua;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.construibles.Construible;
import algocity.core.construibles.ConstruibleEnLlano;
import algocity.vistas.VistaDeHectarea;

public class HectareaLlana extends Hectarea {

	RedElectrica redElectrica;

	public HectareaLlana() {
		super();
	}

	@Override
	public boolean agregarConstruible(Construible construible) {
		try{
			if (agregarConstruibleEnLlano((ConstruibleEnLlano)construible)){
				return true;
			}
		}catch(Exception e){}
		return false;

	}

	@Override
	public boolean redElectricaConectada() {
		alimentada = (conexionElectrica && redElectrica.servicioExiste(x, y))
					 | (centralesCerca > 0);
		return alimentada;
	}

	@Override
	public boolean setConexionElectrica(boolean conexionElectrica) {
		if (this.conexionElectrica != conexionElectrica) {
			this.conexionElectrica = conexionElectrica;
			hayCambio();
			return true;
		}
		return false;
	}

	private boolean agregarConstruibleEnLlano(ConstruibleEnLlano construible) {

		if (this.construible == null){
			this.construible = construible;
			this.hayCambio();
			return true;
		}
		return false;
	}

	@Override
	public void dibujarse(VistaDeHectarea vistaDeHectarea) {
		vistaDeHectarea.dibujarHectarea(this);
	}



	@Override
	public void setTendidos(RedDeAgua redDeAgua, RedElectrica redElectrica) {
		this.redDeAgua = redDeAgua;
		this.redElectrica = redElectrica;
		}

}