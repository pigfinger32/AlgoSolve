import java.util.*;

class Main {
    //(A(BC)D)EF(G(H)(IJ)K)LM(N)
    public String solution(String str) { //
        String result = "";
        Stack<Character> stack = new Stack<>();
        for(char c:str.toCharArray()){
            if(c == ')'){
                while(stack.pop() != '(');
            }
            else{
                stack.push(c);
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            result += stack.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(main.solution(str));

        //Hashtable.replace(key, value);

    }
}