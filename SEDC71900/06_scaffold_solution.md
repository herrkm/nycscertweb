```java
import java.util.*;
import java.io.*;

public class scaffold_solution
{
  public static void printArray( int[] data )
  {
    for(int i = 0; i < data.length; i++){
      System.out.print(data[i] + " ");
    }

    System.out.println("");
  }

  public static void prettyPrint( int[] data )
  {
    System.out.print("[");
    for (int i = 0; i < data.length; i++){
      if (i == data.length - 1)
      {
        System.out.println(data[i] + "]");
      } else {
        System.out.print(data[i] + ", ");
      }
    }
  }

  public static void main( String[] args )
  {
    int[] array = new int[]{1,5,2,7,5,8,5,12,19,5};
    printArray(array);
    
    prettyPrint(array);
  }
}
```
