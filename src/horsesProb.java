import java.util.Random;

public class horsesProb {
    public static int[][] dir = new int[][]{{-1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    public static void main(String args[]) {
        kindaMain();
    }
    public static boolean kindaMain() {
        int[][] board = {{-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1}};

        if (!secMain(0, 0, 1, board, dir)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printboard(board);

        return true;
    }

    public static boolean secMain(int x, int y, int movei,
                                  int board[][], int[][] dir) {
        Random rand = new Random();
        int k, i, j;
        if (movei > 64)
            return true;
        for (k = 0; k < 8; k++) {
            int[] tab = new int[8];
            int r = rand.nextInt(8);
            if (!contains(tab, r)) {
                tab[tab.length] = r;
                i = x + dir[r][0];
                j = y + dir[r][1];
                if (isSafe(board, i, j)) {
                    board[i][j] = movei;
                    if (secMain(i, j, movei + 1,
                            board, dir))
                        return true;
                    else
                        board[i][j] = -1;// backtracking
                }
            }
            else
                continue;
        }

        return false;
    }
    public static boolean isSafe(int[][] board, int i, int j) {
        if (i < 8 && j < 8 && i >= 0 && j >= 0) {
            if (board[i][j] == -1)
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
    public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }

}