import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int F,S,G,U, D;
    static int min = Integer.MAX_VALUE;
    static int[] visit;
    public void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(S);
        visit[S] = 1;
        while (!Q.isEmpty()) {
            int cur = Q.poll();
            if (cur == G) {
                System.out.println(visit[cur]-1);
            }
            if (cur + U <= F && visit[cur + U] == 0) {
                Q.offer(cur + U);
                visit[cur + U] = visit[cur] +1;
            }
            if (cur - D > 0 && visit[cur - D] == 0) {
                Q.offer(cur - D);
                visit[cur - D] = visit[cur] +1;
            }
        }

        if (visit[G] == 0) {
            System.out.println("use the stairs");
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        F = kb.nextInt();
        S = kb.nextInt();
        G = kb.nextInt();
        U = kb.nextInt();
        D = kb.nextInt();
        visit = new int[F + 1];

        main.BFS();
    }
}
