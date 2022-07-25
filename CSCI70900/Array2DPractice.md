```java
import java.io.*;
import java.util.*;

/**
 * Array2DPractice by Team LucidThinkeren
 * Kiana Herr
 * collaborators: Yanique Sears, Jenna Lin, Nicole Cojuangco
 */

/*********************************************
INSTRUCTIONS:

Place this file in a folder named programming/3/.

This file contains the following completed method. Use it as a model to help you with the other methods:

   - buildBoard

This file also contains stubs (empty methods) for the followingmethods (split into 3 levels):

   Basic level (complete all):
   - printBoard *
   - copyBoard *

Intermediate level (complete Basic methods plus this method):
   - explodeSquare *

Advanced level (complete Basic + Intermediate + these two methods):
   - explodeAllChar *
   - downString

The routines with the * will be particularly helpful for the Conway's Game of Life project that you'll work on after this one.
**********************************************/


/**
creates and returns a 2D array of size rowsxcols chars. All elements in the 2D array will be set to the char value.

Ex: buildBoard(3,4,'x') will return this 2D array:
   xxxx
   xxxx
   xxxx

Use this completed method as an example to help you with some of the other methods.
*/

public class Array2DPractice
{
  public static char[][] buildBoard( int rows, int cols, char value )
  {
    char[][] board = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j]=value;
      }
    }
    return board;
  }

  /**
     pretty prints a 2D array of characters

     This should print the array as a grid
  */
  public static void printBoard( char[][] board )
  {
    for (int i = 0; i < board.length; i++)
    {
      for (int j = 0; j < board[i].length; j++)
      {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
     Parameters:
     board - a 2D array of char
     row - the row you want to set
     value - the value to set all the elements in row

     Returns:
     Nothing

     Change the 2D array board so that all the elements in the
     specified row are set to value.

     Ex: Given array:
     xxxx
     xxxx
     xxxx
     xxxx

     setRow(board,2,'@') will change board to
     xxxx
     xxxx
     @@@@
     xxxx
  */
  public static void setRow( char[][] board, int row, char value )
  {
    for (int i = 0; i < board[row].length; i++)
    {
      board[row][i] = value;
    }
  }


  /**
     creates and returns a new 2D array of char the same size as
     original and copies all the elements
  */
  public static char[][] copyBoard( char[][] original )
  {
    char [][] duplicateBoard = new char[original.length][original[0].length];

    for (int i = 0; i < original.length; i++)
    {
        for (int j = 0; j < original[i].length; j++)
        {
            duplicateBoard[i][j] = original[i][j];
        }
    }

    return duplicateBoard;
  }


  /**
     Parameters:
     board - a 2D array of char
     row,col - ints specifying a location in board

     Returns:
     nothing

     A location in a 2D array can be though of as having 8
     neighbors.  In the below 2D array, the neighbors of the element
     marked Q are the numbered elements.

     oooooo
     o123oo
     o4Q5oo
     o678oo
     oooooo

     This method should change all the neighbor cells (elements) to an X
     but not change the element at row,col

     Ex:
     Given the 2D array
     QQQQQ
     QQQQQ
     QQQQQ
     QQQQQ

     explodeSquare(board,1,1) will change the array to
     XXXQQ
     XQXQQ
     XXXQQ
     QQQQQ

     Note: Make sure to correctly handle the cases when you try
     to explode an element on the edges.
  */
  public static void explodeSquare( char[][] board, int row, int col )
  {
    for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, board.length - 1); i++) //start at index 0 or row - 1, whichever is larger; end at index row + 1 or length - 1, whichever is smaller. (Avoid out of bounds error)
    {
      for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, board[i].length); j++)
      {
          if (! (i == row && j == col))
          {
            board[i][j] = 'X';
          }
      }
    } 
      
  }

  /**
     This method will search through the 2D array board and it will
     explode each square that contains the char c (using the above
     definition of exploding).

     Example:

     Given the array
     qqzqq
     qqqqq
     qqqqq
     qqqqq
     qzqqq
     qqqqq
     qqqqz

     explodeAllchar(board,'z') will change board to:

     qXzXq
     qXXXq
     qqqqq
     XXXqq
     XzXqq
     XXXXX
     qqqXz
  */
  public static void explodeAllChar(char[][] board, char c)
  {
    int[][] coordinates = new int[board.length*board[0].length][2]; //create array with max possible elements x 2 to track coordinates of cells that match char c
    int coordCount = 0;
    //need to fill array with coordinates of target char. row in column 0, col in column 1
    for (int i = 0; i < board.length; i++)
      {
        for (int j = 0; j < board[i].length; j++)
          {
            if (board[i][j] == c)
            {
              coordinates[coordCount][0] = i;
              coordinates[coordCount][1] = j;
              coordCount += 1;
            }
          }
      }
    for (int i = 0; i<coordinates.length; i++) System.out.println(coordinates[i]);
    for (int row = 0; row < board.length; row++)
      {
        for (int col = 0; col < board[row].length; col++)
          {
            explodeSquare(board, row, col);
          }
      }
  }


  /**
     Parameters:
     board - a 2D array of char
     row,col - ints specifying a location in board
     word - a String that you want to insert into the board.

     This will insert the parameter word into board in the downward
     direction. See examples below

     Example:

     Given this array
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx

     downString(board,1,1,"Hello") will change board to:

     xxxxxx
     xHxxxx
     xExxxx
     xLxxxx
     xLxxxx
     xOxxxx
     xxxxxx

     Given the above array, downString(board,4,3,"World") will
     change board to:

     xxxxxx
     xHxxxx
     xExxxx
     xLxxxx
     xLxWxx
     xOxOxx
     xxxRxx

     Note that the method has to stop at the bottom of the array.
  */
  public static void downString( char[][] board, int row, int col, String word )
  {
    /* YOUR AWESOME CODE HERE */
  }


  public static void main( String[] args )
  {
    char[][] b = buildBoard(5,10,'z');
    /*
      Note, you can directly set elements in the board
      using array notation like b[3][2]='z' and you
      can use array notation to also access individual
      elements
    */
    System.out.println("Original board:");
    printBoard(b);
    System.out.println();
    
    System.out.println("Copy board and change line 2 elements to \'a\':");
    char[][] newBoard = copyBoard(b);
    setRow(newBoard, 2, 'a');
    printBoard(newBoard);
    System.out.println();
    
    System.out.println("Explode (1,2) and (4,8):");
    explodeSquare(newBoard, 1, 2);
    explodeSquare(newBoard, 4, 8);
    printBoard(newBoard);

    System.out.println("Copy original board and change some characters to \'a\'");
    char[][] testBoard = copyBoard(b);
    testBoard[2][1] = 'a';
    testBoard[0][4] = 'a';
    testBoard[1][3] = 'a';
    printBoard(testBoard);

    System.out.println("ExplodeAllChar with target char \'a\'");
    explodeAllChar(testBoard, 'a');
    printBoard(testBoard);
  }
}
```
