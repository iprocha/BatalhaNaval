package br.poo2013.projeto;

public interface Navio {
	final static int PEQUENO = 2;
	final static int MEDIO = 5;
	final static int GRANDE = 6;
	
	public abstract int getPosicao();
	public abstract boolean navioAbatido();
	public abstract void danoSofrido();
	

}
