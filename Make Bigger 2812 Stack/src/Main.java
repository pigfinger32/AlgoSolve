import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();//7
        int K = kb.nextInt();//3
        String input = kb.next();
        int cnt = 0;
        //1231234
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < N; i++){
            int num = Character.getNumericValue(input.charAt(i));
            //1.첫번째 숫자는 무조건 push
            if(i==0)
                st.push(num);
            else{
                int top = st.peek();
                //2.제거하는 횟수가 K보다 작으면?
                if(cnt < K){
                    //3.스택의 상단값이 넣으려는 값보다 작으면 pop
                    if(top < num) {
                        //4.pop And push
                        st.pop();
                        st.push(num);
                        cnt++;
                    }else {//넣으려는 값이 더 작으면 스킵하지만 count는 증가
                        cnt++;
                    }
                } else{
                    //4.push
                    st.push(num);
                }

            }
        }
        for(int i =0;i<st.size();i++){
            System.out.print(st.get(i));
        }

    }
}