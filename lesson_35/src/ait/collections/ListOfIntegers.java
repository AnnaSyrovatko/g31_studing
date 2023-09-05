package ait.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ListOfIntegers {

    public static ArrayList<Integer> listOfIntegersLessThen(ArrayList<Integer> list, Integer number) {

        Iterator<Integer> ourIterator = list.iterator();

        while (ourIterator.hasNext()) {
            if (ourIterator.next() > number) {
                ourIterator.remove();
            }
        }

        return list;
    }
}
