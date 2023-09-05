package ait.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListMethodTest {


    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list3 = new ArrayList<>();
    ArrayList<Integer> list4;

    @BeforeEach
    void setUp() {
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2 =  new ArrayList<>(Arrays.asList(5, 2, 3, 6));
        list3 =  new ArrayList<>(Arrays.asList(1, 2, 3));
        list4 =  new ArrayList<>(Arrays.asList(1, 2, 4, 10, 5, 6, 7, 3));
    }

    @Test
    void testMethodCompareLists() {

        List<String> expected = new ArrayList<>(Arrays.asList("No", "Yes", "Yes", "No"));
        assertEquals(expected, ListMethod.compareTwoLists(list1, list2));
        assertNull(ListMethod.compareTwoLists(list1, list3));
    }

    @Test
    void testMethodListOfIntegers(){
        System.out.println(ListOfIntegers.listOfIntegersLessThen(list4, 5));
    }

}