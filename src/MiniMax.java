public class MiniMax {
	
	static int nNos;

	public static Jogada decide(No noAtual, Jogador jogadorAtual, Tabuleiro tab, char elemento) {
		nNos = 0;
		int v = valorMaximo(noAtual,jogadorAtual);

		if(!tab.maEscolha(0,0) && (tab.tabela()[0][1]==elemento && tab.tabela()[0][2]==elemento || tab.tabela()[1][0]==elemento && tab.tabela()[2][0]==elemento ||tab.tabela()[1][1]==elemento && tab.tabela()[2][2]==elemento))
			return new Jogada(0, 0, nNos);
		else if(!tab.maEscolha(0,1) && (tab.tabela()[0][0]==elemento && tab.tabela()[0][2]==elemento || tab.tabela()[1][1]==elemento && tab.tabela()[2][1]==elemento))
			return new Jogada(0, 1, nNos);
		else if(!tab.maEscolha(0,2) && (tab.tabela()[0][0]==elemento && tab.tabela()[0][1]==elemento || tab.tabela()[1][2]==elemento && tab.tabela()[2][2]==elemento ||tab.tabela()[1][1]==elemento && tab.tabela()[2][0]==elemento))
			return new Jogada(0, 2, nNos);

		else if(!tab.maEscolha(1,0) && (tab.tabela()[0][0]==elemento && tab.tabela()[2][0]==elemento || tab.tabela()[1][1]==elemento && tab.tabela()[1][2]==elemento))
			return new Jogada(1, 0, nNos);
		else if(!tab.maEscolha(1,1) && (tab.tabela()[0][0]==elemento && tab.tabela()[2][2]==elemento || tab.tabela()[0][2]==elemento && tab.tabela()[2][0]==elemento ||tab.tabela()[1][0]==elemento && tab.tabela()[1][2]==elemento))
			return new Jogada(1, 1, nNos);
		else if(!tab.maEscolha(1,2) && (tab.tabela()[1][0]==elemento && tab.tabela()[1][1]==elemento || tab.tabela()[0][2]==elemento && tab.tabela()[2][2]==elemento))
			return new Jogada(1, 2, nNos);

		else if(!tab.maEscolha(2,0) && (tab.tabela()[0][0]==elemento && tab.tabela()[1][0]==elemento || tab.tabela()[2][1]==elemento && tab.tabela()[2][2]==elemento ||tab.tabela()[1][1]==elemento && tab.tabela()[0][2]==elemento))
			return new Jogada(2, 0, nNos);
		else if(!tab.maEscolha(2,1) && (tab.tabela()[2][0]==elemento && tab.tabela()[2][2]==elemento || tab.tabela()[0][1]==elemento && tab.tabela()[1][1]==elemento))
			return new Jogada(2, 1, nNos);
		else if(!tab.maEscolha(2,2) && (tab.tabela()[0][0]==elemento && tab.tabela()[1][1]==elemento || tab.tabela()[0][2]==elemento && tab.tabela()[1][2]==elemento ||tab.tabela()[2][0]==elemento && tab.tabela()[2][1]==elemento))
			return new Jogada(2, 2, nNos);
		else{
			for(No n : noAtual.sucessores){
				if(n.score==v)							//gerar configuracao para cada no
					return new Jogada(n.jogada.getX(), n.jogada.getY(), nNos);	//ver seq 3-7-9 cpu a começar
			}
		}
		return null;
	}

	private static int valorMaximo(No node, Jogador jogadorAtual) {
		if(node.estado.empate()) 
            return 0;
		if(node.estado.vitoria() == jogadorAtual.getElemento())
            return 1;
		if(node.estado.vitoria() == Jogo.outro(jogadorAtual).getElemento())
            return -1;
		
        int v = Integer.MIN_VALUE;
		

        for(No n : node.criaSucessores(jogadorAtual)){

			nNos ++;
			v=Math.max(v, valorMinimo(n,Jogo.outro(jogadorAtual)));
			n.score = v;

		}
		return v;
	}

	private static int valorMinimo(No node, Jogador jogadorAtual){
		if(node.estado.empate()) 
            return 0;
		if(node.estado.vitoria() == jogadorAtual.getElemento())
            return -1;
		if(node.estado.vitoria() == Jogo.outro(jogadorAtual).getElemento())
            return 1;
		
        int v = Integer.MAX_VALUE;
		
        for(No n : node.criaSucessores(jogadorAtual)){
			nNos++;
			v=Math.min(v, valorMaximo(n,Jogo.outro(jogadorAtual)));
			n.score = v;
		}
		return v;
	}
}
