import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String line = kb.next();
        String bomb = kb.next();
        int bombLen = bomb.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < line.length();i++){
            st.push(line.charAt(i));

            //1.스택의 사이즈가 폭탄 문자열보다 길때
            if(st.size() >= bombLen){
                boolean flag = true;
                for(int j =0; j < bombLen;j++){
                    if(st.get(st.size()-bombLen+j) != bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                //2.폭탄일 경우 문자열의 길이만큼 pop해줍니다.
                if(flag == true){
                    for(int k = 0; k < bombLen; k++)
                        st.pop();
                }
            }
        }
        //3.StringBuilder append
        StringBuilder sb = new StringBuilder();
        for(Character c : st) {
            sb.append(c);
        }
        System.out.println(sb.length()==0? "FRULA" : sb.toString());



    }
}