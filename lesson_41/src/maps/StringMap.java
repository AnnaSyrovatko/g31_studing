package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringMap {
    public static void main(String[] args) {

        /*
        Дана Map<String, String>, если в ней есть ключ "a" и "b", то нужно создать новый ключ ‘ab’ с суммой значений от ключей a и b.
        Примеры: mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b":"There"} mapAB({"a": "Hi"}) → {"a": "Hi"} mapAB({"b": "There"}) → {"b": "There"}
         */

        Map<String,String> map = new HashMap<>();

        map.put("a", "Hi");
        map.put("b", "There");
        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();

        Set<Map.Entry<String, String>> entriesMap1 = map.entrySet();
        for (Map.Entry<String, String> entry : entriesMap1){
            key.append(entry.getKey());
            value.append(entry.getValue());
        }

        map.put(key.toString(), value.toString());
        System.out.println(map);

    }
    public static void mapHandler(Map<String,String> map, String key1, String key2){
        if (map != null && map.containsKey(key1) && map.containsKey(key2)){
            map.put(key1+key2, map.get(key1) + map.get(key2));
        }
    }
    public static void mapAB2(Map<String,String> map, String key1, String key2){
        if (map == null) return;
        String value1 = map.get(key1);
        String value2 = map.get(key2);
        if (value1 != null && value2 != null){
            map.put(key1+key2, value1 + value2);
        }
    }
}
