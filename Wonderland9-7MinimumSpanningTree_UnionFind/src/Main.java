import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int v1;
    public int v2;
    public int cost;
    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] unf;
    static int answer = 0;

    public static int Find(int v) {
        if(v == unf[v]) return unf[v];
        else
            return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        ArrayList<Edge> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int v1 = kb.nextInt();
            int v2 = kb.nextInt();
            int cost = kb.nextInt();
            arr.add(new Edge(v1, v2,cost));
        }
        Collections.sort(arr);
        for (Edge edge : arr) {
            if (Find(edge.v1) != Find(edge.v2)) {
                Union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        }
        System.out.println(answer);
    }
}