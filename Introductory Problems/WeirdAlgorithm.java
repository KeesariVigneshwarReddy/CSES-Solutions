import java.util.*;
public class WeirdAlgorithm
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (n == 1)
        {
            System.out.println(1);
            return;
        }
        else
        {
            System.out.print(n + " ");
        }
        while (n != 1)
        {
            if ((n & 1) == 0)
            {
                n /= 2;
            }
            else
            {
                n = n * 3 + 1;
            }
            System.out.print(n + " ");
        }
    }
