package queue;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String str = "([]){}";
        System.out.println(correctSequence(str));
        String str1 = "([])}{";
        System.out.println(correctSequence(str1));
        String str2 = "(}[])";
        System.out.println(correctSequence(str2));
    }

    public static Map<Character,Character> pairToOpenBracket = Map.of(
            '(',')',
            '[',']',
            '{','}'
    );
    public static Map<Character,Character> pairToCloseBracket = Map.of(
            ')','(',
            ']','[',
            '}','{'
    );

    public static boolean correctSequence(String str){
        Deque<Character> stack = new LinkedList<>();

        for (Character ch : str.toCharArray()) {
            Character bracket = pairToOpenBracket.get(ch);
            if (bracket!=null){
                stack.push(bracket);
            }else if(pairToCloseBracket.containsKey(ch)  && ((stack.isEmpty() || ch!=stack.pop()))  ) {
            return false;
            }
        }
        return stack.isEmpty();
    }
}
