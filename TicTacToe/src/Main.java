import java.util.Scanner;
public class Main {
	public static int ro, cl;
	public static Scanner input = new Scanner(System.in);
	public static char[][] board = new char[3][3];
	public static char turn = 'X';
	
	public static void main(String[] args) {
		startboardvalue();
		play();
	}
	
	public static void startboardvalue(){
		for (int i = 0 ; i < 3; i++) {
			for (int j = 0 ; j < 3;j++){
				board [i][j] = '_';
			}
		}
	}
	public static void play(){
		boolean playing = true;
		
		while (playing) {
			System.out.println("Input row    :");
			ro = input.nextInt() - 1;
			System.out.println("Input column :");
			cl = input.nextInt() - 1;
			
			board[ro][cl] = turn;
			System.out.println(board [ro][cl]); // debugg
			
			if (GameOver(ro,cl)){
				playing = false;
				System.out.println("Player "+ turn +" win!");
			}
			Playboard();
			if (turn == 'X')
				turn = 'O';
			else turn = 'X';	
		}
	}
	
	
	public static void Playboard(){
		for (int i = 0 ; i < 3; i++) {
			System.out.println();
			for (int j = 0 ; j < 3; j++) {
				if (j == 0 )
					System.out.print ("| ");
				System.out.print(board[i][j] + " | " ) ;
			}
		}
		System.out.println();
	}
	
	public static boolean GameOver ( int rowmove, int clumove){
		if (board[0][clumove]==board[1][clumove]&& board [0][clumove]==board [2][clumove])
			return true;
		if (board[rowmove][0]==board[rowmove][1]&& board [rowmove][0]==board [rowmove][2])
			return true;
		if (board[0][0] == board [1][1] && board[0][0]== board [2][2]&&board[1][1]!='_')
			return true;
		if (board[0][2] == board [1][1] && board[0][2]== board [2][0]&&board[1][1]!='_')
			return true;
		return false;
	}
}
