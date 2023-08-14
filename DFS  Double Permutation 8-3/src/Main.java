import java.util.*;
class Node{
    int point;
    Node lt, rt;

    public Node(int point) {
        this.point = point;
        this.lt = null;
        this.rt = null;
    }
}

public class Main {
    Node node;
    Queue<Integer> q = new LinkedList();

    public int BFS() {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int L = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node cur = q.poll();
                if(cur.lt == null && cur.rt == null)
                    return L;
                if(cur.lt != null)
                    q.offer(cur.lt);
                if(cur.rt != null)
                    q.offer(cur.rt);
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(1);
        tree.node.lt = new Node(2);
        tree.node.rt = new Node(3);
        tree.node.lt.lt = new Node(4);
        tree.node.lt.rt = new Node(5);
        System.out.println(tree.BFS());
    }
}