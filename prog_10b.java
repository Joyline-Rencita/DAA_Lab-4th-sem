10.  Write Java programs to 
(b) Implement Traveling Salesperson problem using Dynamic programming

  package tsp;

import java.util.Scanner;

public class Tsp {
    int weight[][], n, tour[], finalCost;

    Tsp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of cities");
        n = sc.nextInt();
        weight = new int[n][n];
        tour = new int[n - 1];
        System.out.println("Enter the cost matrix");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                weight[i][j] = sc.nextInt();
        System.out.println("Starting node assumed to be node 1.");
        eval();
    }

    public int COST(int node, int[] d, int Size) {
        int temp;
        if (Size == 0)
            return weight[node][0];
        int min = 99;
        int NextCOST[] = new int[n - 1];
        for (int i = 0; i < Size; i++) {
            int k = 0;
            for (int j = 0; j < Size; j++) {
                if (d[i] != d[j])
                    NextCOST[k++] = d[j];
            }
            temp = COST(d[i], NextCOST, Size - 1);
            if ((weight[node][d[i]] + temp) < min) {
                min = weight[node][d[i]] + temp;
            }
        }
        return min;
    }

    public int MIN(int node, int[] d, int Size) {
        if (Size == 0)
            return weight[node][0];
        int min = 99, minindex = 0, temp;
        int NextCOST[] = new int[n - 1];
        for (int i = 0; i < Size; i++) {
            int k = 0;
            for (int j = 0; j < Size; j++) {
                if (d[i] != d[j])
                    NextCOST[k++] = d[j];
            }
            temp = COST(d[i], NextCOST, Size - 1);
            if ((weight[node][d[i]] + temp) < min) {
                min = weight[node][d[i]] + temp;
                minindex = d[i];
            }
        }
        return minindex;
    }

    public void eval() {
        int d[] = new int[n - 1];
        for (int i = 1; i < n; i++)
            d[i - 1] = i;
        finalCost = COST(0, d, n - 1);
        constructTour();
    }

    public void constructTour() {
        int pSet[] = new int[n - 1];
        int nSet[] = new int[n - 2];
        for (int i = 1; i < n; i++)
            pSet[i - 1] = i;
        int Size = n - 1;
        tour[0] = MIN(0, pSet, Size);
        for (int i = 1; i < n - 1; i++) {
            int k = 0;
            for (int j = 0; j < Size; j++) {
                if (tour[i - 1] != pSet[j])
                    nSet[k++] = pSet[j];
            }
            --Size;
            tour[i] = MIN(tour[i - 1], nSet, Size);
            for (int j = 0; j < Size; j++)
                pSet[j] = nSet[j];
        }
        display();
    }

    public void display() {
        System.out.println();
        System.out.print("The tour path 1-");
        for (int i = 0; i < n - 1; i++)
            System.out.print((tour[i] + 1) + "-");
        System.out.println("1");
        System.out.println("Cost of the tour = " + finalCost);
    }

    public static void main(String[] args) {
        Tsp obj = new Tsp();
    }
}
