package br.poo2013.projeto;

public class Controller {
	private Usuario player;
	private Computador computador;
	
	public Controller(){
		player = new Usuario();
		//computador = new Computador();
	}
	public void start(){
		System.out.println("Batalha Iniciada!");
		player.posicionarNavio();
		player.campoNavio.printCampo();
	}
	
	//TODO: Informa se a partida acabou
	public boolean isOver(){
			return false;
	}

}
