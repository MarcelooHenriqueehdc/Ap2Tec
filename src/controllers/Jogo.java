package controllers;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.EscreverDados;
import model.LerDados;
import view.Janela;

public class Jogo {
	private Tabuleiro tabuleiro = new Tabuleiro();
	private ArrayList<Robo> robos = new ArrayList<Robo>();
	private ArrayList<Player> players;
	private Random random;
	private Janela janela;
	private Robo roboEscolhido;
	private int celulaEscolhida;
	// imagens dos robos
	private ImageIcon IconeAndador = new ImageIcon("src/icones/andador.png");
	private ImageIcon IconeCavalo = new ImageIcon("src/icones/cavalo.png");
	private ImageIcon IconeRei = new ImageIcon("src/icones/rei.png");
	// Camada do banco de dados
	private EscreverDados escrever;
	private LerDados ler;

	public Jogo(Janela janela) {
		random = new Random();
		sorteaJogo();
		robos.add(new Robo("Andador", IconeAndador));
		robos.add(new Robo("Cavalo", IconeCavalo));
		robos.add(new Robo("Rei", IconeRei));
		escrever = new EscreverDados();
		ler = new LerDados();
		ler.lerDados("relatorio/Jogos.txt");
		players = ler.getListaJogadores();
	}

	public void sorteaJogo() {
		// quantidade de alunos
		for (int i = 0; i < 20; i++) {
			if (tabuleiro.listaCelulas.get(random.nextInt(64)).getAlunoOuBug() == 0) {
				tabuleiro.listaCelulas.get(random.nextInt(64)).setAlunoOuBug(1);
				;
			} else {
				i = i - 1;
			}
		}
		// quantidade de bugs
		for (int i = 0; i < 16; i++) {
			if (tabuleiro.listaCelulas.get(random.nextInt(64)).getAlunoOuBug() == 0) {
				tabuleiro.listaCelulas.get(random.nextInt(64)).setAlunoOuBug(2);
				;
			} else {
				i = i - 1;
			}
		}
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public Robo getRobo(int id) {
		return robos.get(id);
	}

	public void setCelulaEscolhida(int id) {
		celulaEscolhida = id;
	}

	public void proximaRodada() {
		for (int i = 0; i < robos.size(); i++) {
			robos.get(i).setPosicao(-1);
		}
	}

	public void setRobos(ArrayList<Robo> robos) {
		this.robos = robos;
	}

	public void setRoboEscolhido(Robo robo) {
		roboEscolhido = robo;
	}

	public boolean verificaMovimento() {
		if (roboEscolhido != null) {
			if (roboEscolhido.getPosicao() != -1) {
				return false;
			} else {
				roboEscolhido.setPosicao(celulaEscolhida);
				tabuleiro.getCelula(celulaEscolhida).setVisitada(true);
				return true;
			}
		} else {
			return false;
		}

	}

	public boolean verificaAcertosEErros() {
		for (int i = 0; i < robos.size(); i++) {
			if (robos.get(i).getPosicao() == -1) {
				return false;
			}
		}
		for (int i = 0; i < robos.size(); i++) {
			if (tabuleiro.getCelula(robos.get(i).getPosicao()).getAlunoOuBug() == 1) {
				robos.get(i).achouAluno();
				players.get(IdJogadorDaVez()).achouAluno();
			}
			if (tabuleiro.getCelula(robos.get(i).getPosicao()).getAlunoOuBug() == 2) {
				robos.get(i).achouBug();
				players.get(IdJogadorDaVez()).achouBug();
			}
			if (tabuleiro.getCelula(robos.get(i).getPosicao()).getAlunoOuBug() == 0) {
				players.get(IdJogadorDaVez()).naoAchouNada();
			}
		}
		players.get(IdJogadorDaVez()).atualizaPontuacao();
		players.get(IdJogadorDaVez()).jogo();
		return true;
	}

	public Icon pegaIcon() {
		return roboEscolhido.getIcon();
	}

	public Robo getRoboEscolhido() {
		return roboEscolhido;
	}

	// Metodos da persistencia
	public void gravarDados() {
		escrever.escreverDados(formatarDados());
	}

	public String formatarDados() {

		String Saida = "";
		for (int i = 0; i < players.size(); i++) {
			Saida += players.get(i).formataDadosParaATabela();
		}

		return Saida;
	}

	// Metodos dos dados dos jogadores
	public void CriarNovoJogador(String nome) {
		players.add(new Player(nome));
	}

	public int NumJogadores() {
		return players.size();
	}

	public int IdJogadorDaVez() {
		return NumJogadores() - 1;
	}

	public Player getJogadorDaVez() {
		return players.get(IdJogadorDaVez());
	}

	// metodos para pegar dados da lista e printar no relatorio
	public int getPontosTotal(int indice) {
		return players.get(indice).getPontuacao();
	}

	public String getNome(int indice) {
		return players.get(indice).getNome();
	}

	public int getAlunos(int indice) {
		return players.get(indice).getAlunosRegatados();
	}

	public int getBugs(int indice) {
		return players.get(indice).getBugsEncontrados();
	}

	public int getPontosAndador(int indice) {
		return players.get(indice).getPontosA();
	}

	public int getPontosCavalo(int indice) {
		return players.get(indice).getPontosC();
	}

	public int getPontosRei(int indice) {
		return players.get(indice).getPontosR();
	}

	public int getRodadas(int indice) {
		return players.get(indice).getRodadas();
	}

	public int getCasasVazias(int indice) {
		return players.get(indice).getCelulasVazias();
	}
}
