import java.util.*;
class Main {
    public int solution(int[][] routes, int s, int e){
        int answer = 0;
        //1.그래프를 생성
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;
        for(int i =0; i < n; i++){
            for(int x : routes[i]){
                graph.putIfAbsent(x, new HashSet<Integer>());
                graph.get(x).add(i);
            }
        }
        //2.Q를생성
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        //3.check 배열을 생성
        int[] check = new int[n];
        int L = 0;
        //4.while()
        while(!Q.isEmpty()) {
            //4-1 Q 사이즈만큼 반복
            int len = Q.size();
            for(int i = 0; i < len; i++){
                //4-2 현재 멈춘 역에 연결된 환승호선을 모두 조회
                int curStop = Q.poll();
                for(int line : graph.get(curStop)){
                    //4-2-1 if Check(line) == 0 환승line을 Q돌리지 않았다면 모두 Q에 추가해
                    if(check[line] == 1) continue;
                    check[line] = 1;
                    for(int stop : routes[line]){
                        //4-2-2 line의 역이 destination과 일치하면 L을 리턴
                        if(stop == e) return L;
                        //4-2-3 모두 Q에 추가해
                        Q.offer(stop);
                    }
                }
            }
            //5.L++;
            L++;
        }
        //6.만약 환승역을 못찾았으면 -1
        return -1;


    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}