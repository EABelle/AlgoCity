package algocity.core.capas.tendido;

import algocity.core.capas.Hectarea;


public class RedElectrica extends Tendido {

	@Override
	public boolean setConexion(Hectarea hectarea, boolean estado) {
		return hectarea.setConexionElectrica(estado);
	}}
