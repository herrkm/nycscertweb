```java
//livecoding task!
// Collaborators: Kiana Herr, Joshua Higgins, Rachel Kaufman, Shana Elizabeth Henry


// BIG IDEA: creating and traversing an array

//PROVIDE - skeleton
/*
public static int[] buildRandomArray( int size, int maxValue )
  {
    Random r = new Random();
    //Your brilliant code here!
  
  }

public static void printArray( int[] data )
  {
    //Your brilliant code here!
  }

public static void main( String[] args )
  {
    //Your brilliant code here!
  }
*/

public static int[] buildRandomArray( int size, int maxValue )
  {
    // CLARIFY - creating a new Random object
    Random r = new Random();
    // STUDENT-PROMPT - What do you think the [] is for?
    // BIG IDEA - Arrays need [] and why.
    int[] data = new int[size];
    // STUDENT-PROMPT - what are the components of the for loop statement?
    for (int i = 0; i < size; i++)
    {
      // MUST-ANSWER-Q - what does [i] do?
      // CLARIFY - r.nextInt() is using our random object to make random integers
      data[i] = r.nextInt(maxValue);
    }
  
    return data;
  }

// BEEG REVEAL - print an array object to see what happens
public static void printArray(int[] data)
  {
  // STUDENT-PROMPT - How do we find length of an array?
  // Assumption: Students have seen String.length()
  // FIRSTDRAFT: See below.
    for (int i = 0; i < data.length; i++) {
      // DELIBERATE-ERROR - just i or just data.
      System.out.print(i + " ");
    }
  // XTRA - what are the advantages/disadvantages of an enhanced for loop here?
  // REVISION v1
  //  for (element : data) {
  //    System.out.print(element + " ");
  //  }
    //STUDENT-PROMPT - what's missing to make sure we clean up our printed result? (println)
    System.out.println("");
  }

/*
  PROVIDE :: code snippets or comments you definitely want to provide
  STUDENT-PROMPT :: a specifically-worded question you want to ask, or a general solicitation for input, etc
  MUST-ANSWER-Q :: a question that must be resolved, that a majority of your class must understand before moving on
  BIG IDEA :: an introduction of a new topic, a connection to prior lesson or discussion for application here in code, etc.
  BEEG REVEAL :: this is gonna blow yer minds...
  DELIBERATE-ERROR :: specific code snippet or a general approach that is a bad fit for the situation, is flat-out wrong, or will lead to a compile- or run-time error, etc.
  FIRSTDRAFT :: code that will work for now, but which you intend to replace later
  REVISION vX :: better versions of firstdraft code...
*/
```
