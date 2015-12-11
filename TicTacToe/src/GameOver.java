
public class GameOver {
	public static char[][] board = new char[3][3];
	
	public static void startboardvalue(){
		
		for (int i = 0 ; i < 3; i++) {
			for (int j = 0 ; j < 3;j++){
				board [i][j] = '_';
			}
		}
	}
	public static void Playboard(){
		startboardvalue();
		for (int i = 0 ; i < 3; i++) {
			System.out.println();
			for (int j = 0 ; j < 3; j++) {
				if (j == 0 )
					System.out.print ("| ");
				System.out.print(board[i][j] + " | " ) ;
			}
		}
	}
	public static boolean GameOver ( int rowmove, int clumove){
		startboardvalue();
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
