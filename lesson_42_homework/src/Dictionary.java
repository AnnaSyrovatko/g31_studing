import java.util.*;

public class Dictionary {
    public static void main(String[] args) {

        String quote = "The saddest aspect of life right now is that it gathers knowledge faster than society gathers wisdom";
        List<String> text = stringToList(quote);
        System.out.println(collectionHandler(removeDuplicate(text)));

    }

    public static Set<String> removeDuplicate(Collection<String> collection){
        return new HashSet<>(collection);
    }

    public static Map<Character, List<String>> collectionHandler(Collection<String> collection){
        Map <Character, List<String>> result = new TreeMap<>();
        if (collection == null) return result;
        for (String word: collection) {
            char key = word.charAt(0);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(word);
//            Set<String> set = result.getOrDefault(key, new TreeSet<>());
//            set.add(word);
//            result.put(key, set);
        }
        return result;
    }

    public static List<String> stringToList(String text){
        if (text==null) return Collections.emptyList();
        return Arrays.asList(text.toLowerCase().split(" "));
    }
}
