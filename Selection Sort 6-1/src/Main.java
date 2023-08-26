import java.util.*;

//    13 5 11 7 23 15
class Main {
    public int[] solution(int n, int[] arr) { //
        int result = 0, tmp = 0;
        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;
    }

    // 6
    // 13 5 11 7 23 15
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int i : main.solution(n, arr)) {
            System.out.print(i + " ");
        }

        // Hashtable.replace(key, value);

    }
}