import java.util.*;

public class CardinalDirections {
    public static void main(String[] args) {
        String str = "СВЗЮВЮЗССЮ";
        System.out.println(reverseDeque(directionForRobot2(str)));
        System.out.println(directionForRobot(str));

    }

    public static Map<Character,Character> oppositePoles = Map.of(
            'С','Ю',
            'З','В',
            'Ю','С',
            'В','З'
    );
    public static Deque<Character> directionForRobot (String route){
        Deque<Character> stack = new LinkedList<>();
        if(route==null||route.isEmpty()) return stack;
        for (Character ch: route.toCharArray()) {
            Character n = oppositePoles.get(ch);
            if ( stack.isEmpty() || !n.equals(stack.peekLast())){
                stack.offerLast(ch);
            } else {
                stack.pollLast();
            }
        }
        return stack;
    }
    public static Deque<Character> directionForRobot2 (String route){
        Deque<Character> stack = new LinkedList<>();
        for (Character ch: route.toCharArray()) {
            Character n = oppositePoles.get(ch);
            if ( stack.isEmpty() || !n.equals(stack.peek())){
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        return stack;
    }

    public static String reverseDeque(Deque<Character> queue){
        StringBuilder result = new StringBuilder();
        Iterator<Character> x = queue.descendingIterator();
        while (x.hasNext()){
            result.append(x.next());
        }
        return String.valueOf(result);

        /*
        StringBuilder sb = new StringBuilder();
        for (char ch: stack){
            sb.append(ch);
        }
        return sb.reverse().toString();
        */
    }
}
