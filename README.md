# knightsTour
### java implementation of knight's tour

<p> In this project, the knight starts off at a position on a chessboard, and has 64 turns to move to each box on the board without repeating the steps. There are several billion solutions to the problem, of which about 122,000,000 have the knight finishing on the same square on which it begins. When this occurs the tour is said to be closed.</p>

<p>In my project, I've made a second 2d-array with all the possible directions that the knight can move to. Then I randomize the next step and check wether the position is safe (i.e. if it's within the chessboard and not previously occupied).</p>

<p>I've approached this problem with a simple backtracking solution. The program looks for eight possible directions for the knight's next move, checks each step with the isSafe function and then recursively calls itself from the next positon. In the condition when the knight has no possible moves left, it seeks backtracking and looks for further steps.</p>

<p>Even though the program successfully compiles and places all the moves in the order, I still wasn't able to place the last move at the origin. However, this program is a basic example for backtracking and recursive calls.</p> 
