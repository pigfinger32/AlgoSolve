import java.lang.reflect.Array;
import java.util.*;
class Main {

    static int[] fibo;
    public int DFS(int n) {
        if(fibo[n] >0) return fibo[n];//메모이제이션
        if(n == 1) return fibo[n] = 1;
        if(n == 2) return fibo[n] = 1;
        else {
            return fibo[n] = DFS(n - 2) + DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fibo = new int[n+1];
        main.DFS(n);
        for (int i = 1; i < n; i++) {
            System.out.print(fibo[i] + " ");
        }


    }
}