7. From a given vertex in a weighted connected graph, find shortest paths to other vertices using Dijkstra's algorithm. Write the program in Java

package dijkstras1;
import java.util.Scanner;

public class Dijkstras1 {
    static void dijkstra(int n, int[][] cost, int src) {
        int[] visit = new int[n + 1];
        int[] dist = new int[n + 1];
        int i, j, u = 0, w, min;

        for (i = 0; i <= n; i++) {
            dist[i] = cost[src][i];
            visit[i] = 0;
        }

        visit[src] = 1;

        for (i = 1; i <= n; i++) {
            min = 99;
            for (j = 1; j <= n; j++) {
                if (dist[j] < min && visit[j] != 1) {
                    min = dist[j];
                    u = j;
                }
            }
            visit[u] = 1;

            for (w = 1; w <= n; w++) {
                if (dist[w] > dist[u] + cost[u][w] && visit[w] == 0) {
                    dist[w] = dist[u] + cost[u][w];
                }
            }
        }

        for (i = 1; i <= n; i++) {
            if (i != src) {
                System.out.println("Distance from " + src + " to " + i + " is: " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        int n, i, j, src;
        int[][] cost = new int[10][10];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes:");
        n = sc.nextInt();
        System.out.println("Enter the cost matrix:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the source vertex:");
        src = sc.nextInt();
        dijkstra(n, cost, src);
    }
}
