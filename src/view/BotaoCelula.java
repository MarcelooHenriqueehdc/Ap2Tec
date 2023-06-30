package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controllers.Celula;

public class BotaoCelula extends JButton{
	private Celula celula;
	public BotaoCelula(Celula celula) {
		this.celula = celula;
	}
	public int RetornaId() {
		return celula.getId();
		
	}
	public void marcaBotao() {
		if(celula.isVisitada()) {
			if(celula.getAlunoOuBug() == 1 ) {
				this.setIcon(new ImageIcon(celula.trataIconeAluno()));
			}else if(celula.getAlunoOuBug() == 2 ) {
				this.setIcon(new ImageIcon(celula.trataIconeBug()));
			}else{
				this.setIcon(new ImageIcon(celula.trataIconeRachadura()));
				this.setBackground(Color.gray);
			}
			this.setEnabled(false);
			
		}
	}
	
}
