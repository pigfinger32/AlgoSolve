import java.util.*;
class Main {
    public int solution(int n){
        int answer = -1;
        //1.입력된 숫자의 자리수를 만큼 check배열과 arr배열을 선언
        String tmpStr = Integer.toString(n);
        int size = tmpStr.length();
        check = new boolean[size];
        arr = new int[size];
        //2.다음함수진행을 위한 초기화
        find = false;
        findAnswer = 0;
        //3.오름차순
        for(int i = 0; i < size; i++){
            arr[i] = tmpStr.charAt(i) - '0';
        }
        Arrays.sort(arr);
        //4.DFS
        DFS(0,0,n,size);
        //5.찾았으면 값을 리턴, 못찾았으면 -1 리턴
        if(find == true){
            return findAnswer;
        } else{
            return answer;
        }
    }
    public void DFS(int L, int number,int n, int size){
        //1.가장 가까운 큰수를 찾았을때
        if(find == true)
            return;

        //2.수열을 완성했을때
        if(L == size){
            if(number > n){
                find = true;
                findAnswer = number;
            }else
                return;
        } else{ //3.수열 못만들었을때
            for(int i = 0; i < size; i++){
                if(check[i] == false){
                    check[i] = true;
                    DFS(L+1, number * 10 + arr[i],n,size);
                    check[i] = false;
                }
            }

        }
    }

    static int[] pm ;
    static boolean[] check;
    static int[] arr;
    static boolean find;
    static int findAnswer = 0;
    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}