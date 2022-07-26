title: Cgol.java
layout: template
filename: Cgol

```java
import java.io.*;
import java.util.*;

/**
 * Conway's Game of Life by Team AreWeSentientYet?
 * First Last
 * collaborators: 
Alise BraickF, Harrison Fung, Kiana Herr, Stacy Goldstein
 */

/**
   The Rules of Life:
   Survivals:
   * A living cell with 2 or 3 living neighbours will survive for the next generation.
   Deaths:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Births:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation.
*/

public class Cgol
{

  //create, initialize, and return  empty board (all cells dead) Dead cells denoted by '-'
  public static char[][] createNewBoard( int rows, int cols )
  {
    char[][] board = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j]= '-';
      }
    }
    return board;
  }

  
  //print the board to the terminal
  public static void printBoard( char[][] board )
  {
    for(int i = 0; i < board.length; i++){
      for( int j = 0; j < board[i].length; j++)
      {
          System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }


  //set cell (r,c) to val
  public static void setCell( char[][] board, int r, int c, char val )
  {
    board[r][c] = val;
  }


 

  //return number of living neigbours of board[r][c]
  public static int countNeighbours( char[][] board, int r, int c )
  {
    int row = board.length;
    int col = board[0].length;
    int count = 0;
    for (int i = Math.max(0, r - 1); i < row && i <= r + 1;  i++){
       for (int j = Math.max(0, c - 1); j < col && j <= c + 1 ; j++){
        if (!(i == r && j == c)){ //if not on the target cell
          //System.out.println("Row " + i + ", column " + j);
          if (board[i][j] != '-'){ //if cell is not a space (dead)
            count += 1;
          }
        }
      }
    }
    return count;
  }


  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell( char[][] board,int r, int c )
  {
    int liveNeighbors = countNeighbours(board, r, c);
    if (board[r][c] == 'X'){ //if cell is alive
      if (liveNeighbors == 2 || liveNeighbors == 3){ //and has 2 or 3 neighbors
        return 'X'; //it stays alive
      }
    }
    else { //if cell is dead
      if (liveNeighbors == 3){ //and has exactly 3 neighbors
        return 'X'; //it comes to life
      }
    }
  return '-';
  }


  //generate and return a new board representing next generation
  public static char[][] generateNextBoard( char[][] board )
  {
    char[][] nextBoard = new char[board.length][board[0].length];
    for (int i = 0; i < board.length; i++)
    {
      for (int j = 0; j < board[0].length; j++)
      {
        nextBoard[i][j] = getNextGenCell(board, i, j);
      } 
    }
    return nextBoard;
  }


  public static void main( String[] args )
  {
    
    char[][] board;
    board = createNewBoard(5,5);
    //board = createNewBoard(5,5);
    //breathe life into some cells:
    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, 'X');
    setCell(board, 1, 0, 'X');
    setCell(board, 2, 4, 'X');
    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    System.out.println("Gen X:");
    printBoard(board);

    System.out.println("Number of neighbors of cell at row 0 column 1:");
    System.out.println(countNeighbours(board, 0, 1));
    System.out.println("Next gen status of cell at row 0 column 0:");
    System.out.println(getNextGenCell(board, 0, 0)); //alive and should survive
    System.out.println("Next gen status of cell at row 1 column 1:");
    System.out.println(getNextGenCell(board, 1, 1)); //dead and should be born
    System.out.println("Next gen status of cell at row 3 column 3:");
    System.out.println(getNextGenCell(board, 3, 3)); //dead and should stay dead
    System.out.println("--------------------------\n\n");

    
    board = generateNextBoard(board);
    System.out.println("Gen X+1:");
    printBoard(board);
    System.out.println("--------------------------\n\n");

    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class, 
```
