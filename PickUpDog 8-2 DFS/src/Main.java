
import javax.naming.PartialResultException;
import java.util.*;

public class Main {
    static int answer = Integer.MIN_VALUE;
    static int c = 0,n=0;

    public void DFS(int L, int sum, int[] arr) { //
        if(sum > c) return;
        if (L == n) {
            answer = Integer.max(answer, sum);
        }else {
            DFS(L + 1, sum + arr[L], arr);//태우고 DFS 돌리고
            DFS(L + 1, sum, arr);         //태우지 않고 DFS 돌리고
        }
    }
    //259 5
    // 81
    // 58
    // 42
    // 33
    // 61

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        main.DFS(0, 0, arr);
        System.out.println(answer);

        //Hashtable.replace(key, value);

    }
}