---
title: Kiana Herr's Hunter College Advanced Certificate Portfolio
layout: template
filename: index
--- 

# Welcome to Kiana Herr's website!

## CSCI 70900: Programming in a High Level Langage

|Course Topic|Files|
|------------|-----|
|Conditional Logic|[Nim.java](CSCI70900/Nim)
|1D Arrays|[ArrayPractice.java](CSCI70900/ArrayPractice)|
|2D Arrays|[Array2DPractice.java]()<br />[Cgol.java](CSCI70900/Cgol)|
|Recursion|[Fence.java]()<br />[Fib.java](CSCI70900/Fib)<br />[Reverser.java](CSCI70900/Reverser)<br />[BinSearch.java](CSCI70900/BinSearch)|
|Classes & Objects|[Time.java](CSCI70900/Time)<br />[Rational.java](CSCI70900/Rational)<br />[SuperArray.java](CSCI70900/SuperArray)|

Code sample (from Rational.java):

```java
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
|Array Lists|[AlPractice.java](CSCI70300/AlPractice)|
|Linked Lists|[Node.java](CSCI70300/Node)<br />[LinkedList.java](CSCI70300/LinkedList)|
|Sorting|[SortSearch.java](CSCI70300/SortSearch)<br />[SortSearch.java](CSCI70300/SortSearchxtra) (extra - animation in progress)|

Code sample (from LinkedList.java):

```java
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
|Live Coding|[02_livecode_JAVA.java](SEDC71900/02_livecode_JAVA)|
|Tracing|[03_trace.txt](SEDC71900/03_trace)|
|Unplugged Activities|[04_unplugged](SEDC71900/04_unplugged)|
|Scaffolding|[06_scaffold_activity.java](SEDC71900/06_scaffold_activity)<br />[06_scaffold_solution.java](SEDC71900/06_scaffold_solution)|

Work sample (from 04_unplugged):

Round 2: (2a: input = 9, 2b: input = 3, 2c: input = 7)
 ```python
 if input > 5:
   Stand up (on the floor)
   hop on one foot 3 times
   if input == 7:
     Pat your head
     if input < 7:
       Spin in a circle

   if input < 7:
     High five a neighbor
 ```


