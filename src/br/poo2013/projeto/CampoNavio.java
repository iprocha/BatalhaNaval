package br.poo2013.projeto;

public class CampoNavio extends CampoDeBatalha {

	public CampoNavio() {
		super();
		//super.printCampo();
	}

	public void colocaNavio(Navio navio) throws PosicaoInvalida {
		if (navio.isHorizontal()) {
			if (navio.getPosicaoY() + navio.getTamanho() > 8) {
				throw new PosicaoInvalida();
			}
			for (int j = 0; j < navio.getTamanho(); j++) {
				if (super.campo[navio.getPosicaoX()][navio.getPosicaoY() + j]
						.equals("*")) {
					throw new PosicaoInvalida();
				}
			}
			for (int j = 0; j < navio.getTamanho(); j++) {
				super.campo[navio.getPosicaoX()][navio.getPosicaoY() + j] = "*";
			}
		} else {
			if (navio.getPosicaoX() + navio.getTamanho() > 8) {
				throw new PosicaoInvalida();
			}
			for (int i = 0; i < navio.getTamanho(); i++) {
				if (super.campo[navio.getPosicaoX() + i][navio.getPosicaoY()]
						.equals("*")) {
					throw new PosicaoInvalida();
				}
			}
			for (int i = 0; i < navio.getTamanho(); i++) {
				super.campo[navio.getPosicaoX() + i][navio.getPosicaoY()] = "*";
			}
			
		}
	}
	//Verifica se na coordenada informada existe um navio
	public boolean verificaNavio(Coordenada coordenada){
		return super.campo[coordenada.getX()][coordenada.getY()].equals("*");
	}
	
	public void bomba(Coordenada coordenadas){
		if(super.campo[coordenadas.getX()][coordenadas.getY()].equals("~")){
			super.campo[coordenadas.getX()][coordenadas.getY()] = "a";
		}else{
			super.campo[coordenadas.getX()][coordenadas.getY()] = "x";
		}		
	}

}
