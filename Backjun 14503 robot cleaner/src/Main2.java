import java.util.Scanner;

public class Main2 {
    static int N, M;
    static int count = 0;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};// 북,동,남,서
    static int[] dy = {0, 1, 0, -1};

    public void clean(int x, int y, int dir) {
        //01.clean
        if (board[x][y] == 0) {
            board[x][y] = 2;
            count++;
        }
        //02.네방향중 한방향 찾아서 재귀함수
        int originalDir = dir;
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int nDir = (dir + 3) % 4;
            int nx = x + dx[nDir];
            int ny = y + dy[nDir];
            if (nx > 0 && nx < N && ny > 0 && ny < M) {
                if (board[nx][ny] == 0) {
                    flag = true;//반향이라도 비었있는 곳이 있었음 ㅎㅎ
                    clean(nx, ny, nDir);
                    break;//한방향으로 쭉 가게 하기 위함.
                }
            }
            dir = (dir + 3) % 4; //첫방향이 비어있지 않은경우 방향 파라미터 방향값 바꿔주고 다시 입력되게끔
        }
        if (flag == false) {//4방향 한방향도 청소를 못했따면? 뒤로가자
            int nDir = (originalDir + 2) % 4;
            int bx = x + dx[nDir];
            int by = y + dy[nDir];
            if (bx > 0 && bx < N && by > 0 && by < M) {
                if (board[bx][by] != 1) {//벽이아니면 뒤로던져줘
                    clean(bx, by, originalDir);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main2 main = new Main2();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();//11 세로
        M = kb.nextInt();//10 가로
        int x = kb.nextInt();//
        int y = kb.nextInt();
        int dir = kb.nextInt();
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        main.clean(x, y, dir);
        System.out.println(count);
    }
}
