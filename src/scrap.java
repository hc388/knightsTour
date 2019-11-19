import java.util.Random;
import java.util.concurrent.TimeUnit;

public class scrap {
    public static int[][] dir = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    public static Random rand = new Random();
    public static int n = 0;
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        int i = 3;
        int j = 3;
        while (n < 24) {
            if (gameOver(board, i, j)) {
                break;
            }
            int tempi = i;
            int tempj = j;

            int r = rand.nextInt(8);
            i += dir[r][0];
            j += dir[r][1];
            System.out.println("R is: " + r + " I is: " + i + " j is: " + j);
            if (isSafe(board, i, j)) {
                tempi = i;
                tempj = j;
                board[i][j] = 1;
                printboard(board);
                System.out.println("Next Step:");

            } else {
                i = tempi;
                j = tempj;
                continue;
            }
        }
    }







    public static boolean gameOver(int[][] board, int i, int j) {
        if (
                isSafe(board,i-2,j+1)||
                        isSafe(board,i-1,j+2)||
                        isSafe(board,i+1,j+1)||
                        isSafe(board,i+2,j+1)||
                        isSafe(board,i+2,j-1)||
                        isSafe(board,i+1,j-2)||
                        isSafe(board,i-1,j-2)||
                        isSafe(board,i-2,j-1)
        )
            return false;
        return true;
    }

    public static boolean isSafe(int[][] board, int i, int j) {
        if (i < 5 && j < 5 && i>=0 && j>= 0) {
            if (board[i][j] == 0)
                return true;
        }
        return false;
    }

    public static void printboard(int[][] board){
        for(int i =0; i<5;i++){
            for(int j = 0;j<5;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
}
