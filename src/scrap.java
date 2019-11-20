import java.util.Random;
import java.util.concurrent.TimeUnit;

public class scrap {
    public static int[][] dir = new int[][]{{-1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    public static int[] xcoor = new int[20000];
    public static int[] ycoor = new int[20000];
    public static Random rand = new Random();
    public static int n = 0;
    public static int count = 0;
    public static int tempi = 0;
    public static int tempj = 0;

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};
        int i = 0;
        int j = 0;
        if (kindaMain(board, i, j)) {
            printboard(board);
        } else
            System.out.println("Solution not found.");

    }

    public static boolean kindaMain(int[][] board, int i, int j) {
        if (n == 64) {
            return true;
        }
        xcoor[count] = i;
        ycoor[count] = j;
        /*if (gameOver(board, i, j)) {
            n -= 2;
            board[xcoor[count]][ycoor[count]] = 0;

        }
        */
        tempi = i;
        tempj = j;

        //int r = rand.nextInt(8);
        for(int b = 0; b<8 ; b++){
        i += dir[b][0];
        j += dir[b][1];
        System.out.println("R is: " + b + " I is: " + i + " j is: " + j);
        if (isSafe(board, i, j)) {
            count++;

            n++;
            tempi = i;
            tempj = j;
            board[i][j] = n;
            printboard(board);
            System.out.println("Next Step:");
            if(kindaMain(board, i, j))
                return true;
            else {
                n -= 2;
                board[xcoor[count]][ycoor[count]] = 0;

                //board[i][j] = 0;
                //return kindaMain(board, tempi, tempj);
            }


        }
        else{
            i = tempi;
            j = tempj;
        }
        }
                return false;
        }




    public static boolean gameOver(int[][] board, int i, int j) {
        if (
                isSafe(board, i - 2, j + 1) ||
                        isSafe(board, i - 1, j + 2) ||
                        isSafe(board, i + 1, j + 1) ||
                        isSafe(board, i + 2, j + 1) ||
                        isSafe(board, i + 2, j - 1) ||
                        isSafe(board, i + 1, j - 2) ||
                        isSafe(board, i - 1, j - 2) ||
                        isSafe(board, i - 2, j - 1)
        )
            return false;
        return true;
    }

    public static boolean isSafe(int[][] board, int i, int j) {
        if (i < 8 && j < 8 && i >= 0 && j >= 0) {
            if (board[i][j] == 0)
                return true;
        }
        return false;
    }

    public static void printboard(int[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static boolean containsZero(int[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j] == 0)
                    return true;
                else
                    continue;
            }
        }
        return false;
    }
}
