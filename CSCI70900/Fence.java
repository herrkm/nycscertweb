/**
 * Recursion Practice with Strings by Team SweatEquity
 * Aasine Cassara
 * collaborators: Alana, Jerusha, Kiana
 */

public class Fence
{

  /**
     String fenceR(int) -- recursive fence generator
     precond:  input is a positive integer
     postcond: returns fence with n posts

     eg
     fenceR(1) -> "|"
     fenceR(2) -> "|--|"
  */
  public static String fenceR( int n )
  {
    if(n == 0) {
    
    return ""; //a 0 post fence is empty
    }   
    if (n==1) {
      return "|"; //a 1 post fence is a single post
    }
    else {
      return fenceR(n - 1) + "--|";
    }
    //this is the base case and anytime you use a base case you need an if statement
    /* YOUR SIMPLE, SMART IMPLEMENTATION HERE */
    //fence is printing a fence
  }


  public static void main( String[] args )
  {
//it loops through 1 post fence, then loops through 2 post fence, etc.
    for( int i = 0; i < 10; i++ ) {
      System.out.println( i + "-post fences: " );//this prints the fence
      System.out.println( fenceR(i) );
    }

    /* feel free to add extra tests... */

  }
}
