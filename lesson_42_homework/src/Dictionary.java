import java.util.*;

public class Dictionary {
    public static void main(String[] args) {

        String quote = "The saddest aspect of life right now is that it gathers knowledge faster than society gathers wisdom";
        System.out.println(mapHandler(quote));

    }

    public static Map<Character, Set<String>> mapHandler(String str){
        Map <Character, Set<String>> result = new TreeMap<>();
        if (str == null) return result;
        String[] words = str.toLowerCase().split(" ");
        for (String word: words) {
            char key = word.charAt(0);
            Set<String> set = result.getOrDefault(key, new TreeSet<>());
            set.add(word);
            result.put(key, set);
        }
        return result;
    }
}
