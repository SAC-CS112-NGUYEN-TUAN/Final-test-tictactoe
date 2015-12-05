import java.util.Scanner;
public class Main {
	static int row, clu;
	static Scanner input = new Scanner(System.in);
	static char [] [] board = new char [3][3];
	static char turn = 'x';
	
	public static void main(String[] args) {
		for (int i = 0 ; i < 3; i++) {
			for (int j = 0 ; j < 3;j++){
				board [i][j] = '_';
			}
		}
		Playboard();
		play();
	}
	
	public static void play(){
		boolean playing = true;
		while (playing) {
			row = input.nextInt() -1;
			clu = input.nextInt() -1;
			board[row][clu] = turn;
			
			if (turn == 'x')
				turn = 'o';
				else turn = 'x';	
		}
	}
	
	
	public static void Playboard(){
		for (int i = 0 ; i < 3; i++) {
			System.out.println();
			for (int j = 0 ; j < 3; j++) {
				if (j == 0 )
					System.out.print ("|");
				System.out.print(board[1][j] + "|" ) ;
			}
		}
		System.out.println();
	}
	
	public boolean GameOver ( int rowmove, int clumove){
		
		return false;
	}
}
