public class Tabuleiro{
	char tab [][];
	
	Tabuleiro(){
		tab = new char [3][3];
		for(int i = 0 ; i < 3; i++){
			for(int j = 0; j < 3; j++){
				tab[i][j] = ' ';
			}
		}
	}

	public Tabuleiro(Tabuleiro tab2) {
		tab = new char[3][3];
		for(int i = 0 ; i < 3; i++){
            System.arraycopy(tab2.tab[i], 0, tab[i], 0, 3);     //tab[i][j]=tab2[i][j]
		}
	}

	public char[][] tabela(){
		return tab;
	}

	public boolean maEscolha(int x, int y) {
		return ((x > 3 || y > 3) || tab[x][y] != ' ');
	}

	public void desenhaCasa(int x, int y, char elemento) {
		tab[x][y] = elemento;		
	}
	
	public int casasJogadas(){
		int pm = 0;
		for(int i = 0; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				if(tab[i][j] != ' ') 
					pm ++;
			}
		}
		return pm;
	}

	public boolean empate(){
		return (casasJogadas() == 9 && vitoria() == 'N');
	}
		
	public char vitoria(){
		int x = 0;
		int o = 0;
		
		//Verifica coluna
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0; j < 3; j++){
				if(tab[i][j] == 'X') 
					x++;
				if(tab[i][j] == 'O') 
					o++;
			}
			
			if(x >= 3) 
				return 'X';
			else if(o >= 3) 
				return 'O';
			else 
				x = o = 0;
		}
		
		//Verifica linha
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0; j < 3; j++){
				if(tab[j][i] == 'X') 
					x++;
				if(tab[j][i] == 'O') 
					o++;
			}
			if(x >= 3) 
				return 'X';
			if(o >= 3) 
				return 'O';
			else 
				x = o = 0;
		}
		
		//Verifica diagonal
		for(int i = 0 ; i < 3 ; i++){
			if(tab[i][i] == 'X') 
				x++;
			if(tab[i][i] == 'O') 
				o++;
		}
		if(x >= 3) 
			return 'X';
		if(o >= 3) 
			return 'O';
		else 
			x = o = 0;
		
		//Verifica diagonal inversa
		for(int i = 0 ; i < 3 ; i++){
			if(tab[3-i-1][i] == 'X') 
				x++;
			if(tab[3-i-1][i] == 'O') 
				o++;
		}
		if(x >= 3) 
			return 'X';
		if(o >= 3) 
			return 'O';
		else 
			return 'N';
	}

	public String imprime() {
		String grelha = "";
		
		for (int i=0; i<3; i++){			
			for (int j=0; j<3; j++){
				grelha += "|";
				
				if(tab[i][j] == ' ')
					grelha += " ";
				else
					grelha += tab[i][j];
				
				if(j==2)
					grelha += "|";
			}				
				if(i!= 2)
					grelha += "\n";
		}
		return grelha;
	}	
}