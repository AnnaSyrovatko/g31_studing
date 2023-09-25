import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Robot {

    public static void routeRecord(String str){
        str = stringOptimize(str);

        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            Direction direction = Direction.valueOf(s);
            int num = i + 1;
            switch (direction) {
                case N:
                    System.out.println(num + " step north.");
                    break;
                case S:
                    System.out.println(num + " step south.");
                    break;
                case E:
                    System.out.println(num + " step east.");
                    break;
                case W:
                    System.out.println(num + " step west.");
                    break;
            }
        }
    }

    public static String stringOptimize(String str){
        if(str==null||str.isEmpty()) throw new NullPointerException();

        Map<Character, Character> pair = new HashMap<>();
        pair.put('N','S');
        pair.put('S','N');
        pair.put('W','E');
        pair.put('E','W');

        Deque<Character> stack = new LinkedList<>();

        for(Character ch:str.toCharArray()){
            if (!pair.containsKey(ch)){
                continue;
            }
            if(pair.get(ch).equals(stack.peek())){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: stack){
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}
