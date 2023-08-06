import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[][] origin, board ;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public void BFS(int H) {
        //origin -> board로 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = origin[i][j];
            }
        }

        Queue<Point> Q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > H) {
                    Q.add(new Point(i, j));
                    cnt++;
                    while (!Q.isEmpty()) {
                        Point cur = Q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] > H) {
                                Q.offer(new Point(nx, ny));
                                board[nx][ny] = 0;
                            }
                        }
                    }
                }
            }
        }
        //System.out.println("H = " + H + " cnt = " + cnt);
        max = Math.max(max, cnt);
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        origin = new int[N][N];
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                origin[i][j] = kb.nextInt();
            }
        }
        for (int i = 0; i < 100; i++) {
            main.BFS(i);
        }
        System.out.println(max);
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
