import java.util.*;
class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] cur = new int[2];
    static int N =0;

    public void DFS(int L, int x, int y, int dir, int k, int[][] board){
        if(L == k){//1.k초에 도달했다면 현재위치를 리턴하세요.
            cur[0] = x; cur[1] = y;
            return;
        }else {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            //벽이 아닐때 전진
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 0) {
                DFS(L+1, nx, ny, dir, k, board);
            } else {
                //벽이거나 보드판을 넘어갔을 경우 방향전환
                int nDir = (dir+1)%4;
                DFS(L+1, x, y, nDir, k, board);
            }

        }
    }
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        N = board.length;
        int curDir = 1;//오른쪽 
        DFS(0, 0, 0, curDir, k, board);
        answer = cur;

        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}