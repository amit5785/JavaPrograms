import java.util.*;
public class Sum
{
    public static void main(String args [])
    {
        Scanner input=new Scanner(System.in);
        int a,b;
        System.out.println("Enter two Number :- ");
        a=input.nextInt();
        b=input.nextInt();
        System.out.println("Sum of "+a+" and "+b+" is :"+(a+b));
        input.close();
    }
}