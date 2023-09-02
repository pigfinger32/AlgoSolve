import java.util.*;
//5 9
//1 2 3 2 6 2 3 5 7
class Main {
    public String solution(int n, int[] arr) { //
        String result = "";
        int[] tmp = new int[n];
        tmp = arr.clone();
        Arrays.sort(tmp);
        for(int i = 0; i < n; i++){
            if(arr[i] != tmp[i]){
                result += (i + 1) + " ";
            }
        }

        return result;
    }
    //  9
//  120 125 152 130 135 135 143 127 160
//  120 125 127 130 135 135 146 152 160
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i =0; i< n;i++){
            arr[i] = kb.nextInt();
        }

        System.out.println(main.solution(n,arr));


        //Hashtable.replace(key, value);

    }
}