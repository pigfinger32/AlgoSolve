import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int count = 0;
    static int[][] board, visit;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static Point cur;
    public void solution() {
        while (true) {
            if (board[cur.x][cur.y] == 0) {//현재 위치가 0이면 청소해
                if (visit[cur.x][cur.y] == 0) {//방문 안했으면 청소
                    visit[cur.x][cur.y] = 1;
                    count++;
                }
            }
            if (haveBlank(cur) == false) {//빈칸이 없으면?
                if (checkBackWall() == true) {//checkWall 뒤에 벽이있는지? 있으면 끝/ 없으면 move까지 포함
                    System.out.println(count);
                    System.exit(0);
                }
            } else {//빈칸이 있으면?
                //90도 회전
                if (cur.dir < 3) {//dir 0, 1, 2일때
                    cur.dir = cur.dir + 1;
                }else {//dir 3일때
                    cur.dir = cur.dir - 3;
                }
                int nx = cur.x + dx[cur.dir];
                int ny = cur.y + dy[cur.dir];
                //만약 앞칸이 비어있으면?
                if (board[nx][ny] == 0 && visit[nx][ny] == 0) {
                    //move
                    cur.x = nx;
                    cur.y = ny;
                }

            }
        }
    }
    public boolean checkBackWall() {
        boolean wall = true;
        int dir;
        if (cur.dir < 2) {//dir 0, 1일때
            dir = cur.dir + 2;
        }else {//dir 2,3일때
            dir = cur.dir - 2;
        }
        int nx = cur.x + dx[dir];
        int ny = cur.y + dy[dir];

        if (board[nx][ny] == 0) {//벽이 아니면? 뒤로 움직임.
            wall = false;
            cur.x = nx;
            cur.y = ny;
        }

        return wall;
    }

    public boolean haveBlank(Point point) {
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];
            if (board[nx][ny] == 0 && visit[nx][ny] == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();//11 세로
        M = kb.nextInt();//10 가로
        int x = kb.nextInt();//
        int y = kb.nextInt();
        int dir = kb.nextInt();
        cur = new Point(x, y, dir);
        board = new int[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        main.solution();

    }
}

class Point {
    public int x, y, dir;

    public Point(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
