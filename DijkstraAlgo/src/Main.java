import java.util.*;

class Edge implements Comparable<Edge> {
    public int ver;
    public int cost;
    public Edge(int ver, int cost) {
        this.ver = ver;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;//오름차순
    }
}
public class Main {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public void solution(int v) {

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int nowVer = tmp.ver;
            int nowCost = tmp.cost;
            if(dis[nowVer] < nowCost) continue;
            for (Edge edge : graph.get(nowVer)) {
                if (dis[edge.ver] > nowCost + edge.cost) {
                    dis[edge.ver] = nowCost + edge.cost;
                    pQ.offer(new Edge(edge.ver, nowCost + edge.cost));
                }
            }
        }
    }
//            6 9
//            1 2 12
//            1 3 4
//            2 1 2
//            2 3 5
//            2 5 5
//            3 4 5
//            4 2 2
//            4 5 5
//            6 4 5
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        main.solution(1);

        for (int i = 1; i <= n; i++) {
            if(dis[i] == Integer.MAX_VALUE)
                System.out.println(i + " : Impossible");
            else
                System.out.println(i + " : " + dis[i]);
        }

    }
}