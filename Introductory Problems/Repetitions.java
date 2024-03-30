import java.util.*;
 
public class Repititions
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
        String s = sc.next();
        int[] freq = new int[4];
        char prevChar = 'B';
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++)
        {
            int currChar = -1;
            switch (s.charAt(i))
            {
                case 'A' : currChar = 0;
                    break;
                case 'C' : currChar = 1;
                    break;
                case 'G' : currChar = 2;
                    break;
                case 'T' : currChar = 3;
                    break;
            }
            if (freq[currChar] != 0 && s.charAt(i) != prevChar)
            {
                freq[currChar] = 0;
            }
            freq[currChar]++;
            prevChar = s.charAt(i);
            max = Math.max(max, Math.max(freq[0], Math.max(freq[1], Math.max(freq[2], freq[3]))));
        }
        System.out.println(max);
    }
}