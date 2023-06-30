package controllers;

import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro{
	public ArrayList<Celula> listaCelulas;
	//criando as celulas do jogo
	public Tabuleiro() {
		listaCelulas = new ArrayList<Celula>();
		int contador =0;
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8;j++ ) {
				Celula celula = new Celula(contador);
				listaCelulas.add(celula);
				contador++;
			}
		}
	}
	public Celula getCelula(int id) {
		return listaCelulas.get(id);
	}
}
