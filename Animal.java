public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("\uD83C\uDFB6\uD83C\uDFB6\uD83C\uDFB6\uD83C\uDFB6\uD83C\uDFB6\uD83C\uDFB6\uD83C\uDFB6");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " \uD83D\uDC36\uD83D\uDC36\uD83D\uDC36\uD83D\uDC36 ¡Guau Guau!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println(getName() + " 🐱🐱🐱🐱 ¡Miau Miau!");
    }
}