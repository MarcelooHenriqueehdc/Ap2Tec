package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.Tabuleiro;

public class PainelTabuleiro extends JPanel {
	private Tabuleiro tabuleiro;
	private ArrayList<BotaoCelula> botoes = new ArrayList<BotaoCelula>();
	private int botaoclicado;
	private Janela janela;
	public PainelTabuleiro(Tabuleiro tabuleiro, Janela janela) {
		this.tabuleiro = tabuleiro;
		this.setLayout(new GridLayout(8, 8));
		this.setPreferredSize(new Dimension(500, 600));
		// percorrendo a lista de celulas e adicionando na lista de botoes
		int aux = 0;
		for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	
                BotaoCelula Botao = new BotaoCelula(tabuleiro.getCelula(aux));
                Botao.addActionListener(new aoClicar(aux, janela,Botao));
                
                if ((i + j) % 2 == 0) {
                    Botao.setBackground(Color.WHITE);
                } else {
                    Botao.setBackground(Color.BLACK);
                }
                
                botoes.add(Botao);
                aux++;
            }
        }
		for (int i = 0; i < botoes.size(); i++) {
			this.add(botoes.get(i));
		}
		this.setVisible(false);
	}
	public void atualizaBotoes() {
		for (int i = 0; i < botoes.size(); i++) {
			botoes.get(i).marcaBotao();
		}
	}
	public class aoClicar implements ActionListener{
		private int id;
		private Janela janela;
		private JButton botao;
		public aoClicar(int id, Janela janela, JButton botao) {
			this.id = id;
			this.janela = janela;
			this.botao = botao;
		}
		public void actionPerformed(ActionEvent e) {
			janela.getJogo().setCelulaEscolhida(id);
			if(janela.getJogo().verificaMovimento()) {
				botao.setIcon(new ImageIcon(janela.getJogo().getRoboEscolhido().trataIcone()));
			}
			
		}
		
	}

}
