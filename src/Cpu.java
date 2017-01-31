public class Cpu extends Jogador{

	long tempo;
	int numeroNos;
    String algoritmo;
    char elemento;
	
	Cpu(char c, String a){
        tempo = 0;
		numeroNos = 0;
        algoritmo = a;
        elemento = c;
	}
	
	public void jogar(Tabuleiro tab) {
        System.out.println("\nEspera.. é a vez do CPU jogar!");

		long inicio = System.currentTimeMillis();

        No n = new No(tab, this);
		Jogada temp;

		if(algoritmo.equalsIgnoreCase("1")) {
			temp = MiniMax.decide(n, this, tab, elemento);
			tab.desenhaCasa(temp.getX(),temp.getY(), elemento);
		}
		else {
			temp = AlfaBeta.decide(n, this, tab, elemento);
			tab.desenhaCasa(temp.getX(),temp.getY(), elemento);
		}
		long fim = System.currentTimeMillis();

		System.out.println("\nTempo de execucao " + (fim-inicio) + " ms.");
		System.out.println("Numero de nos gerados nesta jogada: " + temp.getN() + ".\n");

        tempo += fim - inicio;
		numeroNos += temp.getN();
	}

	public char getElemento() {
        return elemento;
	}
}
