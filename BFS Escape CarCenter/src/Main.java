import java.util.*;
class Main {
    static int[][] board;
    static int N,M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public int BFS(Point start){
        int answer = -1;//탈출 불가능일때
        int minRed = Integer.MAX_VALUE;
        int red = 0;
        Queue<Point> Q = new LinkedList<Point>();
        Q.add(start);
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            //board[tmp.x][tmp.y] = -1;//들어옴을 표시
            //0.출구를 만났다면?
            if(board[tmp.x][tmp.y]==4){
                if(red == 0){//
                    return 0;
                }else {
                    minRed = Integer.min(minRed,red);
                }
            }
            else {
                for(int i =0; i < 4; i ++){
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if(nx>=0 && nx < N && ny>=0 && ny < M &&
                            board[nx][ny] == 0 ||board[nx][ny] == 1) {
                        Q.add(new Point(nx, ny));
                    }
                }
            }
        }
        //모든탐색이 끝나고 
        if(minRed == Integer.MAX_VALUE){
            return answer;
        }else {
            return minRed;
        }
    }
}
class Point {
    int x, y;
    public Point(int px, int py) {
        this.x = px;
        this.y = py;
    }
}