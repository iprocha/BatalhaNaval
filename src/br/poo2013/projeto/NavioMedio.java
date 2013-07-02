package br.poo2013.projeto;

public class NavioMedio extends Navio {
	private int tamanho;
	private int dano;
	private Coordenada coordenadas;
	private boolean isDown;
	private boolean isHorizontal;

	public NavioMedio(Coordenada coordenada, boolean isHorizontal) {
		coordenadas = coordenada;
		this.isHorizontal = isHorizontal;
		this.isDown = false;
		dano = 0;
		tamanho = TamanhoNavio.MEDIO.getTamanho();
	}

	public int getPosicaoX() {
		return coordenadas.getX();
	}
	
	public int getPosicaoY() {
		return coordenadas.getY();
	}

	public boolean navioAbatido() {
		return isDown;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void danoSofrido() {
		dano++;
		if(dano == tamanho){
			isDown = true;
		}
	}
	
	public boolean isHorizontal() {
		return isHorizontal;
	}

}
