package controllers;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Celula {
	private int id;
	private int alunoOuBug = 0;//Aluno  ==1 , bugg =2, nada =0;
	private boolean visitada;
	private ImageIcon iconeBug = new ImageIcon("src/icones/bug.png");
	private ImageIcon iconeAluno = new ImageIcon("src/icones/aluno.png");
	private ImageIcon iconeRachadura = new ImageIcon("src/icones/rachadura.png");
	
	public Celula(int id) {
		visitada = false;
		this.id = id;
	}
	public Image trataIconeBug() {
		Image imagem = iconeBug.getImage();
		Image novaImage = imagem.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return novaImage;
	}
	public Image trataIconeRachadura() {
		Image imagem = iconeRachadura.getImage();
		Image novaImage = imagem.getScaledInstance(65, 65, Image.SCALE_SMOOTH);
		return novaImage;
	}
	public Image trataIconeAluno() {
		Image imagem = iconeAluno.getImage();
		Image novaImage = imagem.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		return novaImage;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAlunoOuBug() {
		return alunoOuBug;
	}
	public void setAlunoOuBug(int alunoOuBug) {
		this.alunoOuBug = alunoOuBug;
	}
	public boolean isVisitada() {
		return visitada;
	}
	public void setVisitada(boolean visitada) {
		this.visitada = visitada;
	}
	
}
