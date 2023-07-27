import java.util.*;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, k;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;
    static int sum = 0;
    static ArrayList<Integer> sizeArr = new ArrayList<>();
    public void BFS() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    sizeArr.add(BFS(i, j));
                    cnt++;
                }
            }
        }
    }
    public int BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        map[x][y] = 1;
        int sum = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ((nx < m) && (nx >= 0) && (ny < n) && (ny >= 0) && (map[nx][ny] == 0)) {
                    q.offer(new Point(nx, ny));
                    sum++;
                    map[nx][ny] = 1;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        m = kb.nextInt();//row
        n = kb.nextInt();//col
        k = kb.nextInt();//사각형 갯수
        map = new int[m][n];
        for (int[] i : map) {
            Arrays.fill(i, 0);
        }

        for(int a =0;a<k;a++) {
            int x1 = kb.nextInt();//0
            int y1 = kb.nextInt();//2
            int x2 = kb.nextInt();//4
            int y2 = kb.nextInt();//4

            for(int i = y1; i<y2; i++)
                for(int j = x1; j<x2; j++)
                    map[i][j] = 1;
        }

        main.BFS();
        Collections.sort(sizeArr);

        System.out.println(cnt);

        for (Integer i : sizeArr) {
            System.out.print(i+ " ");
        }
    }
}