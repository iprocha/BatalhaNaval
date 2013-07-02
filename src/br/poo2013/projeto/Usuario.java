package br.poo2013.projeto;

import java.util.Scanner;
import java.util.Arrays;

public class Usuario extends Jogador {
	
	public void posicionarNavio() {
		posicionarNavioPequeno();
		//posicionarNavioMedio();
		//posicionarNavioGrande();
	}

	public void posicionarNavioPequeno() {
		Scanner s = new Scanner(System.in);
		boolean verifica_sentido;
		String option;
		int i=0;
		
		do {
			System.out.println("Escolha a posição do Navio Pequeno");
			Coordenada coordenadas = bombardear();
			do {
				System.out.println("Colocar na Horizontal? S/N");
				option = s.nextLine();
			} while (!option.equalsIgnoreCase("s")
					&& !option.equalsIgnoreCase("n"));
			verifica_sentido = parseOption(option);
			super.navioPequeno.add(new NavioPequeno(coordenadas,
					verifica_sentido));
			try {
				super.campoNavio.colocaNavioPequeno(super.navioPequeno.get(i));
				i++;
			} catch (PosicaoInvalida e) {
				super.navioPequeno.remove(i);
				System.out.println("Posição Inválida! Informe outra Posição!");
			}
		} while (super.navioPequeno.size() < 3);
	}

	public Coordenada bombardear() {
		Scanner s = new Scanner(System.in);
		Coordenada coordenadas = new Coordenada();
		int posX, posY;

		do {
			System.out.print("Informe a coordenada X: ");
			posX = s.nextInt();
		} while (posX < 0 || posX > 7);
		coordenadas.setX(posX);
		do {
			System.out.print("Informe a coordenada Y: ");
			posY = s.nextInt();
		} while (posY < 0 || posY > 7);
		coordenadas.setY(posY);
		// System.out.println("");
		return coordenadas;
	}

	@Override
	public boolean areThereShips() {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean parseOption(String option) {
		if (option.equalsIgnoreCase("s")) {
			return true;
		}
		return false;

	}

}
