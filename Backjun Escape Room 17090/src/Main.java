import java.util.Scanner;

public class Main {
    static int N, M;
    static int count = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
//    3 3
//    RRD
//    RDD
//    ULL

    public static boolean dfs(int row, int col) {
        boolean result = false;
        //1.미로를 벗어났다면
        if (row < 0 || row > N-1 || col < 0 || col > M-1) {
            return true;
        }
        if (map[row][col]=='T')return true;
        else if (map[row][col]=='F')return false;

        //2번방문하면 돌고있는것이니 종료
        if (visited[row][col] == true) {
            return false;
        }
        //2.방문처리
        visited[row][col] = true;
        //3.방향을 정하고
        int dir = 0;
        if (map[row][col] == 'U')  dir = 0;
        else if(map[row][col] == 'R')  dir = 1;
        else if(map[row][col] == 'D')  dir = 2;
        else if(map[row][col] == 'L')  dir = 3;
        int nx = row + dx[dir];
        int ny = col + dy[dir];
        //4.재귀
        result = dfs(nx, ny);
        map[row][col] = result ? 'T' : 'F';

        return result;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) map[i] = kb.next().toCharArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j) == true) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
