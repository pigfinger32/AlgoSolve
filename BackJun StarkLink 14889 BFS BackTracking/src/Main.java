import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Boolean[] visit;
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] arr;
    public void BFS(int L, int start){
        //Boolean visit[] 배열을 통해 팀을 선정(방문으로 start팀을 선정)
        if (L == (N / 2)) {
            //팀이 모두 완성됫으면 점수를 계산해서 최소값을 구해요
            diff();
            return;
        } else {
            for (int i = start; i < N; i++) {
                visit[i] = true;
                BFS(L + 1, i + 1);
                visit[i] = false;
            }
        }
    }
    public void diff() {
        //팀끼리 값을 더해서 최소값을 출력해주세요. 최소값이 0이면 프로그램 종료
        int stark = 0, link = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {//스타크팀일때
                    stark += arr[i][j] + arr[j][i];
                } else if (visit[i] == false && visit[j] == false) { // 링크팀
                    link +=  arr[i][j] + arr[j][i];
                }
            }
        }
        min = Math.abs(stark - link);
        if (min == 0) {
            System.out.println(min);
            System.exit(0);
        }
        answer = Math.min(min, answer);
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        visit = new Boolean[N];
        Arrays.fill(visit, false);
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        main.BFS(0, 0);
        System.out.println(answer);
    }
}
