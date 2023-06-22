package learn;

//public class Add 

import java.util.Scanner;
class Add
{
   public static void main(String args[])
   {
      int x, y, z;
 
      System.out.println("Enter two integers to calculate their sum");
      Scanner in = new Scanner(System.in);
     
      x = in.nextInt();
      y = in.nextInt();
      z = x + y;
     
      System.out.println("Sum of the integers = " + z);
   }
}