import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int N,A,B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int A = sc.nextInt(), B = sc.nextInt();
            boolean[] visit = new boolean[10000];
            visit[A] = true;

            Queue<Register> que = new LinkedList<>();
            que.add(new Register(A, ""));

            String ans = "";

            while (!que.isEmpty()) {
                Register cur = que.poll();
                if (cur.num == B) {
                    System.out.println(cur.command);
                    break;
                }

                if (!visit[cur.D()]) {
                    que.offer(new Register(cur.D(), cur.command + "D"));
                    visit[cur.D()] = true;
                }
                if (!visit[cur.S()]) {
                    que.offer(new Register(cur.S(), cur.command+"S"));
                    visit[cur.S()] = true;
                }
                if (!visit[cur.L()]) {
                    que.offer(new Register(cur.L(), cur.command+"L"));
                    visit[cur.L()] = true;
                }
                if (!visit[cur.R()]) {
                    que.offer(new Register(cur.R(), cur.command+"R"));
                    visit[cur.R()] = true;
                }


            }
        }
    }
    public static class Register {
        int num;
        String command;

        public Register(int num, String command) {
            this.num = num;
            this.command = command;
        }
        public int D() {
            return (num * 2) % 10000;
        }
        public int S() {
            return num == 0 ? 9999 : num - 1;
        }
        public int L() {
            return num % 1000 * 10 + num / 1000;
        }
        public int R() {
            return num % 10 * 1000 + num / 10;
        }


    }
}
