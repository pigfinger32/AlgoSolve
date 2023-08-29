import java.util.*;
class Main {
    public int solution(int[] nums){

        //1.변수 선언
        int answer = Integer.MAX_VALUE;
        int goal = nums.length;
        boolean[] check = new boolean[goal];
        //2.현재위치 Q에 넣기
        Queue<Tile> Q = new LinkedList<>();
        Q.add(new Tile(0,nums[0],0));
        check[0] = true;
        //3.while
        while(!Q.isEmpty()){
            Tile cur = Q.poll();
            int p = cur.position;
            int n = cur.num;
            int L = cur.Level;
            //4.상점에 도착했는지 체크. 마지막까지 갔는지?
            if(p == goal-1){
                answer = Math.min(answer, L);
            } else {//5.도착하지 않았다면 타일의 수만큼 Q에 add하고,중복된 타일이 있다면 pass
                for(int i = p+1; i <= p + n; i++){
                    //6.타일을 넘어가지 않으면서, 한번 건넌 타일은 건널 필요없음.
                    if(i < nums.length && check[i] == false){
                        Q.add(new Tile(i, nums[i],L+1));
                        check[i] = true;
                    }
                }
            }
        }

        if(answer == Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
class Tile{
    public int position;
    public int num;
    public int Level;
    public Tile(int p, int n,int L){
        this.position = p;
        this.num = n;
        this.Level = L;
    }
}