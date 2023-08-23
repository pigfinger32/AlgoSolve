import java.util.*;
class Main {
    public int solution(String s){
        int answer = Integer.MAX_VALUE;
        HashMap<Character, Integer> hs = new HashMap<>();
        List<Character> list = new ArrayList<>();
        //1.문자열을 반복하면서 HASH에 수량을 카운트한다.

        for(Character c : s.toCharArray()){
            hs.put(c,hs.getOrDefault(c, 0)+1);
        }
        //2.hash에 카운트가 1인 친구를 List에 Add
        for(Character c : hs.keySet()){
            if(hs.getOrDefault(c, 0) == 1){
                list.add(c);
            }
        }
        //3.list를 돌면서 최소의 인덱스를 구해라.
        for(Character c : list){
            answer = Math.min(s.indexOf(c),answer);
        }

        //4.인덱스는 1부터 시작하기에 +1
        if(answer == Integer.MAX_VALUE){
            return answer = -1;
        } else //4.인덱스는 1부터 시작하기에 +1
            return answer + 1;


    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}