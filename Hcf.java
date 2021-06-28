import java.util.*;
public class Hcf 
{
    public static int HCF(int a,int b)
    {
        int temp;
        while(a!=0)
        {
            temp=a;
            a=b%a;
            b=temp;
        }
        return b;
    }
    public static void main(String Args [])
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Two number : ");
        int a=input.nextInt();
        int b=input.nextInt();
        System.out.println("Hcf of the two number "+a+" and "+b+" is : "+HCF(a,b));
    }
}
