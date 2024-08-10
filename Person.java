/**
 * Person is class, a blueprint for objects
 * name is an attribute
 * getName is a public method getter
 * setName is a public method setter
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age > 0 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Invalid Age: the range for age is greater tan 0 and lesser than 100");
        }
    }
}
