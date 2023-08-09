import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N =5;
    static int[][] board = new int[N][N];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static HashSet<String> hs = new HashSet<>();

    public void BFS(PointStr start) {
        Queue<PointStr> Q = new LinkedList<>();
        Q.add(start);

        while (!Q.isEmpty()) {
            PointStr cur = Q.poll();
            if (cur.str.length() == 6) {
                hs.add(cur.str);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
//                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
//                    Q.add(new PointStr(nx, ny, cur.str + (board[nx][ny])));
//                }
                if(nx < 0 || 5 <= nx || ny < 0 || 5 <= ny) {
                    continue;
                }

                Q.add(new PointStr(nx, ny, cur.str + (board[nx][ny])));
            }

        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                main.BFS(new PointStr(i, j, Integer.toString(board[i][j])));
            }
        }

        System.out.println(hs.size());
    }
}

class PointStr {
    public int x,y;
    public String str;

    public PointStr(int x, int y, String str) {
        this.x = x;
        this.y = y;
        this.str = str;
    }
}
