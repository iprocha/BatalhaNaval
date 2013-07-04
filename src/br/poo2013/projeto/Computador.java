package br.poo2013.projeto;

public class Computador extends Jogador {
	private IAComputador pc_ai;

	public Computador() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void posicionarNavio() {
		posicionarNavioPequeno();
		posicionarNavioMedio();
		posicionarNavioGrande();
	}

	@Override
	public Coordenada bombardear() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void posicionarNavioPequeno(){
		int i = 0;
		do {
			super.navioPequeno.add((NavioPequeno) pc_ai.posicionarNavio(1));
			try {
				super.campoNavio.colocaNavio(super.navioPequeno.get(i));
				//System.out.println("Campo Computador");
				super.campoNavio.printCampo();
				i++;
			} catch (PosicaoInvalida e) {
				super.navioPequeno.remove(i);
			}
		} while (super.navioPequeno.size() < 3);
	}
	
	public void posicionarNavioMedio(){
		int i = 0;
		do {
			super.navioMedio.add((NavioMedio) pc_ai.posicionarNavio(2));
			try {
				super.campoNavio.colocaNavio(super.navioMedio.get(i));
				//System.out.println("Campo Computador");
				super.campoNavio.printCampo();
				i++;
			} catch (PosicaoInvalida e) {
				super.navioMedio.remove(i);
			}
		} while (super.navioMedio.size() < 2);
	}
	
	public void posicionarNavioGrande(){
		int i = 0;
		do {
			super.navioGrande.add((NavioGrande) pc_ai.posicionarNavio(3));
			try {
				super.campoNavio.colocaNavio(super.navioGrande.get(i));
				//System.out.println("Campo Computador");
				super.campoNavio.printCampo();
				i++;
			} catch (PosicaoInvalida e) {
				super.navioGrande.remove(i);
			}
		} while (super.navioGrande.size() < 1);
	}

}
