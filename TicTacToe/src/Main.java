import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	public static int ro, cl;
	public static Scanner input = new Scanner(System.in);
	public static char[][] board = new char[3][3];
	public static char turn = 'X';
	public static int chose;
	public static void main(String[] args) {
	boolean continueLoop = true;	
		
		startboardvalue();
		System.out.println("=============\n" +
							" TIC TAC TOE\n" +
						   "=============");
		Playboard();
		do{	
			try{
		System.out.println("1.Player vs Player\n"+"2.Computer vs Computer");
		
			chose = input.nextInt();
			if (chose == 1) 
			PVP();
			if ( chose == 2)CVC();
			if (chose >=1 && chose <3)continueLoop = false;
			else{
			System.out.println("Only Accept 1-2");
			input.nextLine();
			}
			} catch(InputMismatchException inputMismatchException){
				System.err.printf("\nException: %s\n", inputMismatchException);
				input.nextLine();
				System.out.println("you must enter intergers 1-2, please try again:");
			
			}
		}while(continueLoop);
	}
	
	public static void startboardvalue(){
		for (int i = 0 ; i < 3; i++) {
			for (int j = 0 ; j < 3;j++){
				board [i][j] = '_';
			}
		}
	}
	
	public static int random(){
		int result = 0 + (int) (Math.random()*3);
		return result;
	}
	public static int computerro(){
		ro = random();
		return ro;
	}
		public static int computercl(){
		cl = random();
		return cl;	
	}
	public static int  playerro(){
		
		System.out.println("Input row    :");
		ro = input.nextInt() - 1;
		return ro;
	}
	public static int  playercl(){
		System.out.println("Input column :");
		cl = input.nextInt() - 1;
		return cl;
	}
	


	public static void PVP(){
		boolean playing = true;
		boolean samespot = true;
		while (playing) {
			playerro();playercl();
			
			
			if ( board [ro][cl] == '_')
				board[ro][cl] = turn;
				else if ( board [ro][cl] != '_'){
					while(samespot){
						System.out.println("Slot is taken , Pls choose another ");
						playerro();playercl();
						if ( board [ro][cl] == '_'){
							board[ro][cl] = turn;
							samespot = false;
						}	
					}
				samespot =true;
					
				}
			//System.out.println(board [ro][cl]); // debugg
			
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
	
	public static void CVC(){
	boolean playing = true;
	boolean samespot = true;	
		while (playing) {
		computerro();computercl();
			
			
			if ( board [ro][cl] == '_')
			board[ro][cl] = turn;
			else if ( board [ro][cl] != '_'){
				while(samespot){
					computerro();computercl();
					if ( board [ro][cl] == '_'){
						board[ro][cl] = turn;
						samespot = false;
					}	
				}
			samespot =true;
			}
			
			//System.out.println(board [ro][cl]); // debugg
			
			if (GameOver(ro,cl)){
				playing = false;
				System.out.println("Player "+ turn +" win!");
			}
			System.out.println("Computer play "+turn );
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