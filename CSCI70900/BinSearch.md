```java
/**
 * Binary Search by Team Did You Mean Recursion?
 * First Last
 * collaborators: First Last, First Last
 */

/**
   class BinSearch
   Binary search on array of ints
*/

public class BinSearch
{

  /**
     int binSearch(int[],int) -- searches an array of ints for target int
     precondition:  input array is sorted in ascending order
     postcondition: returns index of target, or returns -1 if target not found
  */
  public static int binSearch ( int[] a, int target )
  {
    //Q: Why did the designers of this class opt for 2 binSearch methods instead of 1?
    //A: Because when you subdivide the array, you'll need to be able to pass additional changing arguments to the search. This is the method through which the recursive method is accessed.
    return binSearchRec( a, target, 0, a.length-1 );
  }


  public static int binSearchRec( int[] a, int target,
                                  int loPos, int hiPos )
  {
    int tPos = -1; //init return var to flag/signal value

    int mPos = (loPos + hiPos) / 2; //init tracker var for middle position
    //note: integer division
    //exit case. If lo & hi have crossed, target not present
    if (hiPos < loPos) 
      return tPos;

    // target found
    if ( a[mPos] == target ) {
      tPos = mPos;
    }
    // value at mid index higher than target
    else if ( a[mPos] > target ) {
      tPos = binSearchRec(a, target, loPos, mPos - 1); //don't need to include mPos since we already checked it
    }
    // value at mid index lower than target
    else if ( a[mPos] < target ) {
      tPos = binSearchRec(a, target, mPos + 1, hiPos); //don't need to include mPos since we already checked it
    }

    return tPos;
  }//end binSearchRec


  //tell whether an array is sorted in ascending order
  private static boolean isSorted( int[] arr )
  {
    boolean retBoo = true; //init to true, assume array is sorted

    //Q: Why would a FOREACH loop not suffice here?
    for( int i=0; i < arr.length-1; i++ ) {
      if ( ( arr[i] > arr[i+1] ) ) {
        return false;
      }
    }
    return retBoo; //if entire array was traversed, it must be sorted
  }


  // utility/helper fxn to display contents of an array of Objects
  private static void printArray( int[] arr )
  {
    String output = "[ ";

    for( int c : arr )
      output += c + ", ";

    output = output.substring( 0, output.length()-2 ) + " ]";

    System.out.println( output );
  }



  //main method for testing
  public static void main ( String[] args )
  {
    //move the bar down to uncover tests in succession...
    System.out.println("\nNow testing binSearch on int array...");

    //Declare and initialize array of ints
    int[] iArr = { 2, 4, 6, 8, 6, 42 };
    printArray( iArr );
    System.out.println( "iArr1 sorted? -- " + isSorted(iArr) );

    int[] iArr2 = { 2, 4, 6, 8, 13, 42 };
    printArray( iArr2 );
    System.out.println( "iArr2 sorted? -- " + isSorted(iArr2) );

    int[] iArr3 = new int[10000];
    for( int i = 0; i < iArr3.length; i++ ) {
      iArr3[i] = i * 2;
    }

    //printArray( iArr3 );
    System.out.println( "iArr3 sorted? -- " + isSorted(iArr3) );

    //search for 6 in array
    System.out.println( binSearch(iArr2,2) );
    System.out.println( binSearch(iArr2,4) );
    System.out.println( binSearch(iArr2,6) );
    System.out.println( binSearch(iArr2,8) );
    System.out.println( binSearch(iArr2,13) );
    System.out.println( binSearch(iArr2,42) );

    //search for 43 in array
    System.out.println( binSearch(iArr2,43) );

    System.out.println( "now testing binSearch on iArr3..." );
    System.out.println( binSearch(iArr3,4) );
    System.out.println( binSearch(iArr3,8) );
    System.out.println( binSearch(iArr3,5) );

    //search for 43 in array
    System.out.println( binSearch(iArr3,43) );

    /* YOUR SMART CODE HERE :: Feel free to add extra tests...*/

  }

}
```
