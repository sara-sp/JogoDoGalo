import java.util.Scanner;

public class Humano extends Jogador{
	
	Scanner inp = new Scanner(System.in);
	char elemento;
	
	public Humano(char c){
		elemento = c;
	}

	public void jogar(Tabuleiro tab) {

        System.out.println("\nÉ a tua vez de jogar, escolhe uma casa de 1 a 9!");

		int casa = inp.nextInt();
		int x=0,y=0;

		switch (casa) {
			case 1:
				x = 0;
				y = 0;
				break;
			case 2:
				x = 0;
				y = 1;
				break;
			case 3:
				x = 0;
				y = 2;
				break;
			case 4:
				x = 1;
				y = 0;
				break;
			case 5:
				x = 1;
				y = 1;
				break;
			case 6:
				x = 1;
				y = 2;
				break;
			case 7:
				x = 2;
				y = 0;
				break;
			case 8:
				x = 2;
				y = 1;
				break;
			case 9:
				x = 2;
				y = 2;
				break;
		}

		while(tab.maEscolha(x, y)){
			System.err.println("Má opcao, escolha outra casa!");
			casa = inp.nextInt();

            switch (casa) {
                case 1:
                    x = 0;
                    y = 0;
                    break;
                case 2:
                    x = 0;
                    y = 1;
                    break;
                case 3:
                    x = 0;
                    y = 2;
                    break;
                case 4:
                    x = 1;
                    y = 0;
                    break;
                case 5:
                    x = 1;
                    y = 1;
                    break;
                case 6:
                    x = 1;
                    y = 2;
                    break;
                case 7:
                    x = 2;
                    y = 0;
                    break;
                case 8:
                    x = 2;
                    y = 1;
                    break;
                case 9:
                    x = 2;
                    y = 2;
                    break;
            }
		}

		tab.desenhaCasa(x, y, elemento);
	}

	public char getElemento(){
		return elemento;
	}
}
