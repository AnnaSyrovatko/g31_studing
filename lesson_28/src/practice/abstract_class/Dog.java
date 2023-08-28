package practice.abstract_class;

public class Dog extends Pet{

    private String name;

    private String breed;

    public Dog(String kind, int age, double weight, boolean gender, String name, String breed) {
        super(kind, age, weight, gender);
        this.name = name;
        this.breed = breed;

    }

    @Override
    public void eat() {
        System.out.println("I need porridge and meat");

    }

    @Override
    public void go() {
        System.out.println("I run, sniff and pee");

    }

    @Override
    public void voice() {
        System.out.println("Woof!");
    }
}
