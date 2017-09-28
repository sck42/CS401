// CS 0401 Lab1
// Practice Java program with a dual purpose:
// 1) To familiarize you with editing, compiling and running Java programs
// 2) To familiarize you with Java syntax

public class Lab1
{
    public static void main(String [] args)
    {
        int total = 87, number = 10;
        double doubleAve;
        int intAve;
        doubleAve = ((double)total)/number; // floating point division
        intAve = total/number;              // integer division
        System.out.println("The double average is " + doubleAve);
        System.out.println("The integer average is " + intAve);
        int value1 = 3 + 4 * 5;         // default precedence
                  int value2 = (3 + 4) * 5;       // change precedence with parens
        System.out.println("Value1 is " + value1);
        System.out.println("Value2 is " + value2);
    }
}
 