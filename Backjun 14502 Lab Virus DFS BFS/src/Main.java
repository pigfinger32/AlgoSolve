import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] ch;
    static Point[] pm;
    static int[][] arr;
    static List<Point[]> wallList;

    public void DFS(int L) {
        if (L == 3) {
            boolean flag = true;
            for (int i = 0; i < L; i++) {
                int nx = pm[i].x;
                int ny = pm[i].y;
                if (arr[nx][ny] != 0) {
                    flag = false;
                }
            }
            if (flag == true) {//벽을 세운곳이 모두 빈공간일경우
                wallList.add(pm.clone());
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ch[i][j] == 0) {//방문하지 않은 곳이라면
                        ch[i][j] = 1;
                        pm[L] = new Point(i, j);//벽만드는 수열 하나 추가
                        DFS(L + 1);
                        ch[i][j] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        ch = new int[N][M];
        pm = new Point[3];
        arr = new int[N][M];
        wallList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        main.DFS(0);
        for (Point[] points : wallList) {
            for (Point point : points) {
                System.out.print("(" + point.x +"," + point.y +") ");
            }
            System.out.println();
        }
    }
}

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
