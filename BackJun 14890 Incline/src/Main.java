import java.util.*;
class Main {
    static int N, L;
    static int count = 0;
    static int[][] board;
    public boolean checkRow(int row){
        boolean[] isIncline = new boolean[N];
        for(int i = 0; i < N - 1; i++){
            int diff = board[row][i] - board[row][i+1];
            //0.다음 진행방향의 차이가 1이 아니다.
            if(diff > 1 || diff < -1) return false; //높이차 1 초과하므로 false
                //위로 향하는 경사면
            else if(diff == -1){
                for(int j = 0; j < L; j++){
                    //1.이미 경사로가 설치되어 있다.(배열의 outOfInDex를 대비)
                    if(i-j < 0 || isIncline[i - j] == true) return false;
                    //2.경사로의 길이보다 계단 길이가 짧다.
                    if(board[row][i] != board[row][i-j]) return false;
                    //3.경사로를 체크해준다.
                    isIncline[i-j] = true;
                }
            } else if(diff == 1){//아래로 향하는 경사면 전을 확인해야 해.
                for(int j = 1; j <= L; j++){
                    //1.이미 경사로가 설치되어 있다.(배열의 outOfInDex를 대비)
                    if(i+j >= N || isIncline[i + j] == true) return false;
                    //2.경사로의 길이보다 계단 길이가 짧다.
                    if(board[row][i] - 1 != board[row][i+j]) return false;
                    //3.경사로를 체크해준다.
                    isIncline[i+j] = true;

                }
            }
        }
        return true;
    }
    public boolean checkCol(int col){
        boolean[] isIncline = new boolean[N];
        for(int i = 0; i < N - 1; i++){
            int diff = board[i][col] - board[i+1][col];
            //0.다음 진행방향의 차이가 1이 아니다.
            if(diff > 1 || diff < -1) return false; //높이차 1 초과하므로 false
                //위로 향하는 경사면
            else if(diff == -1){
                for(int j = 0; j < L; j++){
                    //1.이미 경사로가 설치되어 있다.(배열의 outOfInDex를 대비)
                    if(i-j < 0 || isIncline[i - j] == true) return false;
                    //2.경사로의 길이보다 계단 길이가 짧다.
                    if(board[i][col] != board[i-j][col]) return false;
                    //3.경사로를 체크해준다.
                    isIncline[i-j] = true;
                }
            } else if(diff == 1){//아래로 향하는 경사면 전을 확인해야 해.
                for(int j = 1; j <= L; j++){
                    //1.이미 경사로가 설치되어 있다.(배열의 outOfInDex를 대비)
                    if(i+j >= N || isIncline[i + j] == true) return false;
                    //2.경사로의 길이보다 계단 길이가 짧다.
                    if(board[i][col] - 1 != board[i+j][col]) return false;
                    //3.경사로를 체크해준다.
                    isIncline[i+j] = true;

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        L = kb.nextInt();
        board = new int[N][N];
        for(int i =0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                board[i][j] = kb.nextInt();
            }
        }
        for(int i = 0 ; i < N;i++){
            if(main.checkRow(i) == true) count++;
            if(main.checkCol(i) == true) count++;
        }
        System.out.println(count);
    }
}