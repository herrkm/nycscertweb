---
title: AlPractice.java
layout: template
filename: AlPractice
--- 

```java
import java.io.*;
import java.util.*;

/** Methods to write

Basic level:
------------
public static ArrayList<Integer> buildRandomList(int size, int maxval)
public static int sumOfList(ArrayList<Integer> dataList)

Intermediate level:
-------------------
public static void swapElements(ArrayList<Integer> dataList, int indexA,int indexB)
public static void removeValue(ArrayList<Integer> dataList, int valueToRemove)

Advanced level:
-------------------
public static ArrayList<Integer> sumLists(ArrayList<Integer>ListA,ArrayList<Integer>ListB)
public static ArrayList<Integer> zipLists(ArrayList<Integer>ListA,ArrayList<Integer>ListB)
*/


public class AlPractice{

  /**
  Parameters:
  - size - an integer representing how many items to add to the list
  - maxval - the largest value to store in the list
  Preconditions:
  - size >= 0
  - maxVal > 0
  Returns:
  - A new ArrayList of Integers with each value being a random
    number between 0 and maxval (not including maxval).
  */
  public static ArrayList<Integer> buildRandomList(int size, int maxval){
    //create new ArrayList object called randomList
    ArrayList <Integer> randomList = new ArrayList <Integer> (size);
    //create new Random object to generate random values
    Random r = new Random();
    
    for (int i = 0; i < size; i++){
      //use .add method to place a random value in each element of randomList
      randomList.add(r.nextInt(maxval));
    }
        
    return randomList;
  }

  /**
  Parameters:
  - dataList - an ArrayList of integer values.
  Returns:
  - The sum of all of the elements of the ArrayList.
  */
  public static int sumOfList(ArrayList<Integer> dataList){
    int listSum = 0;
      for (int i = 0; i < dataList.size(); i++){
        listSum += dataList.get(i);
      }
    return listSum;
  }

  /**
  Parameters:
  - dataList - an ArrayList of Integers
  - index1, index2 - the two locations to swap.
  Preconditions:
  - index1 and index2 are valid indecies of dataList
  Postconditions:
  - The ArrayList is modified such that
    The value that was in dataList[index1] is now in dataList[index2], and
    the value  that was in dataList[index2] is now in dataList[index1].
  - No other values should be modified.
  */
  public static void swapElements(ArrayList<Integer> dataList, int index1,int index2){
    //hold value at index1
    int temp = dataList.get(index1);
    //set value at index1 to value at index2
    dataList.set(index1, dataList.get(index2));
    //set value at index2 to held value
    dataList.set(index2, temp);
  }

  /**
  Parameters:
  - dataList - an AraryList of Integers
  - valueToRemove - the value to remove
  Postconditions:
  - The dataList is modified such that all occurances of valueToRemove are removed.
  */
  public static void removeValue(ArrayList<Integer> dataList, int valueToRemove){
    //define new Integer object so I can use remove by value
    Integer temp = new Integer(valueToRemove);
    for(int i = 0; i < dataList.size(); i++){
      //remove first instance of the target value
      dataList.remove(temp);
    }

  }


  /**
  Parameters:
  - ListA,ListB - ArrayLists of integer values.
  Preconditions:
  - ListA and ListB have equal lengths.
  Returns:
  - A new ArrayList that contains the sum of the corresponding indecies of the two arraylists.
    e.g. sumLists( [1,2,3], [4,0,5]) would return: [5,2,8]
  Postconditions:
  - The parameter ArrayLists should not be modified.
  */
  public static ArrayList<Integer> sumLists(ArrayList<Integer>ListA,ArrayList<Integer>ListB){
    ArrayList <Integer> sumList = new ArrayList <Integer> (ListA.size());
    for (int i = 0; i < ListA.size(); i++){
      sumList.add(ListA.get(i) + ListB.get(i));
    }
    
    return sumList;
  }

  /** zipLists
  Parameters:
  - ListA,ListB - ArrayLists of integer values.
  Returns:
  - A new ArrayList that contains all of the elements from both ArrayLists in alternating order starting with ListA's first element.
    When one list has no more values to add, continue adding the remaining values of the longer list.
    e.g. zipLists( [1,2,3,4], [8,9]) would return: [1,8,2,9,3,4]
  Postconditions:
  - The parameter ArrayLists should not be modified.
  */
  public static ArrayList<Integer> zipLists(ArrayList<Integer>ListA,ArrayList<Integer>ListB){
    ArrayList <Integer> zippedList = new ArrayList <Integer> (ListA.size() + ListB.size());
    for (int i = 0, j = 0; zippedList.size() < (ListA.size() + ListB.size()); i++, j++){
      //if we haven't put in all values from ListA
      if (i < ListA.size()){
        //AND we haven't put in all values from ListB
        if (j < ListB.size()){
          zippedList.add(ListA.get(i));
          zippedList.add(ListB.get(j));
        
        } else {
          //if we HAVE finished all values from ListB
          zippedList.add(ListA.get(i));
        }
        
      } else {
        if (j < ListB.size()){
          zippedList.add(ListB.get(j));
        }
      }
    } //ends the for loop
    return zippedList;//placeholder to compile.
  }




  public static void main(String[] args) {

    ArrayList<Integer> al;

    // Uncomment these to test buildRandomList
    System.out.println("Build a random list of size 10 with values up to 100:");
    al = buildRandomList(10,100);
    System.out.println(al);

    //Testing sum
    System.out.println("\nTesting sumOfList:");
    int alSum = sumOfList(al);
    System.out.println(alSum);

    // Uncomment these to test swapElements
    System.out.println("\nSwap elements at indices 2 and 6:");
    swapElements(al, 2, 6);
    System.out.println(al);

    // Uncomment these to test removeValue
    System.out.println("\nAdd several 5's to the arrayList, then remove them:");
    al.add(5);
    al.add(10);
    al.add(5);
    al.add(13);
    al.set(2,5);
    al.set(3,5);
    System.out.println(al);
    removeValue(al,5);
    System.out.println(al);

    //Testing sumLists
    ArrayList <Integer> al2 = new ArrayList <Integer> ();
    al2 = buildRandomList(10, 100);
    System.out.println("\nFirst arrayList:");
    System.out.println(al);
    System.out.println("\nSecond arrayList:");
    System.out.println(al2);

    ArrayList <Integer> sumList = new ArrayList <Integer> ();
    sumList = sumLists(al, al2);
    System.out.println("\nSummed arrayList:");
    System.out.println(sumList);

    //Testing zipLists
    ArrayList <Integer> al3 = new ArrayList <Integer> ();
    al3 = buildRandomList(5, 20);
    System.out.println("\nFirst arrayList:");
    System.out.println(sumList);
    System.out.println("\nSecond arrayList:");
    System.out.println(al3);
    ArrayList <Integer> zip = new ArrayList <Integer> ();
    zip = zipLists(sumList, al3);
    System.out.println("\nZipped lists:");
    System.out.println(zip);

  }

}
```
