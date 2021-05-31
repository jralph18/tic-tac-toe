import java.util.Arrays;

public class TicTacToe
{
    // Instance Variables
    private char[][] board;
    private int turns;

    // Constructors
    public TicTacToe()
    {
        board = new char[3][3];
        turns = 0;

        for ( int r=0; r<3; r++ )
            for ( int c=0; c<3; c++ )
                board[r][c] = ' ';
    }

    // Accessor Methods

    public boolean isWinner( char p )
    {
        char[] winArr = {p, p, p};
        char[][] cols = {{board[0][0], board[1][0], board[2][0]}, {board[0][1], board[1][1], board[2][1]}, {board[0][2], board[1][2], board[2][2]}};
        char[][] diags = {{board[0][0], board[1][1], board[2][2]}, {board[0][2], board[1][1], board[2][0]}};

        if(Arrays.equals(board[0], winArr) || Arrays.equals(board[1], winArr) || Arrays.equals(board[2], winArr)) return true;
        if(Arrays.equals(cols[0], winArr) || Arrays.equals(cols[1], winArr) || Arrays.equals(cols[2], winArr)) return true;
        if(Arrays.equals(diags[0], winArr) || Arrays.equals(diags[1], winArr)) return true;
        return false;
    }

    private boolean allValuesTheSame(int startR, int startC, int dr, int dc) {
        char firstVal = board[startR][startC];
        if ( firstVal == ' ') return false;
        for( int i=1; i < 3; i++ ) {
            int r = startR + i*dr;
            int c = startC + i*dc;
            if (board[r][c] != firstVal) return false;
        }
        return true;
    }

    public boolean isFull()
    {
        for ( int r=0; r<3; r++ )
            for ( int c=0; c<3; c++ )
                if( board[r][c] == ' ' ) return false;
        return true;
    }

    public boolean isCat()
    {
        return isFull() && !isWinner('X') && !isWinner('O');
    }

    public boolean isValid( int r, int c )
    {
        if ( 0 <= r && r <= 2 && 0 <= c && c <= 2 )
            return true;
        else
            return false;
    }

    public int numTurns()
    {
        return turns;
    }

    public char playerAt( int r, int c )
    {
        if ( isValid(r,c) )
            return board[r][c];
        else
            return '@';
    }

    public void displayBoard()
    {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    public void playMove( char p, int r, int c )
    {
        if (playerAt(r, c) != ' ') {
            System.out.println("Invalid move");
        } else {
            board[r][c] = p;
            turns++;
        }
    }

}