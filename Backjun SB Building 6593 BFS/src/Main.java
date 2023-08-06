import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int L, R, C;
    static int min = Integer.MAX_VALUE;
    static Point S;
    static char bd[][][];
    static int visit[][][];
    static int[] dC = {1, -1, 0, 0, 0, 0};
    static int[] dR = {0, 0, 0, 0, 1, -1};
    static int[] dL = {0, 0, -1, 1, 0, 0};
    public void BFS() {
        int cnt = 0;
        Queue<Point> Q = new LinkedList<>();
        Q.offer(S);
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    while (!Q.isEmpty()) {
                        Point cur = Q.poll();
                        cnt++;
                        for (int a = 0; a < 6; a++) {
                            int nc = cur.c + dC[a];
                            int nr = cur.r + dR[a];
                            int nl = cur.l + dL[a];
                            if (nc >= 0 && nc < C && nr >= 0 && nr < R && nl >= 0 && nl < L) {
                                if (visit[nc][nr][nl] == 0 && bd[nc][nr][nl] == 'E') {//출구찾음
                                    visit[nc][nr][nl] = 1;
                                    min = Math.min(min, cnt);
                                } else if(visit[nc][nr][nl] == 0 && bd[nc][nr][nl] == '.') {//문찾음
                                    visit[nc][nr][nl] = 1;
                                    Q.offer(new Point(nc, nr, nl));
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        L = kb.nextInt();
        R = kb.nextInt();
        C = kb.nextInt();
        bd = new char[L][R][C];
        visit = new int[L][R][C];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String str = kb.next();
                for (int k = 0; k < C; k++) {
                    bd[i][j][k] = str.charAt(k);
                    if (str.charAt(k) == 'S') {
                        S = new Point(i, j, k);
                    }
                }
            }
        }
        main.BFS();
        if (min == Integer.MAX_VALUE) {
            System.out.println("Trapped!");
        } else {
            System.out.println("Escaped in "+ min + " minute(s).");
        } 
    }
}

class Point {
    int l ,r, c;

    public Point(int l, int r, int c) {
        this.l = l;
        this.r = r;
        this.c = c;
    }
}
