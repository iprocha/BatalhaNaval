package br.poo2013.projeto;

public abstract class Navio {
	public abstract int getPosicaoX();
	public abstract int getPosicaoY();
	public abstract boolean navioAbatido();
	public abstract void danoSofrido();
	public abstract int getTamanho();
	public abstract boolean isHorizontal();
}
