import java.util.Scanner;

public class Main {
    static int n, m;
    static int ans=0;
    static char[][] board;
    static Point R, B, O;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void DFS(int L, int curRx, int curRy, int curBx, int curBy) {
        if (L > 10) {
            System.out.println("0");
            System.exit(0);
        }
        if (ans == 1) {//Red도착, Blue 도착X
            System.out.println("1");
            System.exit(0);
        } else {
            for (int i = 0; i < 4; i++) {
                move(R, i); // Red 끝까지 간다.
                move(B, i); // Blue 끝까지 간다.
                int type = check();//0: 실패, 1: 성공, 2: 빈칸
                if (type == 0) {
                    continue;
                } else if (type == 1) {
                    // 정답
                    ans = 1;
                    return;
                } else {//겹쳤을 경우 상일땐 블루가 한칸아래, 하일때 블루가 한칸 위, 좌일때 블루가 한칸 오른쪽, 우일때 블루가 한칸 왼쪽
                    if (R.x == B.x && R.y == B.y) {
                        if (i == 0) {//상
                            if (curRx < curBx) {//Red가 원래 위였다면
                                B.x += 1;
                            } else {//Red가 아래였다면
                                R.x += 1;
                            }
                        } else if (i == 2) {//하
                            if (curRx > curBx) {//Red가 아래였다면
                                B.x -= 1;
                            } else {//Red가 아래라면
                                R.x -= 1;
                            }
                        } else if (i == 3) {//좌
                            if (curRy < curBy) {//Red가 원래 좌측였다면
                                B.y += 1;
                            } else {//Red가 우측였다면
                                R.y += 1;
                            }

                        } else if (i == 1) {//우
                            if (curRy > curBy) {//Red가 원래 우측였다면
                                B.y -= 1;
                            } else {//Red가 좌측였다면
                                R.y -= 1;
                            }
                        }
                    }
                }
            }
        }
        DFS(L + 1, R.x,R.y,B.x,B.y);
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        n = kb.nextInt(); //2
        m = kb.nextInt(); //4
        kb.nextLine();
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = kb.nextLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'R') {
                    R = new Point((i), j);
                    board[i][j] = '.';
                } else if (str.charAt(j) == 'B') {
                    B = new Point((i), j);
                    board[i][j] = '.';
                } else if (str.charAt(j) == 'O') {
                    O = new Point((i), j);
                }
                //board[i][j] = str.charAt(j) - 'A';
                board[i][j] = str.charAt(j);
            }
        }
        main.DFS(0,R.x,R.y,B.x,B.y);
    }
    static void move(Point cur, int i) {
        int nx = cur.x;
        int ny = cur.y;
        while (true) {
            nx += dx[i];
            ny += dy[i];
            if (board[nx][ny] == '#') {
                nx -= dx[i];
                ny -= dy[i];
                break;
            } else if (board[nx][ny] == 'O') {
                break;
            }
        }
        cur.x = nx;
        cur.y = ny;
    }
    static int check() {
        if (board[R.x][R.y] == 'O' && board[B.x][B.y] == 'O') {
            return 0;
        }
        if (board[R.x][R.y] == 'O' && board[B.x][B.y] != 'O') {
            return 1;
        }
        if (board[R.x][R.y] != 'O' && board[B.x][B.y] == 'O') {
            return 0;
        }
        if (board[R.x][R.y] != 'O' && board[B.x][B.y] != 'O') {
            return 2;
        }
        return 0;
    }
}


class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}