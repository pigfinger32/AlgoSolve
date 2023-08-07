import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int min = Integer.MAX_VALUE;
    static int count = 0;
    static int[] time;

    public void BFS() {
        Queue<Integer> Q = new LinkedList();
        Q.offer(N);
        time[N] = 1;

        while (!Q.isEmpty()) {
            int now = Q.poll();

            if (min < time[now]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next =0;
                if(i == 0) next = now + 1;
                if(i == 1) next = now - 1;
                if(i == 2) next = now * 2;

                if (0 > next || next > 100000) {
                    continue;
                }

                if (next == K) {
                    min = time[now];
                    count++;//도착한 경우의수
                }

                if (time[next] == 0 || time[next] == time[now] + 1) {
                    Q.offer(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        N = kb.nextInt(); //2
        K = kb.nextInt(); //4
        time = new int[100001];
        if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }
        main.BFS();
        System.out.println(min);
        System.out.println(count);
    }
}