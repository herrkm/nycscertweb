```java
/**
 * SuperArray by Breakout Room #9 July 8th, 2022
 * Greg Sciame
 * collaborators: Merieke Thomas, Kiana Herr, Moo Joon Park
 */

/**
   SKELETON
   SuperArray is a wrapper class for an array.

   Provides "pass-thru" accessibility to pre-existing array capabilities:
   - get/set by index
   - get length

   Adds functionality:
   - dynamic capacity
   - auto-grow capacity if necessary
*/

import java.io.*;
import java.util.*;

public class SuperArray
{
  /**
     SUBGOAL:
     declare instance vars
     ...and initialize?
  */


  //instance vars
  private int[] data;           // "interior"/"underlying" data container
  private int numberElements;   // number of "meaningful" elements


  // ~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~
  //overloaded constructor -- allows specification of initial capacity
  public SuperArray( int size )
  {
    //init underlying/inner storage of specified capacity
    this.data = new int[size];

    //init instance vars
    this.numberElements = 0;

  }

  //default constructor -- initializes capacity to 10
  public SuperArray()
  {
    //init underlying/inner storage of capacity 10
    this.data = new int [10];
    //init instance vars
    this.numberElements = 0;
    
  }

  // ~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~
  public void print()
  {
    for(int i=0; i < numberElements ;i++){
      System.out.println(this.data[i]);
    }
    
  }
  public void add( int value )
  {
    // test to see if we need to grow, then grow
      if(numberElements == data.length) {
        this.grow();
        /*
        int[] data2 = new int[data.length + 10];
        for(int i = 0; i < data.length; i++)
          {
            data2[i] = data[i];
          }
        data = data2;
          */      
      }     
    
 

    // add item
    data[numberElements] = value;

    // increment numberElements
    
    numberElements += 1;
  }//end add()


  public boolean isEmpty()
  {
    //return whether this SuperArray instance is empty
    if(numberElements == 0){
      return true;    
    } else {
      return false;
    }
      
    // you can also just type:
    //return(numberElements==0);
    //or
    //return numberElements == 0;
    //which do the same thing as the if(){}else{} statement
  }


  public int get(int index)
  {
    //return item at index
    /* YOUR SIMPLE+SMART CODE HERE */
    
    return data[index];
  }


  public String toString()
  {
    //return stringified version of this Object
    /* YOUR SIMPLE+SMART CODE HERE */
    String str = "";
    for(int i = 0; i < numberElements; i++){
      str = str + data[i] + " ";
    }
    return str;
  }//end toString()


  //return Stringified version of this Object,
  // with extra debugging info
  //(helper method for debugging/development phase)
  public String debug()
  {
    String s = "";
    s = "Size: " + this.data.length;
    s = s + " LastItem: " + numberElements + "  Data: ";
    for (int i = 0; i < numberElements; i++) {
      s = s + data[i] + ", ";
    }
    s = s + "\n";
    return s;
  }//end debug()


  public void remove(int index)
  {
    // shift items down to remove the item at index
        for(int i = index; i < numberElements - 1; i++){
      data[i] = data[i+1];
    }
    // subtract fom numElements;
   numberElements --;
    
    
  }


  public void add(int index, int value)
  {
    // see if there's enough room
    /* YOUR SIMPLE+SMART CODE HERE */
  if(index > numberElements){
    System.out.println("Not enough indeces...the array is unchanged.");
    
  } else {
            
    if(numberElements == data.length){
      this.grow();
    }
 for(int i = numberElements; i > index; i--){
   data[i] = data[i-1];
 }
    // shift elements toward the end of the array
    /* YOUR SIMPLE+SMART CODE HERE */

    // insert new element
    /* YOUR SIMPLE+SMART CODE HERE */
data[index] = value;
    // increment numElements
    /* YOUR SIMPLE+SMART CODE HERE */
    numberElements++;
     }
  }


  private void grow()
  {
    // create a new array with extra space
    // Q: How did you decide how much to increase capacity by?
    int[] data2 = new int[data.length + 10];

    // copy over all the elements from the old array to the new one    
    for(int i = 0; i < data.length; i++)
      {
        data2[i] = data[i];
      }

    // point data to the new array    
    data = data2;





    // Q: How does this look when illustrated using encapsulation diagram?
    /* YOUR SIMPLE+SMART CODE HERE */
  }//end grow()

}//end class
```
