package ait.collections;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {

    public static ArrayList<String> compareTwoLists(ArrayList<Integer> list1, ArrayList<Integer> list2){

        ArrayList<String> result = new ArrayList<>();
        if (list1.size() != list2.size()){
            return null;
        }

        for( int i = 0; i< list1.size(); i++){
            if (list1.get(i).equals(list2.get(i))){
                result.add("Yes");
            } else {
                result.add("No");
            }
        }
        return result;

    }

}
