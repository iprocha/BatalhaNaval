package br.poo2013.projeto;

import java.util.Scanner;
import java.util.Arrays;

public class Usuario extends Jogador {
	
	public void posicionarNavio() {
		posicionarNavioPequeno();
		posicionarNavioMedio();
		posicionarNavioGrande();
	}

	public void posicionarNavioPequeno() {
		Scanner s = new Scanner(System.in);
		boolean verifica_sentido;
		String option;
		int i=0;
		
		do {
			System.out.println("Escolha a posição do "+(i+1)+" Navio Pequeno");
			Coordenada coordenadas = selecionarCoordenada();
			do {
				System.out.println("Colocar na Horizontal? S/N");
				option = s.nextLine();
			} while (!option.equalsIgnoreCase("s")
					&& !option.equalsIgnoreCase("n"));
			verifica_sentido = parseOption(option);
			super.navioPequeno.add(new NavioPequeno(coordenadas,
					verifica_sentido));
			try {
				super.campoNavio.colocaNavio(super.navioPequeno.get(i));
				super.campoNavio.printCampo();
				i++;
			} catch (PosicaoInvalida e) {
				super.navioPequeno.remove(i);
				System.out.println("Posição Inválida! Informe outra Posição!");
			}
		} while (super.navioPequeno.size() < 3);
	}
	
	public void posicionarNavioMedio() {
		Scanner s = new Scanner(System.in);
		boolean verifica_sentido;
		String option;
		int i=0;
		
		do {
			System.out.println("Escolha a posição do "+(i+1)+" Navio Medio");
			Coordenada coordenadas = selecionarCoordenada();
			do {
				System.out.println("Colocar na Horizontal? S/N");
				option = s.nextLine();
			} while (!option.equalsIgnoreCase("s")
					&& !option.equalsIgnoreCase("n"));
			verifica_sentido = parseOption(option);
			super.navioMedio.add(new NavioMedio(coordenadas,
					verifica_sentido));
			try {
				super.campoNavio.colocaNavio(super.navioMedio.get(i));
				super.campoNavio.printCampo();
				i++;
			} catch (PosicaoInvalida e) {
				super.navioMedio.remove(i);
				System.out.println("Posição Inválida! Informe outra Posição!");
			}
		} while (super.navioMedio.size() < 2);
	}
	
	public void posicionarNavioGrande() {
		Scanner s = new Scanner(System.in);
		boolean verifica_sentido;
		String option;
		int i=0;
		
		do {
			System.out.println("Escolha a posição do "+(i+1)+" Navio Grande");
			Coordenada coordenadas = selecionarCoordenada();
			do {
				System.out.println("Colocar na Horizontal? S/N");
				option = s.nextLine();
			} while (!option.equalsIgnoreCase("s")
					&& !option.equalsIgnoreCase("n"));
			verifica_sentido = parseOption(option);
			super.navioGrande.add(new NavioGrande(coordenadas,
					verifica_sentido));
			try {
				super.campoNavio.colocaNavio(super.navioGrande.get(i));
				super.campoNavio.printCampo();
				i++;
			} catch (PosicaoInvalida e) {
				super.navioGrande.remove(i);
				System.out.println("Posição Inválida! Informe outra Posição!");
			}
		} while (super.navioGrande.size() < 1);
	}
	
	//TODO: ajeitar aqui xD
	public Coordenada bombardear() {
		return selecionarCoordenada();
	}
	
	public Coordenada selecionarCoordenada(){
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
		return 
				(
				super.navioGrande.get(0).isDown()
				|| super.navioMedio.get(0).isDown()
				|| super.navioMedio.get(1).isDown()
				|| super.navioPequeno.get(0).isDown()
				|| super.navioPequeno.get(1).isDown()
				|| super.navioPequeno.get(2).isDown()
				);
	}

	private boolean parseOption(String option) {
		if (option.equalsIgnoreCase("s")) {
			return true;
		}
		return false;

	}

}
