import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;
    static boolean[] alpha;

    public void DFS(int x, int y, int len) {
        alpha[board[x][y]] = true;
        max = Math.max(max, len);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((nx < n) && (nx >= 0) && (ny < m) && (ny >= 0)) {
                if (alpha[board[nx][ny]] == false) {
                    DFS(nx, ny, len + 1);
                    alpha[board[nx][ny]] = false;
                }

            }
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        n = kb.nextInt(); //2
        m = kb.nextInt(); //4
        kb.nextLine();
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = kb.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }
        alpha = new boolean[26]; //알파벳을 이전에 방문했는지 여부 체크.
        main.DFS(0, 0, 1);
        System.out.println(max);
    }
}