public class Jogada {
	private int x;	//posicao x
	private int y;	//posicao y
	private int n;	//numero de nos

	Jogada(int x, int y){
		this.x = x;
		this.y = y;
	}

	Jogada(int x, int y, int n){
		this.x = x;
		this.y = y;
		this.n = n;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getN(){
		return n;
	}
}
