public class No{
	Tabuleiro estado;
	Jogador jogador;
	No pai;
	No sucessores[];
	Jogada jogada;
	int score;
	
	
	public No(Tabuleiro tab, Jogador jogador){
		estado=tab;
		this.jogador = jogador;
	}
	
	public No(Tabuleiro tab,Jogador jogador, Jogada jogada, No pai){
		this.pai = pai;
		this.jogador = jogador;
		estado = new Tabuleiro(tab);
		this.jogada = jogada;
	}

	public No[] criaSucessores(Jogador p) {
		sucessores = new No[9-estado.casasJogadas()];
		int aux=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(estado.tab[i][j] == ' '){
					Jogada jogada = new Jogada(i,j);
					sucessores[aux] = new No(estado, jogador, jogada, this);
					sucessores[aux].estado.desenhaCasa(jogada.getX(), jogada.getY(), p.getElemento());
					aux++;
				}
			}
		}
		return sucessores;
	}
}
