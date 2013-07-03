package br.poo2013.projeto;

public class Computador extends Jogador {
	private IAComputador pc_ai;

	public Computador() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void posicionarNavio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Coordenada bombardear() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void posicionarNavioPequeno(){
		int i = 0;
		do {
			super.navioPequeno.add(pc_ai.posicionarNavioPequeno());
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

//	@Override
//	public void posicionarNavio(int navio, int coordX, int coordY) {
//		
//	}
//
//	@Override
//	public void bombardear(int coordX, int coordY) {
//		
//	}

}
