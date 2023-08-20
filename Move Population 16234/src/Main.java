import java.util.*;
class Main {
    static int[][] A;
    static int N, L, R;
    static int cnt = 0;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    public boolean MovePopul(){
        //1.모든 나라를 기준으로 한번씩
        List<List<Point>> list = new ArrayList<>();
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                //2.연합을 만들자
                Point cur = new Point(i,j,A[i][j]);
                List<Point> union = null;
                if(!list.isEmpty()){//연합리스트가 있으면 찾아
                    for(List<Point> uni : list){
                        if(uni.contains(cur)){
                            union = uni;
                        }
                    }
                }

                //연합리스트에 포함되지 않거나 없으면
                if(union == null){
                    union = new ArrayList<>();
                    union.add(cur);
                }
                //3.4방향을 기준으로 연합을 확인하자.
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx>=0 && nx<N && ny>=0 && ny < N
                            && Math.abs(A[i][j] - A[nx][ny]) >= L && Math.abs(A[i][j] - A[nx][ny]) <= R ){
                        Point p = (new Point(nx,ny,A[nx][ny]));
                        if(!union.contains(p)){//우리 같은 union에 포함되어 있지 않으면 추가
                            union.add(p);
                        }
                    }
                }
                //*연합이 생성되면 연합리스트에 추가.
                if(union.size() > 1){
                    list.add(union);
                }
            }
        }
        //4.연합들을 기준으로 인구를 이동시키자.
        for(List<Point> union : list){
            int sum = 0, popul = 0;
            for(Point point : union)
                sum += point.num;
            popul = sum/union.size();
            for(Point point : union)
                A[point.x][point.y] = popul;

        }
        //5.연합의 수가 생기지 않으면 끝. return false;
        if(list.isEmpty()){
            return false;
        }else
            return true;


    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        L = kb.nextInt();
        R = kb.nextInt();
        A = new int[N][N];
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                A[i][j] = kb.nextInt();
            }
        }


        while(true){
            if(main.MovePopul() == true){
                cnt++;
            }else{
                System.out.println(cnt);
                System.exit(0);
            }

        }
    }
}
class Point {
    public int x, y, num;
    public Point(int px, int py, int pNum){
        this.x = px;
        this.y = py;
        this.num = pNum;
    }
    @Override
    public boolean equals(Object obj){
        Point tmpOb = (Point)obj;
        if(this.x == tmpOb.x && this.y == tmpOb.y
                && this.num == tmpOb.num)
            return true;
        else
            return false;
    }

}