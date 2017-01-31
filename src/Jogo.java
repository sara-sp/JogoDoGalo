public class Jogo {
	
	static Jogador p1;
	static Jogador p2;
	Tabuleiro tab;
	int nJogadas;
	Boolean termina;

	public Jogo(Jogador p1, Jogador p2) {
		Jogo.p1 = p1;
        Jogo.p2 = p2;
		this.tab = new Tabuleiro();
		nJogadas = 1;
		termina = false;
	}
	
	public Jogador atual(){
		if(nJogadas % 2 == 0)
			return p2;
		else
			return p1;
	}

    public static Jogador outro(Jogador p){
        if(p == p1)
            return p2;
        else
            return p1;
    }

	public void vez() {
		atual().jogar(tab);
		System.out.println(tab.imprime());

		if(tab.vitoria() != 'N' && !tab.empate())
			System.out.println("\nCPU ganhou o jogo!");

		nJogadas++;

		if(tab.empate())
			System.out.println("\nEmpate!");

		if(tab.vitoria() != 'N' || tab.empate())
			termina = true;

		
	}
}