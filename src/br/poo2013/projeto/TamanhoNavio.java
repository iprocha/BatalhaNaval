package br.poo2013.projeto;

public enum TamanhoNavio {
	PEQUENO(2),
	MEDIO(5),
	GRANDE(6);
	
	public int valorTamanho;
	
	TamanhoNavio(int valor){
		valorTamanho = valor;
	}
	
	public int getTamanho(){
		return valorTamanho;
	}
}
