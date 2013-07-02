package br.poo2013.projeto;

import java.util.Arrays;

public abstract class CampoDeBatalha {
	protected String[][] campo;

	public CampoDeBatalha() {
		campo = new String[8][8];
		fillCampo();
	}
	
	public void fillCampo(){
		for(int i = 0; i < campo.length ; i++){
			Arrays.fill(campo[i], "~");
		}
	}
	
	public void printCampo(){
		System.out.println("");
		System.out.println("  0 1 2 3 4 5 6 7");
		for(int i=0; i<campo.length;i++){
			System.out.print(i+" ");
			for(int j=0; j<campo[i].length; j++){
				System.out.print(campo[i][j]+" ");
			}
			System.out.println(i);
		}
		System.out.println("  0 1 2 3 4 5 6 7");
	}
	
	
	
}
