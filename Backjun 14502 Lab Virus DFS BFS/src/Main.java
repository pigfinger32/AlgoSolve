import java.util.*;

public class Main {
    static int N, M;
    static int count = Integer.MIN_VALUE;
    static int[][] ch;
    static Point[] pm;
    static int[][] arr, tmpArr;
    static List<Point[]> wallList;
    static List<Point> virusList;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

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
        tmpArr = new int[N][M];
        wallList = new ArrayList<>();
        virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int value = kb.nextInt();
                arr[i][j] = value;
                if (value == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        main.DFS(0);//수열만들기
        for (Point[] points : wallList) {
            //1.배열복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tmpArr[i][j] = arr[i][j];
                }
            }
            //2.arr에 벽을 그려넣기
            for (Point point : points) {
                tmpArr[point.x][point.y] =1;
            }
            //3.foreach 바이러스를 하나씩 꺼내서 바이러스 감염시켜본다.
            for (Point virus : virusList) {
                Queue<Point> Q = new LinkedList<>();
                //Queue<Point> pQQ = new LinkList<>();
                Q.add(virus);
                while (!Q.isEmpty()) {
                    Point vir = Q.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = vir.x + dx[i];
                        int ny = vir.y + dy[i];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && tmpArr[nx][ny] == 0 ) {
                            Q.add(new Point(nx, ny));
                            tmpArr[nx][ny] = 2;
                        }
                    }
                }
            }
            int zeroCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tmpArr[i][j] == 0) {
                        zeroCount++;
                    }
                }
            }
            count = Integer.max(count, zeroCount);
        }
        System.out.println(count);
    }
}

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
