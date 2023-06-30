package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;import javax.swing.border.Border;

import controllers.Jogo;

public class Janela extends JFrame{
	private Jogo jogo;
	private PainelInicial painelInicial;
	private PainelTabuleiro painelTabuleiro;
	private PainelMenu painelMenu;
	private JPanel painelBaixo = new JPanel();
	private PainelRelatorioDeDados painelRelatorio;
	public Janela() {
		this.setSize(800,600);
		jogo = new Jogo(this);
		this.setTitle("Resgate dos Alunos");
		painelMenu = new PainelMenu(this);
		painelTabuleiro = new PainelTabuleiro(jogo.getTabuleiro() ,this);
		painelInicial = new PainelInicial(this,painelTabuleiro, painelMenu);
		
		
		this.setLayout(new BorderLayout());
		painelBaixo.setLayout(new BorderLayout());
		painelBaixo.add(painelMenu, BorderLayout.EAST);
		painelBaixo.add(painelTabuleiro, BorderLayout.WEST);
		this.add(painelInicial, BorderLayout.NORTH);
		this.add(painelBaixo, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	public Jogo getJogo() {
		return jogo;
	}
	public PainelInicial getPainelInicial() {
		return painelInicial;
		
	}
	public JPanel getPainelBaixo() {
		return painelBaixo;
	}
	public PainelTabuleiro getTabuleiro() {
		return painelTabuleiro;
	}
	public PainelMenu getMenu() {
		return painelMenu;
	}
	public PainelRelatorioDeDados getPainelRelatorio() {
		painelRelatorio = new PainelRelatorioDeDados(this, jogo);
		return painelRelatorio;
	}
}
