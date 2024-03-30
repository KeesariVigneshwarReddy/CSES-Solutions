import java.util.*;
class AB
{
    int a;
    int b;
    AB(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString()
    {
        return this.a + " " + this.b;
    }
}
class Solution
{
    ArrayList<AB> moves;
    Solution()
    {
        moves = new ArrayList<>();
    }
    @Override
    public String toString()
    {
        for (AB move : this.moves)
        {
            System.out.println(move);
        }
        System.out.println();
        return "";
    }
}
public class Main
{
    static Solution[] output;
    public static void Hanoi(int n)
    {
        ArrayList<AB> moves_n = output[n].moves;
        ArrayList<AB> moves_n_1 = output[n - 1].moves;
 
        // move n - 1 discs from 1 to 2 using 3
        for (AB move_n_1 : moves_n_1)
        {
            AB move_n = new AB(move_n_1.a, move_n_1.b);
            if (move_n_1.a == 2)
            {
                move_n.a = 3;
            }
            else if (move_n_1.a == 3)
            {
                move_n.a = 2;
            }
            if (move_n_1.b == 2)
            {
                move_n.b = 3;
            }
            else if (move_n_1.b == 3)
            {
                move_n.b = 2;
            }
            moves_n.add(move_n);
        }
 
        // move 1 disc from 1 to 3
        moves_n.add(new AB(1, 3));
 
        // move n - 1 discs from 2 to 3 using 1
        for (AB move_n_1 : moves_n_1)
        {
            AB move_n = new AB(move_n_1.a, move_n_1.b);
            if (move_n_1.a == 1)
            {
                move_n.a = 2;
            }
            else if (move_n_1.a == 2)
            {
                move_n.a = 1;
            }
            if (move_n_1.b == 1)
            {
                move_n.b = 2;
            }
            else if (move_n_1.b == 2)
            {
                move_n.b = 1;
            }
            moves_n.add(move_n);
        }
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        output = new Solution[17];
        for (int i = 0; i < output.length; i++)
        {
            output[i] = new Solution();
        }
 
        // i == 1
        output[1].moves.add(new AB(1, 3));
 
        // i == 2
        output[2].moves.add(new AB(1, 2));
        output[2].moves.add(new AB(1, 3));
        output[2].moves.add(new AB(2, 3));
 
        for (int i = 3; i <= 16; i++)
        {
            Hanoi(i);
        }
 
        int n = sc.nextInt();
        System.out.println(output[n].moves.size());
        System.out.println(output[n]);
    }
}