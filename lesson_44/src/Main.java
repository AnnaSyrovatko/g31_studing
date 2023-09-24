import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = List.of(-1, 1, 5, 5, 9, 11, 13);
        isPairEqualsNumber(list, 10);
    }
    public static boolean isPairEqualsNumber(List<Integer> list, int num){
        if(list==null || list.size()<2) return false;

        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size() ; j++) {
                if(list.get(i)+list.get(j) == num) {
                    return true;
                }
            }
        }

        return false;
    }

    // !!!not good!
    public static boolean isPairEqualsNumber2(List<Integer> list, int num){
        if(list==null || list.size()<2) return false;

        for (int i = 0; i < list.size(); i++) {
            Integer pair = num - list.get(i); // pair + list.get(i) = num
            if(list.contains(pair)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPairEqualsNumber3(List<Integer> list, int num){
        if(list==null || list.size()<2) return false;
        HashSet<Integer> wishNumbersSet = new HashSet<>();
        for (Integer i: list) {
            if (wishNumbersSet.contains(i)){
                return true;
            } else {
                wishNumbersSet.add(num - i);
            }
        }

        return false;
    }

    public static boolean isPairEqualsNumber4(List<Integer> list, int num){
        if(list==null || list.size()<2) return false;
        list.sort((a,b)->a-b);
        int lIndex= 0;
        int rIndex=list.size()-1;

        while (lIndex<rIndex){
            int sum=list.get(lIndex)+list.get(rIndex);
            if(sum==num){
                return true;
            }
            if(sum<num){
                lIndex++;
            } else {
                rIndex--;
            }
        }

        return false;
    }

}

