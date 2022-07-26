title: Time.java
layout: template
filename: Time

```java
import java.io.*;
import java.util.*;


/**
 * Time class by Team LucidThinkeren
 * Aasine Cassara
 * collaborators: Alana,Kiana, Jerusha
 */

/**
   INSTRUCTIONS:

   This file contains the starter code for our Time class.

   The class here uses ints for hours, minutes, and seconds but you
   could decide to change the internal representation to just store
   an int representing a number of seconds.

   Place this file in a folder named programming/5/Time.java

   Basic level (complete all):
   - public Time(int hrs, int mins, int secs) - constructor
   - public void toString()
   - public void set(int hrs, int mins, int secs)

   Intermediate level (complete Basic methods plus this method):
   - public void add(Time other)
   - public boolean isEquals(Time other)

   
   Advanced level (complete Basic + Intermediate + these two methods):
   - public int compareTo(Time other)
   
*/



public class Time {
    // Instance Variable(s)
    // You can change this if you want to use the alternate
    // implementation of just storing the overall seconds.

  //make it private so only the class can access it
    private int hours;
    private int minutes;
    private int seconds;

    // Constructors
    public Time(){
      
      this.hours = 0;
	    this.minutes = 0;
	    this.seconds = 0;

     
	
    }

    /**
       Parameters:
       - hrs, mins, secs - the time you want to create the class as

       Initialize this instance to represent hrs:mins:secs as the time.
       //time is our object "this". refers to the instance variable in the object
  Time is overloaded because there is one version that has arguments and one that does not. The two constructors, one on line 50 is the default and the one on line 68 is the one we set.
     */
    public Time(int hrs, int mins, int secs){
      hours = hrs;
      minutes = mins;
      seconds = secs;
      
      
	// your code here
	
    }
    
    
    // Methods

    /**
       returns a string representation of the time
    */
    public String toString(){
      String minString;
      if(minutes <10) {
        minString = "0" + minutes;
      }
      else {
        minString = String.valueOf(minutes);
      }
    
      String secString;
      if(seconds <10) {
        secString = "0" + seconds;
      }
      else {
       secString = String.valueOf(seconds);
        
      }
	    return hours + ":" + minString + ":" + secString;
    }
    // Accounts for minute or seconds that are less than 10 to display as 0 prior to minutes or seconds

    /**
       Parameters:
       - hrs,mins,secs - ints representing a time

       modifies this instance to represent the time hrs:mins:secs
    */
    public void set(int hrs, int mins, int secs){
	// add the code to add the time represented by other
	// to this instance.
      hours = hrs;
      minutes = mins;
      seconds = secs;
      
    }

    

    /**
       Parameters:
       - other - a variable of type Time

       modifies this instance to represent the result of adding it and
       the time other.
    */
    public void add(Time other){
	// add the code to add the time represented by other
	// to this instance.
      this.hours += other.hours;
      this.minutes += other.minutes;
      this.seconds += other.seconds;

      //if seconds > 60, add an extra minute to minutes and remove extra seconds
      this.minutes += this.seconds / 60;
      this.seconds = this.seconds % 60;
      
      //if minutes > 60, add an extra hour to hours and remove extra minutes
      this.hours += this.minutes / 60;
      this.minutes = this.minutes % 60;

    }


    /**
       Parameters:
       other - a variable of type Time

       Returns:
       True if this instance and other represents the same time
       false otherwise.
    */
    public boolean equals(Time other){
  	  int thisSeconds = this.hours*3600 + this.minutes*60 + this.seconds;
      int otherSeconds = other.hours*3600 + other.minutes*60 + other.seconds;

	  return thisSeconds == otherSeconds; // change this
    }

    /**
       Parameters:
       other - a variable of type Time

       Returns:
       A positive number if this instance represents a time greater
       than the time of other (this > other)

       A negative number if this instance represents a time less
       than the time of other (this < other)

       0 if the two instances represent the same time.

    */
    public int compareTo(Time other){
  	  int thisSeconds = this.hours*3600 + this.minutes*60 + this.seconds;
      int otherSeconds = other.hours*3600 + other.minutes*60 + other.seconds;
      int result;
      if (thisSeconds > otherSeconds) result = 1;
      if (thisSeconds < otherSeconds) result = -1;
      else result = 0;

	  return result; // change this
    }
    

    
}//end class
```
