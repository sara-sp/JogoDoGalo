import java.util.Scanner;

public class JogoDoGalo{
	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);

		System.out.println("Seja bem-vindo(a) ao Jogo do Galo!\n");

		System.out.println("Prefere jogar com o (X) ou o (O)?");
		String opcao = " ";
        char elemento=' ', elemento2=' ';

        while(!(opcao.equalsIgnoreCase("x") || opcao.equalsIgnoreCase("X") || opcao.equalsIgnoreCase("o") || opcao.equalsIgnoreCase("O"))) {
            opcao = inp.next();

            switch (opcao) {
                case "X":
                    elemento = 'X';
                    elemento2 = 'O';
                    break;
                case "x":
                    elemento = 'X';
                    elemento2 = 'O';
                    break;
                case "O":
                    elemento = 'O';
                    elemento2 = 'X';
                    break;
                case "o":
                    elemento = 'O';
                    elemento2 = 'X';
                    break;
                default:
                    System.err.println("Elemento selecionado invalido, tente novamente!");
            }
        }


        System.out.println("\nEscolha o algoritmo pretendido:\n1 - MiniMax\t\t2 - AlfaBeta");
        String algoritmo = " ";

        while(!(algoritmo.equalsIgnoreCase("1") || algoritmo.equalsIgnoreCase("2"))){
            algoritmo = inp.next();

            if(!(algoritmo.equalsIgnoreCase("1") || algoritmo.equalsIgnoreCase("2")))
                System.err.println("Algoritmo selecionado invalido, volte a tentar!");
        }


        System.out.println("\nQuem vai comecar primeiro a jogar?\n1 - CPU\t\t\t2 - Jogador Humano");
        opcao = " ";

        while(!(opcao.equalsIgnoreCase("1") || opcao.equalsIgnoreCase("2"))){
            opcao = inp.next();

            if(!(opcao.equalsIgnoreCase("1") || opcao.equalsIgnoreCase("2")))
                System.err.println("Jogador selecionado invalido, tente novamente!");
        }

        Jogador p1, p2;

        if(opcao.equalsIgnoreCase("1")){
            p1 = new Cpu(elemento2, algoritmo);
            p2 = new Humano(elemento);
        }

        else{
            p1 = new Humano(elemento);
            p2 = new Cpu(elemento2, algoritmo);
        }

		Jogo j = new Jogo(p1, p2);

        while(!j.termina){
			j.vez();
		}

        System.out.println("Total de numero de nos gerados: " + verCpu(p1, p2).numeroNos);
        System.out.println("Tempo total de execucao " + verCpu(p1, p2).tempo + " ms");

		inp.close();

    }

	private static Cpu verCpu(Jogador p1, Jogador p2) {
		if(p1.getClass().getSimpleName().equals("Cpu"))
            return (Cpu) p1;
		if(p2.getClass().getSimpleName().equals("Cpu"))
            return (Cpu) p2;
		else
            return null;
	}
}
