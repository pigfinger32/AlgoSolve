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
    static int n;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;
    static int sum = 0;
    static ArrayList<Integer> sizeArr = new ArrayList<>();
    public void BFS() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    sizeArr.add(BFS(i, j));
                    cnt++;
                }
            }
        }
    }
    public int BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        map[x][y] = 0;
        int sum = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ((nx < n) && (nx >= 0) && (ny < n) && (ny >= 0) && (map[nx][ny] == 1)) {
                    q.offer(new Point(nx, ny));
                    sum++;
                    map[nx][ny] = 0;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        n = kb.nextInt();//nXn
        map = new int[n][n];
        //전체 사각형 입력 받기
        for(int i=0; i<n; i++){
            String input = kb.next();
            for(int j=0; j<n; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }

        main.BFS();
        Collections.sort(sizeArr);

        System.out.println(cnt);

        for (Integer i : sizeArr) {
            System.out.print(i+ " ");
        }
    }
}