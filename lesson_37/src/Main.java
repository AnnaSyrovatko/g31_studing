public class Main {
    public static void main(String[] args) {

        OurLinkedList<Person> list = new OurLinkedList<>();
        Person p1 = new Person("Jack");
        list.append(p1);
        list.append(new Person("John"));
        list.append(new Person("Ann"));
        System.out.println(list.get(1));

        list.set(new Person("Oleg"), 1);
        System.out.println(list.get(1));

        System.out.println("======= Full list =======");
        list.printList();

        }
}
