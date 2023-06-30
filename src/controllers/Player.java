package controllers;

import java.util.ArrayList;

public class Player {
	private String nome;
	private int pontuacao;
	private int celulasVazias;
	private int rodadas;
	private int alunosRegatados;
	private int bugsEncontrados;
	private int pontosA;
	private int pontosC;
	private int pontosR;
	
	public  Player(String nome) {
		this.nome = nome;
		celulasVazias =0;
		pontuacao=0;
		rodadas = 0;
		alunosRegatados = 0;
		bugsEncontrados = 0;
		pontosA =0;
		pontosC =0;
		pontosR = 0;
		
	}
	public Player(String nome, int rodadas, int celulasVazias, int pontuacao, int alunosResgatados, int bugsEncontrados, int pAndador, int pCavalos, int pRei) {
		this.nome = nome;
		this.rodadas = rodadas;
		this.celulasVazias = celulasVazias;
		this.pontuacao = pontuacao;
		this.alunosRegatados = alunosResgatados;
		this.bugsEncontrados = bugsEncontrados;
		pontosA = pAndador;
		pontosC =pCavalos;;
		pontosR = pRei;
	}
	public void achouBug() {
		bugsEncontrados++;
	}
	public void achouAluno() {
		alunosRegatados++;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getPontuacao() {
		return pontuacao;
	}
	public void atualizaPontuacao() {
		pontuacao  = pontosA+pontosC+pontosR;
	}

	public String formataDadosParaATabela() {
		String Dados = "";
		Dados += getNome() + ";" + getRodadas() + ";" + getCelulasVazias() + ";" + getPontuacao() + 
				";" + getAlunosRegatados() + ";" + getBugsEncontrados() + ";" + pontosA + ";" + pontosC + 
				";" + pontosR + "\n" ;
		
		return Dados;
	}
	public int getCelulasVazias() {
		return celulasVazias;
	}
	public void jogo() {
		rodadas++;
	}

	public void naoAchouNada() {
		celulasVazias++;
	}


	public int getRodadas() {
		return rodadas;
	}


	public void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}

	public int getAlunosRegatados() {
		return alunosRegatados;
	}


	public void setAlunosRegatados(int alunosRegatados) {
		this.alunosRegatados = alunosRegatados;
	}


	public int getBugsEncontrados() {
		return bugsEncontrados;
	}


	public void setBugsEncontrados(int bugsEncontrados) {
		this.bugsEncontrados = bugsEncontrados;
	}
	public int getPontosA() {
		return pontosA;
	}
	public void setPontosA(int pontosA) {
		this.pontosA = pontosA;
	}
	public int getPontosC() {
		return pontosC;
	}
	public void setPontosC(int pontosC) {
		this.pontosC = pontosC;
	}
	public int getPontosR() {
		return pontosR;
	}
	public void setPontosR(int pontosR) {
		this.pontosR = pontosR;
	}
	
	
}
