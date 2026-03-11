import java.util.Scanner;

class TicTacToe 
{
    public static void main(String[] args) 
	{
        char[][] board = 
		{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        
        char player = 'X';
        boolean gameFinished = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (!gameFinished) 
		{
            drawBoard(board);
            System.out.println("Player " + player + ", enter your move (row and column: 0, 1, or 2): ");
            
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') 
			{
                board[row][col] = player;
                gameFinished = checkWin(board, player);
                
                if (gameFinished) 
				{
                    drawBoard(board);
                    System.out.println("Player " + player + " wins!");
                } 
				else if (isBoardFull(board)) 
				{
                    drawBoard(board);
                    System.out.println("It's a draw!");
                    gameFinished = true;
                } 
				else 
				{
                    player = (player == 'X') ? 'O' : 'X';
                }
            } 
			else 
			{
                System.out.println("This move is invalid. Try again.");
            }
        }
        scanner.close();
    }

    public static void drawBoard(char[][] board) 
	{
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) 
		{
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) 
			{
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    public static boolean checkWin(char[][] board, char player) 
	{
        
        for (int i = 0; i < 3; i++) 
		{
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) 
			{
                return true;
            }
        }
        
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static boolean isBoardFull(char[][] board) 
	{
        for (int i = 0; i < 3; i++) 
		{
            for (int j = 0; j < 3; j++) 
			{
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
}