---
title: SortSearch.java (animation in progress)
layout: template
filename: CSCI70300/SortSearchxtra
--- 

```java
import java.io.*;
import java.util.*;

/**
SortSearch.java
Owner: Théa W.
Collaborators: Adam P., Ben E., Kiana H.,
Group 5
Dates: 7/18/22, 7/19/22, 7/20/22
**/

/*
Sort Project:

Part 1:  (BASIC)
  1. Analyze the two constructors - try to figure out how they work.- DONE
  2. Compile and run the program (SortSearchDriver.java and SortSearch.java) and confirm
  the behavior of the constructors.- DONE
  
Part 2: (BASIC)
  1. Read the description of findSmallestIndex and complete the method.- DONE
  2. Uncomment the lines in SortSearchDriver to test.- DONE
  
Part 3: (INTERMEDIATE)
  1. Complete the sort method - read comments for description - DONE
  2. Uncomment the lines in SortSearchDriver to test. - DONE

Search Project:
  1. Complete the linear search (BASIC)
  2. Complete the binary search (Intermediate)
  3. Complete the recursive version of binary search (Advanced)
*/

public class SortSearch{

  private static final String whiteText = "\u001B[37m";
  private static final String redText = "\u001b[31m";
  private static final String greenText = "\u001b[32;1m";
  /* Sort project starts here */
  
  /* Instance Variables */
  private ArrayList<Integer> data;  // to store the data
  
  private Random r; //variable to hold a randomly generated object.

  private int size;
  
  public SortSearch()//constructor that has no parameters
  {

    data = new ArrayList<Integer>();//initializes the instance variable "data"
    size = 15;
    r = new Random();//initializes the instance variable "r".
    for (int i=0; i<15; i++) //default size is 15
    {
      data.add(r.nextInt(20)); //the parameter "20" fills with random values between 0 and 19
    }

  }
  
  public SortSearch(int size)//overloaded constructor that takes in an int "size"
  {
    data = new ArrayList<Integer>();//initializes the instance variable "data"
    this.size = size;

    // for (int i = 0 ; i < size; i++){
    //   data.add(i);
    // }
    r = new Random();//initializes the instance variable "r".
    for (int i=0; i<size; i++)//size is provided by the user through through the varialbe "size"
    {
      data.add(r.nextInt(20));//the parameter "20" fills with random values between 0 and 19
    }

  }

  /* Convenience function to get data out of the ArrayList from the driver */
  public int get(int index){
    return data.get(index);
  }



  //return size of ArrayList
  //helper method to simplify call of recursive binary search
  public int size() {
    return size;
  }

  /*
    return the index of the smallest data idem from index start to the end
    of the ArrayList. If there are multiple of the smallest value,
    return any of them.
    
    Example, if the arraylist has:
    5,3,10,6,8
    if start was 2 (start at index 2, value 10) then it would return 3
    which is the index of the value 6 which is the index with the
    smallest value from start to end
    On the otherh and, if start was 0, then the method would
    return 1 since the value 3 is in index 1 and that is the smallest.
    
  */
  public int findSmallestIndex(int start)
  {
    int smallIndex = start;
    for(int i = start; i < size; i++)
    {
      if(data.get(i) < data.get(smallIndex))
      {
        smallIndex = i;
      }
    }	//ends the for loop
    return smallIndex;
  }


  /**
     Implement the selection sort algorithm by sorting the ArrayList
     data in place.
     Algorithm:
     Loop a variable that represents the ArrayList index from
     0 to the end of the ArrayList.
       For each index, find the smallest from that Location
 to the end of the array and swap it with that index.
 
     
  */
  public void sort()
  {
    for(int i = 0; i < size; i++)
    {
      int smallest = findSmallestIndex(i); //we call the method "findSmallestIndex, which finds the index that contains the smallest element(value) and stores the index (#) of that smallest element in the variable "smallest" which outside the arraylist.
      
      int temp = data.get(smallest); //takes the value of the element in smallest and saves it to a temporary variable, outside the arraylist, called "temp".
      
      data.set(smallest,data.get(i)); //gets the value of the element at position "i" and moves it (overwrites the data) at smallest.
     
      data.set(i,temp); //sets the value of the element at index i to the value currently in the variable temp.
      
    } // ends the for loop


  } // ends the sort method



  /* Search project starts here */
    
  /**
     performs a linear search. Returns the index of the first occurence of
     value in the ArrayList data or -1 if not found.
     This works by starting at the first element and searching one element at a time 
     until either the element is found or you've looked at all the elements.
     This algorithm works on any ArrayList.
  */
  public int linearSearch(int value)
  {
    for(int i = 0; i < size; i++)
    {
      if (data.get(i) == value)
      {
        return i;
      }
      
    } // ends the for loop


    return -1; // return if not found
  }


// ALL code below this point completed with:
// Group 13
// Kiana Herr, Ed Hawkins, David Moste, Amanda Lee

  
  /**
     Implement a binary search as specified by the comments
     
     This algorithm only works on sorted ArrayLists.
  */
  public int binarySearch(int value){

  // create assign variables  representing the high, low and middle indices 
    int low = 0;
    int high = size - 1;
    int middle = (low + high) / 2;
  // while we're not done:
  //   if the item is at data.get(middle), return middle
    while (low <= high){
      if (data.get(middle) == value){
        return middle;
      }
      //   otherwise, update high, low, and middle
      else if (value > data.get(middle)){
        low = middle + 1;
        middle = (low + high) / 2;
        // high is unchanged
      } else {
        high = middle - 1;
        middle = (low + high) / 2;
        // low is unchanged
      }
    }
    return -1;
  }
  
  /**
     Implement a RECURSIVE binary search as specified by the comments
     
     This algorithm only works on sorted ArrayLists.
  */

  public int binarySearchRecursive(int value, int lowIndex, int highIndex)  {
    int middle = (lowIndex + highIndex) / 2;
    if (lowIndex > highIndex ){
      return -1;
    } else {
      if (data.get(middle) == value){
        return middle;
      } else if (value > data.get(middle)){
        return binarySearchRecursive(value, middle + 1, highIndex);
      } else {
        return binarySearchRecursive(value, lowIndex, middle - 1);
      }
    }
    
  }
  

  public String toString(){
    return ""+data;
  }


  public void builtinSort(){
    Collections.sort(data);

  }


  //Animation of binary search!
  public void binarySearchAnimated(int value){
    //build board for animation
    System.out.print("\033[1;1H\033[2J"); //clear screen, place cursor at top left
    System.out.println("Searching for " + value + ":");
    String[][] searchBoard = new String[3][size];
    for (int i = 0; i < size; i++){
      searchBoard[0][i] = (data.get(i) < 10) ? "0" + String.valueOf(data.get(i)) : String.valueOf(data.get(i));
      searchBoard[1][i] = " ";
      searchBoard[2][i] = " ";
    }
    // create assign variables  representing the high, low and middle indices. Set label strings into rows 1 and 2.
    int low = 0;
    int high = size - 1;
    int middle = (low + high) / 2;
    updateBoard(searchBoard, low, middle, high);
    int step = 0;
    System.out.println("Step 0");
    printBoard(searchBoard);

    
  // while we're not done:
  //   if the item is at data.get(middle), return middle
    while (low <= high){
      step++;
      delay(3000);
      System.out.print("\033[2;1H"); //places cursor below heading
      System.out.println("Step " + step);
      if (data.get(middle) == value){
        searchBoard[1][middle] = greenText + "⭱" + whiteText;
        printBoard(searchBoard);
        System.out.print("\033[?25h"); //show the cursor
        return;
      }
      //   otherwise, update high, low, and middle
      else if (value > data.get(middle)){
        low = middle + 1;
        middle = (low + high) / 2;
        updateBoard(searchBoard, low, middle, high);
        printBoard(searchBoard);
        // high is unchanged
      } else {
        high = middle - 1;
        middle = (low + high) / 2;
        updateBoard(searchBoard, low, middle, high);
        printBoard(searchBoard);
        // low is unchanged
      }
    }
    System.out.print("\033[?25h"); //show the cursor
    return;
  }


  public static void printBoard(String board[][]){
    for (String[] item : board){
      for (String element : item){
        System.out.print(element + " ");
      }
      System.out.println();
    }
  }

  public static void updateBoard(String board[][], int lowIndex, int middleIndex, int highIndex){
    for (int j = 0; j < board[0].length; j++){
      if (j < lowIndex || j > highIndex){
        board[0][j] = redText + board[0][j] + whiteText;
      }
    }
    for (int i = 0; i < board[0].length; i++){
      board[1][i] = "  ";
      board[2][i] = "  ";
    }
    if (lowIndex != middleIndex){
      board[1][lowIndex] = " ↑";
      board[2][lowIndex] = " L";

      board[1][middleIndex] = " ↑";
      board[2][middleIndex] = " M";

      board[1][highIndex] = " ↑";
      board[2][highIndex] = " H";
    } else {
      board[1][lowIndex - 1] = " ⬈";
      board[2][lowIndex - 1] = " L";

      board[1][middleIndex] = " ↑";
      board[2][middleIndex] = " M";
      
      if (highIndex == middleIndex){
        if (highIndex != board[0].length - 1){
          board[1][highIndex] = "⬉ ";
          board[2][highIndex] = "H ";
        } else {
          board[1][middleIndex] = "↑⬉";
          board[2][middleIndex] = "MH";
        }
      } else {
        
      }
      
    }
     
    
    
    

    
  }
  
  public static void delay(int n)
  {
    try {
      Thread.sleep(n);
    }
    catch(InterruptedException e) {}
  }

  

  
  /*
public static void main( String[] args )
  {
    //clear the shell and hide the cursor
    System.out.print("\033[2J\033[?25l");

    //create the board
    char[][] board;
    board = createNewBoard(25,25);
    
    //breathe life into some cells
    setBoard(board, 20);

    //generate and animate the generations
    for(int i = 0; i < 101; i++){
      animate(board, i);
      board = generateNextBoard(board);
    }

    //show the cursor
    System.out.print("\033[?25h");
    */
  // }//end main()

}//end class
``` 
