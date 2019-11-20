class knightProject {
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

    public static boolean secMain(int x, int y, int moveid,
                               int board[][], int[][] dir) {
        int k, i, j;
        if (moveid > 64)
            return true;
        for (k = 0; k < 8; k++) {
            i = x + dir[k][0];
            j = y + dir[k][1];
            if (isSafe(board, i, j)) {
                board[i][j] = moveid;
                if (secMain(i, j, moveid + 1,
                        board, dir))
                    return true;
                else
                    board[i][j] = -1;// backtracking 
            }
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

} 