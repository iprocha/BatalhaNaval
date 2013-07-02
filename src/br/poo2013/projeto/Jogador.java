package br.poo2013.projeto;
import java.util.Arrays;
import java.util.ArrayList;

public abstract class Jogador {
	protected ArrayList<NavioPequeno> navioPequeno;
	protected ArrayList<NavioMedio> navioMedio;
	protected ArrayList<NavioGrande> navioGrande;
	
	protected CampoNavio campoNavio;
	protected CampoBomba campoBomba;
	
	private static final int QTD_PEQUENO = 3;
	private static final int QTD_MEDIO = 2;
	private static final int QTD_GRANDE = 1;
	
	
	public Jogador(){
		super();
		navioPequeno = new ArrayList<NavioPequeno>();
		navioMedio = new ArrayList<NavioMedio>();
		navioGrande = new ArrayList<NavioGrande>();
		campoNavio = new CampoNavio();
		campoBomba = new CampoBomba();
	}
	
	//Informa se o jogador ainda possui navios
	public abstract boolean areThereShips();
	//Posiciona os navios do Jogador
	public abstract void posicionarNavio();
	//Ataca o oponente
	public abstract Coordenada bombardear();

}
