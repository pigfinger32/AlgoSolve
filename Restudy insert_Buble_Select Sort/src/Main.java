import java.util.*;

class Main {
    public int[] solution(int n, int[] arr) { //
        int tmp = 0;
        for(int k = 0; k < n; k ++){
            for (int i = 0; i < n-1; i++) {
                if(arr[i] > arr[i+1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }

        return arr;
    }

    public int[] buble(int n, int[] arr){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }

    public int[] insertSort(int n, int[] arr){
        for(int i =1; i < n; i++){
            int target = arr[i];
            int j = i-1;

            while(j >= 0 && target < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = target;
        }

        return arr;
    }

    public int[] selectSort(int n, int[] arr){
        for(int i = 0; i < n; i++){
            int minIdx = i;
            for(int j = i+1; j < n; j++){
                if(arr[minIdx] > arr[j]){
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
        return arr;
    }
//    6
//    13 5 11 7 23 15
//    5 7 11 13 15 23

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i =0; i< n;i++){
            arr[i] = kb.nextInt();
        }
        for(int i : main.selectSort(n,arr)){
            System.out.print(i + " ");
        }

        //Hashtable.replace(key, value);

    }
}