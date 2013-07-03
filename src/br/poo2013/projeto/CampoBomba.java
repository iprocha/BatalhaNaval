package br.poo2013.projeto;

public class CampoBomba extends CampoDeBatalha {

	public CampoBomba() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void atualizarCampo(boolean acerto, Coordenada coordenadas){
		if(acerto){
			super.campo[coordenadas.getX()][coordenadas.getY()] = "x";
		} else{
			super.campo[coordenadas.getX()][coordenadas.getY()] = "a";
		}
	}

}
