package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import controllers.Player;

public class LerDados {

	private ArrayList<Player> listaPlayers;

	public LerDados() {
		listaPlayers = new ArrayList<Player>();
	}

	public void lerDados(String diretorio) {
		try {

			FileReader Arquivo = new FileReader("src/relatorio/Jogos.txt");
			BufferedReader Leitura = new BufferedReader(Arquivo);

			while (Leitura.ready()) {

				listaPlayers.add(separarDadosdoPlayer(Leitura.readLine()));
			}
			Leitura.close();
		} catch (Exception e) {

		}
	}

	private Player separarDadosdoPlayer(String linha) {

		String Dados[] = linha.split(";");

		int Rodadas = Integer.parseInt(Dados[1]);
		int Vazias = Integer.parseInt(Dados[2]);
		int Pontos = Integer.parseInt(Dados[3]);
		int Alunos = Integer.parseInt(Dados[4]);
		int Bugs = Integer.parseInt(Dados[5]);
		int Andador = Integer.parseInt(Dados[6]);
		int Cavalo = Integer.parseInt(Dados[7]);
		int Rei = Integer.parseInt(Dados[8]);

		Player JogadorAux = new Player(Dados[0], Rodadas, Vazias, Pontos, Alunos, Bugs, Andador, Cavalo, Rei);
		return JogadorAux;
	}

	public ArrayList<Player> getListaJogadores() {
		return listaPlayers;
	}

}