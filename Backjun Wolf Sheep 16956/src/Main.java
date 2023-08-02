import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int R, C;
    static int check = 1;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] board;
    static ArrayList<Point> S = new ArrayList<>();
    static ArrayList<Point> W = new ArrayList<>();

    public void solution() {
        for (int i = 0; i < S.size(); i++) {
            for (int j = 0; j < W.size(); j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = S.get(i).x + dx[k];
                    int ny = S.get(i).y + dy[k];
                    if (nx == W.get(j).x && ny == W.get(j).y) {
                        check = 0;
                        return;
                    } else {
                        if (nx < R && nx >= 0 && ny < C && ny >= 0 && board[nx][ny] != 'S') {
                            board[nx][ny] = 'D';
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        R = kb.nextInt();
        C = kb.nextInt();
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = kb.next();
            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                if (c == 'W') {
                    W.add(new Point(i, j));
                } else if (c == 'S') {
                    S.add(new Point(i, j));
                }
                board[i][j] =c;
            }
        }
        main.solution();
        if (check == 0) {
            System.out.println(check);
        } else {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < R; j++) {
                    System.out.print(board[i][j] +" ");
                }
                System.out.println();
            }
        }
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
