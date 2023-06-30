package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.Tabuleiro;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class PainelInicial extends JPanel{
	private PainelTabuleiro tabuleiro;
	private PainelMenu menu;
	public  JTextField campoNome;
	public PainelInicial(Janela janela, PainelTabuleiro tabuleiro, PainelMenu menu) {
		this.tabuleiro = tabuleiro;
		this.menu = menu;
		JLabel name = new JLabel("Nome do jogador: ");
		campoNome = new JTextField(25);
		JButton jogar = new JButton("Jogar");
		jogar.addActionListener(new AoJogar(janela));
		JButton relatorios = new JButton("Relatório do Jogo");
		this.add(name);
		this.add(campoNome);
		this.add(jogar);
		this.add(relatorios);
	}
	public class AoJogar implements ActionListener{
		private Janela janela;
		public AoJogar(Janela janela) {
			this.janela=janela;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			janela.getJogo().CriarNovoJogador(janela.getPainelInicial().campoNome.getText());
			tabuleiro.setVisible(true);
			menu.setVisible(true);
			
		}

	}
}
