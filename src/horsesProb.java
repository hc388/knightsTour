import java.util.Random;

public class horsesProb {
    public static int n = 0;
    public static int[][] dir = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    public static Random rand = new Random();


    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};


        int[][] board2 = {{0, -4, 0, -1, 0},
                {-5, 0, 0, 0, 1},
                {0, 0, 10, 0, 0},
                {-1, 0, 0, 0, 3},
                {0, 1, 0, 3, 0}};

        int x = 3;
        int y = 2;
        //System.out.println(board[1][0]);
        /*
        System.out.println(board[x-1][y-2]);
        System.out.println(board[x+1][y-2]);
        System.out.println(board[x+2][y-1]);
        System.out.println(board[x-2][y+1]);
        System.out.println(board[x+2][y+1]);
        System.out.println(board[x-1][y+2]);
        System.out.println(board[x+1][y+2]);*/
        //System.out.println(board[x-2][y-1]);

        //realMain(board, 2, 2);

        if(secMain(board,x,y)){
            for(int i = 0; i<5;i++){
                for(int j = 0; j<5; j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println("\n");
            }
        }
        else {
            System.out.println("Solution not found.");
            for(int i = 0; i<5;i++){
                for(int j = 0; j<5; j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println("\n");
            }
        }
        }

        //if realmain returns true, print the board. if it returns false, then print no moves found.

    public static boolean isSafe(int[][] board, int i, int j) {
        if (i < 5 && j < 5 && i>=0 && j>= 0) {
            if (board[i][j] == 0)
                return true;
        }
        return false;
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


    public static boolean secMain(int[][] board, int x, int y) {

        if (n == 23) {
            return true;
        } else {



            int r = rand.nextInt(8);
            int i = x + dir[r][0];
            int j = y + dir[r][1];

            if (gameOver(board, i, j))
                return secMain(board,x,y);

            if (isSafe(board, i, j)) {
                board[i][j] = 1;
                n++;
                return secMain(board,i,j);

            }
            else{
                //return secMain(board,x,y);
                return false;
            }
        }
    }


    public static boolean realMain(int[][] board, int x, int y) {

            //System.out.println(dir[2][0]);
            //System.out.println(dir[2][1]);

            //System.out.println(board[x][y]);
        /*for(int i = 0; i<30;i++){
            int r = rand.nextInt(8);
            //System.out.print(r);

            System.out.println(board[x+dir[r][0]][y+dir[r][1]]);
        }*/
            //System.out.println(board[x+dir[2][0]][y+dir[2][1]]);
            //System.out.println(board[x+dir[2][0]][y+dir[2][1]]);




            int count = 0;
            if (isSafe(board, x, y)) {
                board[x][y] = 1;
                n++;
                //return realMain(board, i, j);
                return true;


            }
            else
                return false;
                //return realMain(board,x,y);

        }
    }

