import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //String str = "";
        String str = "NESL6N";
        try{
            Robot.routeRecord(str);
        } catch (Exception e){
            System.out.println("Incorrect command");
        }

    }
}
