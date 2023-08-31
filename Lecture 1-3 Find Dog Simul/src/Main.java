import java.util.*;
class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Point cur;
    public int solution(int[][] board){
        int answer = 0;
        int dir = 0;
        //1.현수의 위치를 찾는다.
        for(int i =0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(board[i][j] == 2){
                    cur = new Point(i,j);
                }
            }
        }
        //2.while
        while(true){
            //2-0 answer가 10000을 넘으면 return -1
            if(answer > 10000)
                return -1;
            //2-1 next 위치를 구한다.
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];

            //2-2-1 벽밖을 나갔거나, 나무이면 방향전환, answer++;
            if(nx < 0 || nx >= 10 || ny < 0 || ny >= 10 || board[nx][ny] == 1 ){
                dir = (dir + 1) % 4;
                answer++;
            }//2-2-2 개를 만나면 return answer;
            else if(board[nx][ny] == 3){
                return answer;
            }//2-2-3 빈공간이면 cur = next, answer++;
            else if(board[nx][ny] == 0){
                cur.x = nx;
                cur.y = ny;
                answer++;

            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
class Point{
    public int x;
    public int y;
    public Point(int px, int py){
        this.x = px;
        this.y = py;
    }
}