import java.util.*;
class Main {
    //0.stack을 전역변수로 생성
    static Stack<Character> stack = new Stack<>();

    public String solution(String s){
        String answer = "";
        //1.문자열로 foreach stack에 push해 갑니다.
        for(Character c : s.toCharArray()){
            //1-1.>를 만나면 Operate 함수를 호출합니다.
            if(c == ')') {
                operate();
            }else {
                stack.push(c);
            }
        }
        //2.입력이 끝나면 스택에 남은 애들을 answer뒤로 붙여줍니다.
        for(int i = 0; i < stack.size(); i++){
            answer += stack.get(i);
        }

        return answer;
    }
    //3.operate 함수 생성
    public static void operate(){
        String tmpResult = "";
        String result = "";
        //3-1 while() 반복하면서 pop
        while(true){
            Character tmp = stack.pop();
            //3-2 만약 숫자가 나오면 숫자만큼 tmpResult를 반복해준다.
            if(Character.isDigit(tmp)){
                for(int i = 0; i < (int)(tmp - '0');i++) {
                    result += tmpResult;
                }
                for(Character c : result.toCharArray()){
                    stack.push(c);
                }
                return;
            }else if(Character.isAlphabetic(tmp)) {
                tmpResult = tmp + tmpResult ;
            }
        }

    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}