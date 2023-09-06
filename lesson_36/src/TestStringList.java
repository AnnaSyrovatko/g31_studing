import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class TestStringList {

    List<String> strings;


    @BeforeEach
    void setUp() {
        strings = new LinkedList<>(List.of("one","three","eleven","four","two"));
    }

    @Test
    void testMaxAndMinListMethod(){
        System.out.println(maxAndMinStringOfList((LinkedList<String>) strings)); // max eleven, min one

    }

    public String maxAndMinStringOfList(LinkedList<String> strings){
        String max = "";
        String min = strings.getLast();
        for (int i = strings.size() - 1; i >= 0; i--) {
            if (strings.get(i).length() >= max.length()){
                max = strings.get(i);
            }
            if (strings.get(i).length() <= min.length()) {
                min = strings.get(i);
            }
        }
        return "Max string: " + max + ", Min string: " + min;
    }
}
