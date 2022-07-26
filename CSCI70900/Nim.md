---
title: Nim.java
layout: template
filename: Nim
---

```java
/**
* Game of Nim by Team Breakout Room 5
* Kiana Herr
* collaborators: Adam Driggers, Shana Henry, Vanessa Zou, Patricia Wygard
*/

import java.io.*;
import java.util.*;



public class Nim //goal: be the player to remove the last stone
{
  public static void main( String[] args )  {
    int stones = 12; //define variable stones, 12 in bag to start
    int stonesTaken; //will need to keep track of how many are removed

    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    //loop until game ends
    System.out.println("Let's play Nim! There are 12 stones to begin and the last player to take a stone wins! You can remove between 1 and 3 stones.\n");
    while (stones > 0) {
      //prompt user input (user turn)
      System.out.print("How many stones do you wish to remove? ");
      stonesTaken = input.nextInt();
      input.nextLine();
      if (stonesTaken > 0 && stonesTaken < 4) {
        if (stonesTaken <= stones) {
          //calculate and print number of stones remaining
          stones = stones - stonesTaken;
          System.out.println("There are " + stones + " stones remaining.");
        } else {
          System.out.println("You cannot take that many stones. There are only " + stones + "stones remaining. Please try again.");
          continue;
        }
      } else {
        System.out.println("You cannot take that many stones. You may take 1-3 stones. Please try again.");
        continue;
      }
      //check for win
      if (stones == 0){
        System.out.println("You have taken the last stone. Congratulations! You win!");
        break;
      } else {
        //machine turn
        stonesTaken = (stones > 0 && stones <= 3) ? stones : ((stones - 3 <= 3) ? 1 : rand.nextInt(3) + 1);
        stones = stones - stonesTaken;
        System.out.println("The machine has taken " + stonesTaken + " stones. There are " + stones + " stones remaining.");
        //check for win
        if (stones == 0){
          System.out.println("The machine has taken the last stone. Sorry, you lose!");
          break;
        }
      }
    }
  }
}
```
