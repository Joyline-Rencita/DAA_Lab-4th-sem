11. Design and implement in Java to find a subset of a given set S = {Sl, S2,.....,Sn} of n positive integers whose SUM is equal to a given positive integer d. For example, if S = {1, 2, 5, 6, 8} and d= 9, there are 
two solutions {1,2,6}and {1,8}. Display a suitable message, if the given problem instance doesn&#39;t have a solution. 

package subset;
import java.util.Scanner;

public class Subset {

    void subset(int n, int d, int[] w) {
        int k = 1, flag = 0, sum = 0, i, check = 0;
        int[] x = new int[10];
        x[1] = 1;
        for (i = 2; i <= n; i++)
            x[i] = 0;
        while (true) {
            if (k <= n && x[k] == 1) {
                if (sum + w[k] == d) {
                    if (check == 0) {
                        System.out.println("The possible subsets are:");
                        check = 1;
                    }
                    System.out.print("{");
                    for (i = 1; i <= n; i++)
                        if (x[i] == 1)
                            System.out.print(w[i] + " ");
                    System.out.println("}");
                    flag = 1;
                    x[k] = 0;
                } else if (sum + w[k] < d)
                    sum += w[k];
                else
                    x[k] = 0;
            } else {
                k--;
                while (k > 0 && x[k] == 0)
                    k--;
                if (k == 0)
                    break;
                x[k] = 0;
                sum -= w[k];
            }
            k += 1;
            x[k] = 1;
        }
        if (flag == 0)
            System.out.println("No possible subsets");
    }

    public static void main(String[] args) {
        int[] w = new int[20];
        int i, n, d;
        Subset s = new Subset();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        n = sc.nextInt();
        System.out.println("Enter the elements of the set in increasing order:");
        for (i = 1; i <= n; i++)
            w[i] = sc.nextInt();
        System.out.println("Enter the integer:");
        d = sc.nextInt();
        s.subset(n, d, w);
    }
}
