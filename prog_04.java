QUICK  SORT

package quicksort1;
import java.util.Random;
import java.util.Scanner;

public class QuickSort1 {
    static int max = 10000;

    int partition(int[] a, int low, int high) {
        int p, i, j, temp;
        p = a[low];
        i = low + 1;
        j = high;

        while (low < high) {
            while (i < high && a[i] <= p) i++;
            while (a[j] > p) j--;
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            } else {
                temp = a[low];
                a[low] = a[j];
                a[j] = temp;
                return j;
            }
        }
        return j;
    }

    void sort(int[] a, int low, int high) {
        if (low < high) {
            int s = partition(a, low, high);
            sort(a, low, s - 1);
            sort(a, s + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] a;
        int i;

        System.out.println("Enter the array size:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        a = new int[max];
        Random generator = new Random();
        for (i = 0; i < n; i++) {
            a[i] = generator.nextInt(5100);
        }

        System.out.println("Array before sorting:");
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        QuickSort1 m = new QuickSort1();
        long startTime = System.currentTimeMillis();
        m.sort(a, 0, n - 1);
        long stopTime = System.currentTimeMillis();

        System.out.println("Sorted array is:");
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        long elapseTime = (stopTime - startTime);
        System.out.println("Time taken to sort array is: " + elapseTime + " milliseconds");
    }
}
