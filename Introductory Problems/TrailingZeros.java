import java.util.*;
 
public class Main
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
        int n = sc.nextInt(), k = 1, ans = 0;
        while (n / Math.pow(5, k) != 0)
        {
            ans += n / Math.pow(5, k);
            k++;
        }
        System.out.println(ans);
    }
}