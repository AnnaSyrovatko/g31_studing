package maps;

import java.util.*;

public class Students {
    public static void main(String[] args) {

        /*
        Дан список студентов. Каждая запись в этом списке означает, что студен посетил занятие.
        Необходимо сформировать Map<Student, Integer>, где ключ студент, а значение - количество занятий
         */

        List<String> attendance = List.of("Helga", "Andreas", "Claus", "Helga", "Andreas", "Helga", "Andreas", "Claus");
        Set<String> keys = new HashSet<>(attendance);

        Map<String, Integer> map = new HashMap<>();



        for (String key: keys) {
            int size = 0;
            for (String student: attendance) {
                if (key.equals(student)){
                    size++;
                }
                map.put(key, size);

            }
        }

        System.out.println(map);
    }
}
