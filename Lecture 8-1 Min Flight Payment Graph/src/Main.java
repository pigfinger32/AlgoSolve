import java.util.*;
class Main {
    public int solution(int n, int[][] flights, int s, int e, int k){
        //1.그래프를 만든다
        ArrayList<ArrayList<int []>> graph = new ArrayList<>();
        for(int i =0; i < n; i++){
            graph.add(new ArrayList<int[]>());
        }
        //2.코스트 배열을 만들고, 값의 크기만큼 생성, 가장큰값으로 설정
        int[] costs = new int[n];
        Arrays.fill(costs,1000000000);
        // costs.fill(Integer.MAX_VALUE);
        //3.그래프 값을 채워라
        for(int[] x : flights){
            graph.get(x[0]).add(new int[] {x[1], x[2]});
        }
        //4.큐를 생성
        Queue<int[]> Q = new LinkedList<>();
        //5.시작지점을 큐에 넣어라
        Q.offer(new int[] {s,0});
        //6.cost[s]=0 시작지점의 코스트배열을 0으로 초기화해라
        costs[s] = 0;
        //7.L =0 레벨값을 초기화해라
        int L = 0;
        //8.while
        while(!Q.isEmpty()){

            //8-1 큐 사이즈만큼 333
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] tmp = Q.poll();
                int now = tmp[0];
                int nowCost = tmp[1];
                //8-2 큐에서 꺼내서 그래프의 원소의 갯수만큼 반복해
                for(int[] g : graph.get(now)){
                    //8-3 지나온 코스트 값들의 합이 코스트배열의 값보다 작으면 초기화해줘.
                    int next = g[0];
                    int nextCost = g[1];
                    if(nowCost+nextCost < costs[next]){
                        costs[next] = nowCost+nextCost;
                        Q.offer(new int[] {next, costs[next]});
                    }
                }
            }
            //8-4 L++;
            L++;
            //8-5 만약 환승횟수를 넘기면 break L은 탑승횟수 k가 2면 탑승횟수는 3
            if(L > k){
                break;
            }
        }
        //9.cost[e]배열의 값이 max이면 도착하지 않은것이니 return -1 아니면 값을 출력
        if(costs[e] == 1000000000){
            return -1;
        }else {
            return costs[e];
        }
    }


    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}