import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        //1.while()
        while(true){
            int n = kb.nextInt();
            double m = kb.nextDouble();
            //2.0개의 사탕이 입력되면? 종료
            if(n == 0)
                break;
            //3.소수점의 용돈을 dy배열을 선언하기 위해 100을 곱해서 round 해주자. 
            int size = (int)Math.round(m * 100);
            int[] dy = new int[size+1];

            //4.배열 0으로 초기화
            Arrays.fill(dy,0);
            //5.사탕의 개수만큼 냅색 알고리즘 
            for(int i =0; i < n; i ++){
                int cal = kb.nextInt();
                double cost = kb.nextDouble();
                int start = (int)Math.round(cost * 100);
                for(int j = start; j < size+1; j++){
                    //5-1 dy배열에서 동전 계산
                    int tmpCal = dy[j-start] + cal;
                    //5-2 만약 dy배열보다 계산된 칼로리가 높다면? 바꿔줘
                    if(dy[j] < tmpCal){
                        dy[j] = tmpCal;
                    }
                }
            }
            //용돈의 최대 칼로리를 출력
            System.out.println(dy[size]);

        }

    }
}