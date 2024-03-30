import java.util.Scanner;
 
public class Main
{
    static int count = 0;
    static Scanner sc = new Scanner(System.in);
    public static void initChessBoard(char[][] chessBoard)
    {
        for (int i = 0; i < chessBoard.length; i++)
        {
            String row = sc.nextLine();
            for (int j = 0; j < chessBoard[i].length; j++)
            {
                chessBoard[i][j] = row.charAt(j);
            }
        }
    }
    public static void printChessBoard(char[][] chessBoard)
    {
        for (int i = 0; i < chessBoard.length; i++)
        {
            for (int j = 0; j < chessBoard[i].length; j++)
            {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void modifyVisitedMatrix(int[][] visited, int n, int row, int col, boolean parity)
    {
        for (int i = 0; i < n; i++)
        {
            visited[i][col] = (parity == true) ? visited[i][col] + 1 : visited[i][col] - 1;
        }
        for (int j = 0; j < n; j++)
        {
            visited[row][j] = (parity == true) ? visited[row][j] + 1 : visited[row][j] - 1;
        }
        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++)
        {
            visited[i][j] = (parity == true) ? visited[i][j] + 1 : visited[i][j] - 1;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        {
            visited[i][j] = (parity == true) ? visited[i][j] + 1 : visited[i][j] - 1;
        }
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--)
        {
            visited[i][j] = (parity == true) ? visited[i][j] + 1 : visited[i][j] - 1;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
        {
            visited[i][j] = (parity == true) ? visited[i][j] + 1 : visited[i][j] - 1;
        }
    }
    public static boolean isSafe(int[][] visited, int n, int row)
    {
        boolean isSafe = true;
        for (int j = 0; j < n; j++)
        {
            if (visited[row][j] == 0)
            {
                isSafe = false;
            }
        }
        return isSafe;
    }
    public static void getSolution(char[][] chessBoard, int[][] visited, int n, int i)
    {
        if (i == n)
        {
            //System.out.println("Solution " + (++count));
            //printChessBoard(chessBoard);
            count++;
            return;
        }
        if (isSafe(visited, n, i) == true)
        {
            return;
        }
        for (int j = 0; j < n; j++)
        {
            if (chessBoard[i][j] == '*')
            {
                continue;
            }
            if (visited[i][j] == 0)
            {
                chessBoard[i][j] = 'Q';
                modifyVisitedMatrix(visited, n, i, j, true);
                getSolution(chessBoard, visited, n, i + 1);
                chessBoard[i][j] = '_';
                modifyVisitedMatrix(visited, n, i, j, false);
            }
        }
    }
    public static void main(String[] args)
    {
        int n = 8;
        count = 0;
        char[][] chessBoard = new char[n][n];
        initChessBoard(chessBoard);
        //printChessBoard(chessBoard);
        getSolution(chessBoard, new int[n][n], n, 0);
        System.out.println(count);
    }
}