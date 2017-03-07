import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShootsAndLadders {
    static Scanner in = new Scanner(System.in);
    int[] spaceCosts = new int[100];
    int[] board = new int[100];
    
    public static void main(String[] args) {
        ShootsAndLadders s = new ShootsAndLadders();
        int t = s.in.nextInt();
        for (int i = 0; i < t; i++) {
            s.runTestCase();
        }
    }
    
    public void runTestCase() {
        for (int i = 0; i < 100; i++) {
            spaceCosts[i] = Integer.MAX_VALUE;
            board[i] = -1;
        }
        
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int source = in.nextInt() - 1;
            int dest = in.nextInt() - 1;
            board[source] = dest;
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int source = in.nextInt() - 1;
            int dest = in.nextInt() - 1;
            board[source] = dest;
        }
        updateSquare(0, -1);
        if (spaceCosts[99] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(spaceCosts[99]);
    }
    
    void updateSquare(int space, int moves) {
        if (spaceCosts[space] <= moves)
            return;
        spaceCosts[space] = moves + 1;
        if (board[space] != -1) {
            updateSquare(board[space], moves);
        } else {
            for (int i = 6; i >=1; i--) {
                if(space+i < 100)
                    updateSquare(space+i, moves+1);
            }
        }
    }
}