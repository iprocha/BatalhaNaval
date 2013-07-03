package br.poo2013.projeto;

public class Controller {
	private Usuario player;
	private Computador computador;

	public Controller() {
		player = new Usuario();
		computador = new Computador();
	}

	public void start() {
		System.out.println("Batalha Iniciada!");
		player.posicionarNavio();
		do {
			player.campoNavio.printCampo();
			//player.verificaAcerto(player.bombardear());
			
			player.campoNavio.printCampo();
		} while (isOver());
	}

	// TODO: Informa se a partida acabou
	public boolean isOver() {
		return (player.areThereShips() && computador.areThereShips());
	}
	//Verifica se o Computador acertou o navio inimigo
	public boolean verificaAcertoComputador(Coordenada coordenadas){
		return player.verificaAcerto(coordenadas);
	}
	//Verifica se o Usuário acertou o navio inimigo
	public boolean verificaAcertoPlayer(Coordenada coordenadas){
		//return computador.verificaAcerto(coordenadas);
		return false;
	}

}
