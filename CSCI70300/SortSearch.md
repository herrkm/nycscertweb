---
title: SortSearch.java
layout: template
filename: SortSearch
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

  /* Sort project starts here */
  
  /* Instance Variables */
  private ArrayList<Integer> data;  // to store the data
  
  private Random r; //variable to hold a randomly generated object.

  
  public SortSearch()//constructor that has no parameters
  {

    data = new ArrayList<Integer>();//initializes the instance variable "data"
    r = new Random();//initializes the instance variable "r".
    for (int i=0; i<15; i++) //default size is 15
    {
      data.add(r.nextInt(20)); //the parameter "20" fills with random values between 0 and 19
    }

  }
  
  public SortSearch(int size)//overloaded constructor that takes in an int "size"
  {
    data = new ArrayList<Integer>();//initializes the instance variable "data"

    r = new Random();//initializes the instance variable "r".
    for (int i=0; i<size; i++)//size is provided by the user through through the varialbe "size"
    {
      data.add(r.nextInt(20));//the parameter "20" fills with random values between 0 and 19
    }

  }

  /* Convenience function to get data out of the ArrayList from the driver */
  public int get(int index){
    return this.data.get(index);
  }



  //return size of ArrayList
  //helper method to simplify call of recursive binary search
  public int getSize() {
    return data.size();
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
    for(int i = start; i < data.size(); i++)
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
    for(int i = 0; i < data.size(); i++)
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
    for(int i = 0; i < data.size(); i++)
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
    int high = data.size() - 1;
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


    /* Merge Sort Stuff after here */
    // Team: Harrison Fung, Sarah McCoy, Moo Joon Park
    /**
       Builds and returns an ArrayList that's already in increasing order.

       You can use this method to test your merge method.

    */
    public ArrayList<Integer> buildIncreasingList(int size){
	ArrayList<Integer>  newlist = new ArrayList<Integer>();
	Random r = new Random();
	int nextval = r.nextInt(20)+1;
	for (int i=0;i<size;i++){
	    newlist.add(nextval);
	    nextval = nextval + r.nextInt(20);
	}

	return newlist;
	}

    /**
       this routine should create and return a new ArrayList of
       integers and fill it by merging list1 and list2 into the new
       list.

       list1 and list2 are already sorted in increasing order.

       Example:
       If list1 contains [1,5,17,25]
       and list2 contains [3,6,10,30,40,50]

       The new list will contain:
       [1, 3, 5, 6, 10, 17, 25, 30, 40, 50]

       
    */
       
  public ArrayList<Integer> merge(ArrayList<Integer> list1,
				    ArrayList<Integer> list2){

	// code for merge: v1
    
		ArrayList<Integer> mergedAL = new ArrayList<Integer>();//shall we declare the size as the sum of the sizes of list 1 and list 2?
    
    /*
		//Loop until one of them is empty
		while (list1.size()!= 0 && list2.size()!=0){
			//Compare the FIRST items in each list, remove the smaller one
			if (list1.get(0) < list2.get(0)){//Doesn't matter if they are equal...
				mergedAL.add(list1.get(0)); //item in list one added to
				list1.remove(0);  //merged list and is removed from list one
			}else{
				mergedAL.add(list2.get(0)); //item in list two added to
				list2.remove(0); //merged list and is removed from list two
			}
 		} // ends the while loop
    
    if (list1.size()!=0){ //if list1 is not empty, add its elements to mergeAL
      for (int i = 0; i < list1.size(); i++){
				mergedAL.add(list1.get(i));
			}
		}
		if (list2.size()!=0){ //if list2 is not empty, add its elements to mergeAL
      for (int i = 0; i < list2.size(); i++){
				mergedAL.add(list2.get(i));
			}
    }
    */

    
    //code for merge: v2
    int l1Start = 0;
    int l2Start = 0;
    while (l1Start < list1.size() && l2Start < list2.size()){
      if (list1.get(l1Start) < list2.get(l2Start)){
        mergedAL.add(list1.get(l1Start));
        l1Start ++;
      } else {
        mergedAL.add(list2.get(l2Start));
        l2Start ++;
      }
    }

    if (l1Start < list1.size()){
      for (int i = l1Start; i < list1.size(); i++){
        mergedAL.add(list1.get(i));
      }
    }
    if (l2Start < list2.size()){
      for (int i = l1Start; i < list1.size(); i++){
        mergedAL.add(list2.get(i));
      }
    }


    
	  return mergedAL; 
  }

  
    
 




  


}//end class
```
