package br.poo2013.projeto;

public class CampoNavio extends CampoDeBatalha {

	public CampoNavio() {
		super();
		super.printCampo();
	}

	public void colocaNavioPequeno(NavioPequeno navio) throws PosicaoInvalida {
		if (navio.isHorizontal()) {
			if (navio.getPosicaoX() + navio.getTamanho() > 7) {
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
		} else {
			if (navio.getPosicaoY() + navio.getTamanho() > 7) {
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
		}
	}

}
