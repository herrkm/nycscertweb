# Welcome to Kiana Herr's website!

## CSCI 70900: Programming in a High Level Language

  |Course Topic|Files|
  |------------|-----|
  |Conditional Logic|[Nim.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/Nim.java)|
  |1D Arrays|[ArrayPractice.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/ArrayPractice.java)|
  |2D Arrays|[Array2DPractice.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/Array2DPractice.java)<br />[Cgol.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/Cgol.java)|
  |Recursion|[Fence.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/Fence.java)<br />[Fib.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/Fib.java)<br />[Reverser.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/Reverser.java)<br />[BinSearch.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/BinSearch.java)<br />|
  |Classes & Objects|[Time.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/Time.java)<br />[Rational.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/Rational.java)<br />[SuperArray.java](https://github.com/herrkm/nycscertweb/blob/68a0e2b37a2fb35ac7585faf4a01b657cf393f3f/CSCI70900/SuperArray.java)<br />|
  
  Code sample (from Rational.java):
  ```{java}
  // multiply
  // takes a Rational parameter and multiplies it by this Rational
  // does not return a value
  // modifies this object
  // does not modify input
  // need not reduce
  public void multiply( Rational r )
  {
    //multiply numerator by r's numerator and denominator by r's denominator
    this._numerator *= r._numerator;
    this._denominator *= r._denominator;
    this.reduce();
  }


  // divide
  // same as multiply, except operation is division
  public void divide( Rational r )
  {
    //if r's numerator is 0, then multiplying by the reciprocal will produce a denominator of 0
    if (r._numerator == 0){
      System.out.println("Error: divide by 0. Value is still " + this);
    }
    else {
      //multiply this fraction by reciprocal of r
      this._numerator *= r._denominator;
      this._denominator *= r._numerator;
      this.reduce();
    }
  }
  ```
  
## CSCI 70300: Data Structures in a High Level Language

  |Course Topic|Files|
  |------------|-----|
  |Array Lists|AlPractice.java|
  |Linked Lists|Node.java<br />pointers.draw<br />LinkedList.java<br />add.draw|
  |Sorting|SortSearch.java<br />SortSearch.java (extra - animation in progress)|
  
  Code sample (from LinkedList.java):
  ```{java}
  /**
  Returns the index (location) of the first node in the list
  that contains value.

  Example:
  Given the list:
  "a"->"b"->"c"->"d"->"e"
  indexOf("d") would return 3 since "d" is at location 3.

  */
  public int indexOf(String value){
    Node walker = head;
    for (int i = 0; walker != null; i++){
      //if current data is value, then return current index, otherwise go to next node
      if (walker.getData() == value){
        return i;
        
      } else {
        
        walker = walker.getNext();
      }
    }
    //if not found, return -1
    System.out.println(value + " not found in list. Returning -1.");
    return -1;
  }
  ```


## SEDC 71900: Methods for Teaching Computer Science I

  |Course Topic|Files|
  |------------|-----|
  |Live Coding|02_livecode_JAVA.java|
  |Tracing|03_trace.txt|
  |Unplugged Activities|04_unplugged.md|
  |Scaffolding|05_scaffold_activity.java<br />05_scaffold_solution.java|
  
  
  Code sample (from 05_scaffold_activity.java):
  ```{java}
  import java.util.*;
import java.io.*;

public class scaffold_activity
{
  // printArray: BASIC
  // Prints each element of an array on one line, followed by a space.
  // Example:
  // int[] array = new int[] {4, 5, 6};
  // printArray(array);
  
  // Result:
  // 4 5 6
  
  public static void printArray( int[] data )
  {
    // Create a for loop that will iterate through the entire array, from the first index to the last.
    // For each index, print the value followed by a space.

  }
  
  // prettyPrint: CHALLENGE
  // Prints each element of an array on one line, followed by a comma and a space. The entire array should be surrounded by square brackets.
  // Example:
  // int[] array = new int[] {4, 5, 6};
  // prettyPrint(array);
  
  // Result:
  // [4, 5, 6]
  
  public static void prettyPrint( int[] data)
  {
    // Print out something before your for loop

    // Create a for loop that will iterate through the entire array

    // Make sure your print has a closing bracket! There are multiple ways to do this.
    
  }

  public static void main( String[] args )
  {
    // Uncomment these lines to test printArray
    // int[] array = new int[]{1,5,2,7,5,8,5,12,19,5};
    // printArray(array);

    // Uncomment this line to test prettyPrint
    // prettyPrint(array);
  }
}
```

