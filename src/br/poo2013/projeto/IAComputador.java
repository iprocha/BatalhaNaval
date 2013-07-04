package br.poo2013.projeto;

public class IAComputador {

	// Gera um número aleatório entre 0-7
	private int rand() {
		return (int) Math.random() * 8;
	}

	private boolean colocarHorizontal() {
		int result = (int) Math.random() * 2;
		if (result == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Coordenada selecionarCoordenada() {
		Coordenada coordenadas = new Coordenada();
		int posX, posY;

		do {
			posX = rand();
		} while (posX < 0 || posX > 7);
		coordenadas.setX(posX);
		do {
			posY = rand();
		} while (posY < 0 || posY > 7);
		coordenadas.setY(posY);
		return coordenadas;
	}

	public Navio posicionarNavio(int tipoNavio) {
		boolean verifica_sentido;
		Coordenada coordenadas = selecionarCoordenada();
		verifica_sentido = colocarHorizontal();
		if(tipoNavio == 1)
			return new NavioPequeno(coordenadas, verifica_sentido);
		else if (tipoNavio == 2)
			return new NavioMedio(coordenadas, verifica_sentido);
		else
			return new NavioGrande(coordenadas, verifica_sentido);
	}

}
