import java.util.Scanner;

public class Main {
    static int n, m, answer;

    public void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if(time > m) return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + ps[L], time + pt[L], ps, pt);
            DFS(L + 1, sum, time, ps, pt);
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        int[] ps = new int[n];
        int[] pt = new int[n];
        for (int i = 0; i < n; i++) {
            ps[i] = kb.nextInt();
            pt[i] = kb.nextInt();
        }
        answer = Integer.MIN_VALUE;
        main.DFS(0, 0, 0, ps, pt);
        System.out.println(answer);
    }
}