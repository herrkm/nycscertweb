import java.io.*;
import java.util.*;

/**
For all attempted methods, make sensible decisions for error and
edge cases (such as indexing out of bounds).

Basic
-----
add(string value)
get(int index);
toString()


Intermediate (at least add, size + one of the other two)
------------
size()
add(int index,String value)
indexOf(String value);
toArray()


Challenge
--------
remove(int index);
*/

public class LinkedList{

  private Node head;
  //could add size attribute:
  //private int size = 0;

  public LinkedList(){
    head = null;
    //size = 0;
  } 

  /**
  Parameters:
  value - the new string to add to the list

  Adds a new node containing value to the front of the list.
  */
  public void add(String value){
    Node newNode = new Node(value, head);
    //System.out.println(n1);
    head = newNode;
    //System.out.println(head);
    //size ++;
  }

  /**
  Returns the String in the node at location index.
  */
  public String get(int index){
    if (index >= this.size() || index < 0){
      System.out.println("Invalid index. Returning empty string.");
      return "";
      
    } else {
      
      Node walker = head;
      for(int i = 0; i < index; i++){
        walker = walker.getNext();
      }
      return walker.getData();
    }
  }

  /**
  Return a string representation of the list
  */
  public String toString(){
    Node walker = head;
    String listString = "";
    
    while (walker.getNext() != null){
      listString += walker.getData() + "->";
      walker = walker.getNext();
    }
    
    listString += walker.getData();
    return listString;
  }

  /**
  returns the number of elements in the list
  */
  public int size(){
    //return size;
    Node walker = head;
    int count = 0;
    
    while (walker != null){
      count ++;
      walker = walker.getNext();
    }
    
    return count;
  }



  /**
  Parameters:
  index - an int with the location to add
  value - the new value

  Adds a new node with the String value to the list.
  The new node should be added at the location specified by the index.

  For example, given the list:
  "a" -> "b" -> "c" -> "d"

  add(1,"z") results in:
  "a"-> "z" -> "b" -> "c" -> "d"

  */
  public void add(int index, String value){
    int listLength = this.size();
    //if index is out of bounds
    if (index < 0 || index > listLength){
      System.out.println("Invalid index. No change made.");
      
    } else {
      
      if (index == 0){
        this.add(value);
        
      } else {
        
        Node walker = head;
        //simplest case
        //walk through to get the node before the target index
        for (int i = 0; i < index - 1; i++){
          walker = walker.getNext();
        } //ends for loop
        Node newNode = new Node(value, walker.getNext());
        walker.setNext(newNode);
      } //ends if/else
      //size ++;
    } //ends if/else
    
  } //ends add method


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


  /**
  This routine should create a new array that is the same
  size as the number of Nodes in the list.

  It should then copy all of the values to the array and return
  the array.

  */
  public String[] toArray(){
    //store length of Linked List
    int arrayLength = this.size();
    //set walker to head
    Node walker = head;
    //declare nodeArray to size that matches current Linked List
    String[] nodeArray = new String[arrayLength];
    //set node data, in order, into array
    for (int i = 0; i < arrayLength; i++){
      nodeArray[i] = walker.getData();
      walker = walker.getNext();
    }
    return nodeArray;
  }



  /**
  Remove the Node at location index from the list.

  Ex:
  
  Given the list:
  "a"->"b"->"c"->"d"->"e"

  remove(2) results in:
  "a"->"b"->"d"->"e"
  */
  public void remove(int index){
    if (index < 0 || index >= this.size()){
      System.out.println("Invalid index. No change made.");
      
    } else if (index == 0) {
      head = head.getNext();
      
    } else {
      
      Node walker = head;
      //get to one Node before target index
      for (int i = 0; i < index - 1; i++){
        walker = walker.getNext();
      }
      //set walker's next to its current next's next
      walker.setNext(walker.getNext().getNext());
      //size --;
    }
  }

  public int[] indicesOf(String value){
    int length = this.size();
    int[] indices = new int[length];
    for (int j = 0; j < length; j++){
      indices[j] = -1;
    }
    Node walker = head;
    int counter = 0;
    for (int i = 0; i < length; i++){
      if (walker.getData() == value){
        indices[counter] = i;
        counter++;
      }
      walker = walker.getNext();
    }
    return indices;
  }

  
}
