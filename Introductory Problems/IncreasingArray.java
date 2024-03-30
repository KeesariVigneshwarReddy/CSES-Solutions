import java.util.*;
 
public class IncreasingArray
{
    static Scanner sc = new Scanner(System.in);
    public static void printArray(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int n = sc.nextInt();
        long sum = 0;
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i < a.length; i++)
        {
            if (a[i] < a[i - 1])
            {
                sum += a[i - 1] - a[i];
                a[i] = a[i - 1];
            }
        }
        System.out.println(sum);
    }
