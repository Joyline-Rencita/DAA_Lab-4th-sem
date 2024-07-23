0/1 Knapsack problem using  Dynamic Programming : 

package knapsackdp1;
import java.util.Scanner;

public class Knapsackdp1 {
    
    public void calculate(int[] wt, int[] val, int W, int n) {
        int i, j;
        int[][] V = new int[n + 1][W + 1];
        
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    V[i][j] = 0;
                else if (j < wt[i])
                    V[i][j] = V[i - 1][j];
                else
                    V[i][j] = Math.max(V[i - 1][j - wt[i]] + val[i], V[i - 1][j]);
            }
        }
        
        System.out.println("Optimal value = " + V[n][W]);
        
        if (V[n][W] == 0) {
            System.out.println("No Optimal Subset");
        } else {
            System.out.println("Optimal Subset:");
            for (i = n; i > 0 && W > 0; i--) {
                if (V[i][W] != V[i - 1][W]) {
                    System.out.println("Item " + i);
                    W -= wt[i];
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int i;
        Scanner scan = new Scanner(System.in);
        Knapsackdp1 ks = new Knapsackdp1();
        
        System.out.println("Enter number of items:");
        int n = scan.nextInt();
        
        int[] wt = new int[n + 1];
        int[] val = new int[n + 1];
        
        System.out.println("\nEnter weights for " + n + " items:");
        for (i = 1; i <= n; i++)
            wt[i] = scan.nextInt();
        
        System.out.println("\nEnter values for " + n + " items:");
        for (i = 1; i <= n; i++)
            val[i] = scan.nextInt();
        
        System.out.println("\nEnter Knapsack capacity:");
        int W = scan.nextInt();
        
        ks.calculate(wt, val, W, n);
    }
}
