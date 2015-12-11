import java.util.InputMismatchException;
import java.util.Scanner;
public class main {
	public static int ro, cl;
	public static Scanner input = new Scanner(System.in);
	public static char[][] board = new char[3][3];
	public static char turn = 'X';
	public static int chose;
	public static void main(String[] args) {
	boolean continueLoop = true;	
	boolean continuegame = true;
	
	do{
		startboardvalue();
		System.out.println("=============\n" +
							" TIC TAC TOE\n" +
						   "=============");
		Playboard();
		do{	
			try{
		System.out.println("1.Player vs Player\n2.Player vs Computer\n3.Computer vs Computer");
		
			chose = input.nextInt();
			if ( chose == 1)PVP();
			if ( chose == 2)PVC();
			if ( chose == 3)CVC();
			if ( chose >=1 && chose <=3)continueLoop = false;
			else{
			System.out.println("Only Accept 1-3");
			input.nextLine();
			}
			} catch(InputMismatchException inputMismatchException){
				System.err.printf("\nException: %s\n", inputMismatchException);
				input.nextLine();
				System.out.println("you must enter intergers 1-3, please try again:");
			
			}
		}while(continueLoop);
	
	System.out.println("Do you want to play again ?\n"
			+ "1.YES 2.NO ");
	int again = input.nextInt();
	if(again == 2)continuegame = false;
	}while (continuegame);
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
		boolean rloop = true;
		
		do{
			try{
		
			System.out.println("Input row    :");
			ro = input.nextInt() - 1;
			if (ro >= 0 && ro <=2)rloop = false;
			else {System.out.println("you must enter 1-3, please try again:");
			input.nextLine();
			}
			}catch(InputMismatchException inputMismatchException){System.err.printf("\nException: %s\n", inputMismatchException);
			input.nextLine();
			System.out.println("you must enter intergers 1-3, please try again:");
			
		}
		}
		while(rloop);
		return ro;
	}
	public static int  playercl(){
boolean cloop = true;
		
		do{
			try{
		
			System.out.println("Input column    :");
			cl = input.nextInt() - 1;
			if (cl >= 0 && cl <=2)cloop = false;
			else {System.out.println("you must enter 1-3, please try again:");
			input.nextLine();
			}
			}catch(InputMismatchException inputMismatchException){System.err.printf("\nException: %s\n", inputMismatchException);
			input.nextLine();
			System.out.println("you must enter intergers 1-3, please try again:");
			
		}
		}
		while(cloop);
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
	public static void PVC() {
		boolean playing = true;
		boolean samespotplayer = true;
		boolean samespotcomputer = true;
		while (playing){
			if (turn == 'X'){
			playerro();playercl();
			if ( board [ro][cl] == '_')
				board[ro][cl] = turn;
				else if ( board [ro][cl] != '_'){
				while(samespotplayer){
					System.out.println("Slot is taken , Pls choose another ");
					playerro();playercl();
					if ( board [ro][cl] == '_'){
						board[ro][cl] = turn;
						samespotplayer = false;
					}	
				}
				samespotplayer = true;
			}
			if (GameOver(ro,cl)){
				playing = false;
				System.out.println("Player "+ turn +" win!");
			}
			Playboard();
			
			if (turn == 'X')
				turn = 'O';
			else turn = 'X';	
			}
		if (turn == 'O'){
			computerro();computercl();
			if ( board [ro][cl] == '_')
				board[ro][cl] = turn;
				else if ( board [ro][cl] != '_'){
				while(samespotcomputer){
					computerro();computercl();
					if ( board [ro][cl] == '_'){
						board[ro][cl] = turn;
						samespotcomputer = false;
					}	
				}
				samespotcomputer =true;
			}
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