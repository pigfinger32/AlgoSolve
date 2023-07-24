import java.util.*;

class Edge implements Comparable<Edge>{
    public int ver;
    public int cost;
    public Edge(int ver, int cost) {
        this.ver = ver;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Main {
    static int[] ch;
    static int answer;
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        ch = new int[n + 1];
        Arrays.fill(ch, 0);
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue();
        pQ.add(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            if (ch[tmp.ver] == 0) {
                ch[tmp.ver] = 1;
                answer += tmp.cost;
                for (Edge ob  : graph.get(tmp.ver)) {
                    if (ch[ob.ver] == 0) pQ.offer(new Edge(ob.ver, ob.cost));
                }
            }
        }

        System.out.println(answer);
    }
}