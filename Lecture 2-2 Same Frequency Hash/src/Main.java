import java.util.*;
class Main {
    public int[] solution(String s){
        int[] answer = new int[5];
        //0.hash key값을 a,b,c,d,e 모두 0으로 초기화 해놔.
        int max = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        hash.put('a',0);
        hash.put('b',0);
        hash.put('c',0);
        hash.put('d',0);
        hash.put('e',0);
        //1.hash 입력받기, max값 뽑아놓기
        for(Character c : s.toCharArray()){
            int added = hash.get(c) +1;
            hash.put(c, added);
            max = Math.max(max,added);
        }
        //3.foreach : Hash answer값 셋팅
        int i = 0;
        for(Integer value : hash.values()){
            answer[i] = max - value;
            i++;
        }

        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
