/*
Problem: 1275. Find Winner on a Tic Tac Toe Game

Description: Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

- Players take turns placing characters into empty squares ' '.
- The first player A always places 'X' characters, while the second player B always places 'O' characters.
- 'X' and 'O' characters are always placed into empty squares, never on filled ones.
- The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
- The game also ends if all squares are non-empty.
- No more moves can be played if the game is over.

Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on
grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw".
If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty,
and A will play first.
 */

public class WinnerTicTacToe {

    public static char checkWin(char[][] game) {
        for(int x=0; x<3; x++) {
            boolean findMove = false;
            int count = 0;
            char player = '-';
            // Check row
            for(int j=0; j<3; j++) {
                if(game[x][j] != '-' && !findMove) {
                    player = game[x][j];
                    findMove = true;
                    count++;
                } else if(findMove) {
                    if(game[x][j] == player) {
                        count++;
                    }
                }
            }

            if(count == 3) return player;

            // Check column
            findMove = false;
            count = 0;
            player = '-';
            for(int i=0; i<3; i++) {
                if(game[i][x] != '-' && !findMove) {
                    player = game[i][x];
                    findMove = true;
                    count++;
                } else if(findMove) {
                    if(game[i][x] == player) {
                        count++;
                    }
                }
            }

            if(count == 3) return player;
        }

        // Check diagonals
        boolean findMove = false;
        int count = 0;
        char player = '-';

        for(int d=0; d<3; d++) {
            if(game[d][d] != '-' && !findMove) {
                player = game[d][d];
                findMove = true;
                count++;
            } else if(findMove) {
                if(game[d][d] == player) {
                    count++;
                }
            }
        }

        if(count == 3) return player;

        findMove = false;
        count = 0;
        player = '-';
        for(int d=0; d<3; d++) {
            int ds = 2-d;
            if(game[d][ds] != '-' && !findMove) {
                player = game[d][ds];
                findMove = true;
                count++;
            } else if(findMove) {
                if(game[d][ds] == player) {
                    count++;
                }
            }
        }

        if(count == 3) return player;

        return '-';
    }

    public String tictactoe(int[][] moves) {
        char[][] game = new char[3][3];
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                game[i][j] = '-';

        // First player A -> X; Second player B -> O
        boolean isFirstTime = true;
        int countPlays = 0;
        for (int[] move : moves) {
            if (isFirstTime) {
                game[move[0]][move[1]] = 'X';
                countPlays++;
            } else {
                game[move[0]][move[1]] = 'O';
            }

            isFirstTime = !isFirstTime;
        }

        char result = checkWin(game);

        if(result == 'X') return "A";
        else if(result == 'O') return  "B";
        else return (moves.length < 9 ? "Pending" : "Draw");
    }
}
