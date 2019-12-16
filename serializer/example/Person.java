package serializer.example;

public class Person {
    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;

    public Person(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }
}
