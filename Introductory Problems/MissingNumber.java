import java.util.*;
 
public class MissingNumber
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = sc.nextInt();
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n - 1 ; i++)
        {
            visited[sc.nextInt()] = true;
        }
        for (int i = 1; i <= n; i++)
        {
            if (visited[i] == false)
            {
                System.out.println(i);
                break;
            }
        }
    }
