import java.util.*;
class Main {
    public int solution(int[] pool, int a, int b, int home){
        //1.체크배열을 앞 뒤로 생성하자
        int answer = Integer.MAX_VALUE;
        int[][] check = new int[2][10001];

        //2.웅덩이는 미리 간곳으로 체크하자
        for(int x : pool){
            check[0][x] = 1;
            check[1][x] = 1;
        }
        //3.Q생성, 앞뒤 모두 체크, 시작위치 Q에 넣자. Q는 0번은 위치,두번째는 앞 뒤체크)
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0,0});
        check[0][0] = 1;
        check[1][0] = 1;
        //4.L 초기화
        int L = 0;
        //5.while() 시작
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i ++ ){
                int[] cur = Q.poll();
                //5-1 cur 위치가 home이면 return
                if(cur[0] == home) return L;
                //5-2 앞으로 점프
                int nx = cur[0] + a;
                if(nx <= 10001 && check[0][nx] == 0){
                    Q.offer(new int[]{nx,0});
                }
                //5-3 뒤로점프
                nx = cur[0] - b;
                if(nx > 0 && check[1][nx] == 0 && cur[1] == 0){
                    Q.offer(new int[]{nx,1});
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}