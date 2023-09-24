package task1;

import java.util.*;

public class MostCommonWords {
    public static void main(String[] args) {

        /*
        Дано список строк List<String>. Получить список 4 самых чвсто встречаемых слов (без знаков препинания слова разделены пробелом)

        Дано - 3;
        список - 2;
        без - 2;
        знаков - 2

        */

        List<String> text = Arrays.asList(
                "Дано список строк без знаков",
                "Дано Получить список 4 слов",
                "Дано без знаков препинания слова разделены пробелом"
        );
        text = listLinesToListWords(text);
        System.out.println(getWords(wordCount(text), 4));
    }

    public static List<String> listLinesToListWords(List<String> text){
        List<String> result = new ArrayList<>();
        if (text==null) return Collections.emptyList();
        for (String str: text) {
            result.addAll(Arrays.asList(str.toLowerCase().split(" ")));
        }
        return result;
    }

    public static  Map<String, Integer> wordCount(List<String> words) {
        Map<String, Integer> result = new HashMap<>();
        if (words==null) return result;
        for (String str : words) {
            result.put(str, result.getOrDefault(str, 0) + 1);
        }
        return result;
    }

    public static List<String> getWords (Map<String, Integer> map, int n) {
        List<String> result = new ArrayList<>();
        if (map==null) return result;

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Comparator<Map.Entry<String, Integer>> comparator = (e1,e2) -> {
            int compareValue = Integer.compare(e2.getValue(), e1.getValue());
            if (compareValue!=0){
                return compareValue;
            }
            else {
                return e1.getKey().compareTo(e2.getKey());
            }
        };
        TreeSet<Map.Entry<String, Integer>> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(entries);


        for (Map.Entry<String, Integer> entry: treeSet){
            if(result.size()>=n) return result;
            result.add(entry.getKey());
        }
        return result;
    }

}
