import java.util.Arrays;
import java.util.Scanner;
public class Main {
    static int[] dy, ps, pt;

    static int n,m;

    public void solution(int[] ps, int[] pt) {
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= pt[i]; j--) {
                dy[j] = Math.max(dy[j - pt[i]] + ps[i], dy[j]);
            }
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb=new Scanner(System.in);
        n = kb.nextInt();//문제수
        m = kb.nextInt();//시간
        ps = new int[n];
        pt = new int[n];
        dy = new int[m+1];
        Arrays.fill(dy, 0);
        for (int i = 0; i < n; i++) {
            ps[i] = kb.nextInt();
            pt[i] = kb.nextInt();
        }
        main.solution(ps, pt);
        System.out.println(dy[m]);
    }
}