package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapToObjects {
    public static void main(String[] args) {
        Map<Integer, List<String>> map = new HashMap<>();


        map.put(10,List.of("Jack","John"));
        map.put(20,List.of("Jack","Ann","Roman"));
        map.put(30,List.of("Lena","Nick"));

        System.out.println(mapAgeListNamesToListPerson(map));
    }

    public static List<Person> mapAgeListNamesToListPerson(Map<Integer, List<String>> map){
        List<Person> result = new ArrayList<>();
        if (map == null) return result;
        for (Map.Entry<Integer, List<String>> entries : map.entrySet()){
            Integer age = entries.getKey();
            for (String name : entries.getValue()){
                result.add(new Person(name,age));
            }
        }
        return result;
    }

}
