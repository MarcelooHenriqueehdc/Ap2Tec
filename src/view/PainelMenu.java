package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.Celula;
import controllers.Jogo;

public class PainelMenu extends JPanel {
	private PainelPontuacao painelPontuacao;
	private JButton verificar;

	public PainelMenu(Janela janela) {
		Jogo aux = janela.getJogo();
		painelPontuacao = new PainelPontuacao(janela);
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(290, 600));

		JButton cavalo = new JButton();
		cavalo.setIcon(new ImageIcon(aux.getRobo(1).trataIcone()));
		cavalo.addActionListener(e -> aux.setRoboEscolhido(aux.getRobo(1)));
		JButton andador = new JButton();
		andador.setIcon(new ImageIcon(aux.getRobo(0).trataIcone()));
		andador.addActionListener(e -> aux.setRoboEscolhido(aux.getRobo(0)));
		JButton rei = new JButton();
		rei.setIcon(new ImageIcon(aux.getRobo(2).trataIcone()));
		rei.addActionListener(e -> aux.setRoboEscolhido(aux.getRobo(2)));

		verificar = new JButton("Verificar");
		verificar.addActionListener(new AoVerificar(aux, painelPontuacao, verificar));
		verificar.setBackground(Color.green);
		verificar.setPreferredSize(new Dimension(280, 50));
		JButton proxJogada = new JButton("Próxima Jogada");
		proxJogada.addActionListener(new ProximaRodada(janela));
		proxJogada.setPreferredSize(new Dimension(280, 50));
		proxJogada.setBackground(Color.green);
		JButton sair = new JButton("Sair do jogo");
		sair.addActionListener(new aoRelatorio(janela));
		sair.setPreferredSize(new Dimension(280, 50));
		sair.setBackground(Color.green);

		this.add(painelPontuacao);
		this.add(andador);
		this.add(cavalo);
		this.add(rei);
		this.add(verificar);
		this.add(proxJogada);
		this.add(sair);
		this.setVisible(false);
	}

	public class ProximaRodada implements ActionListener {
		private Janela janela;

		public ProximaRodada(Janela janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			if (!janela.getMenu().verificar.isEnabled()) {
				janela.getTabuleiro().atualizaBotoes();
				atualizaPainel(janela.getTabuleiro());
				janela.getMenu().verificar.setEnabled(true);
				janela.getJogo().gravarDados();
				janela.getJogo().proximaRodada();
			} else {
				JOptionPane.showMessageDialog(null, "Por favor faça a verificação antes");
			}

		}

		public void atualizaPainel(JPanel painel) {

			painel.revalidate();
			painel.repaint();
		}
	}

	public class AoVerificar implements ActionListener {
		private Jogo jogo;
		private PainelPontuacao painel;
		private JButton botao;

		public AoVerificar(Jogo jogo, PainelPontuacao painel, JButton botao) {
			this.jogo = jogo;
			this.painel = painel;
			this.botao = botao;
		}

		public void actionPerformed(ActionEvent e) {
			if (jogo.verificaAcertosEErros()) {
				atualizaPainel();
				botao.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(null, "Por favor indique a posição de cada robô antes de verificar!");
			}

		}

		public void atualizaPainel() {
			painel.pandador.setText(" : " + jogo.getRobo(0).getPontuacao());
			painel.pcavalo.setText(" : " + jogo.getRobo(1).getPontuacao());
			painel.prei.setText(" : " + jogo.getRobo(2).getPontuacao());
			painel.pontuacao.setText("Pontuação: " + jogo.getJogadorDaVez().getPontuacao());
			painel.total.setText(" Total: ");
			painel.quantidadeAlunos.setText(": " + jogo.getJogadorDaVez().getAlunosRegatados());
			painel.quantidadeBugs.setText(": " + jogo.getJogadorDaVez().getBugsEncontrados());
			painel.revalidate();
			painel.repaint();
		}

	}

	public class aoRelatorio implements ActionListener {
		private Janela janela;

		public aoRelatorio(Janela janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			janela.remove(janela.getPainelInicial());
			janela.remove(janela.getPainelBaixo());
			janela.add(janela.getPainelRelatorio());
			janela.revalidate();
			janela.repaint();
		}

	}

	public class PainelPontuacao extends JPanel {
		private Janela janela;
		private JLabel pontuacao;
		private JLabel total;
		private JLabel pandador;
		private JLabel pcavalo;
		private JLabel prei;
		private JLabel quantidadeAlunos;
		private JLabel quantidadeBugs;
		private Celula celula = new Celula(200);

		public PainelPontuacao(Janela janela) {
			this.janela = janela;
			Jogo aux = janela.getJogo();
			pontuacao = new JLabel("Pontuação: 0");
			total = new JLabel("Total: ");
			JLabel iconAluno = new JLabel(new ImageIcon(celula.trataIconeAluno()));
			quantidadeAlunos = new JLabel("- 0");
			JLabel iconBug = new JLabel(new ImageIcon(celula.trataIconeBug()));
			quantidadeBugs = new JLabel("- 0");
			quantidadeBugs.setPreferredSize(new Dimension(50, 20));
			JLabel andador = new JLabel(new ImageIcon(aux.getRobo(0).trataIcone2()));
			pandador = new JLabel(" - 0");
			JLabel cavalo = new JLabel(new ImageIcon(aux.getRobo(1).trataIcone2()));
			pcavalo = new JLabel(" - 0");
			JLabel rei = new JLabel(new ImageIcon(aux.getRobo(2).trataIcone2()));
			prei = new JLabel(" - 0");
			this.setPreferredSize(new Dimension(285, 90));
			this.add(pontuacao);
			this.add(total);
			this.add(iconAluno);
			this.add(quantidadeAlunos);
			this.add(iconBug);
			this.add(quantidadeBugs);
			this.add(andador);
			this.add(pandador);
			this.add(cavalo);
			this.add(pcavalo);
			this.add(rei);
			this.add(prei);
			this.setVisible(true);
		}
	}
}
