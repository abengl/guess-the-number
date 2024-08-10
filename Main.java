/**
 * El juego se llevará a cabo en el terminal usando Java.
 * La lógica del juego se basará en estructuras de control, incluyendo bucles, condicionales y colecciones.
 * Es necesario dividir el código y mejorar su legibilidad y mantenimiento.
 * Se debe utilizar una funcionalidad de la biblioteca de utilidades de Java para la generación de números aleatorios.
 * Se deben realizar pruebas unitarias para sus clases y métodos utilizando JUnit y simulación de generación de
 * números aleatorios con Mockito.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();  // object from the class Person
        person.setName("Ana");
        System.out.format("OUTPUT -- The person name is %s.%n", person.getName());

        Person child = new Person();
        child.setName("Sofía");
        child.setAge(3);
        System.out.format("OUTPUT -- The child name is %s and its age is %d.", child.getName(), child.getAge());

        Animal mammal = new Animal("Mammal");
        System.out.format("%nOUTPUT -- The animal name is %s. It makes sound like: ", mammal.getName());
        mammal.makeSound();

        Dog dog = new Dog("Dog");
        System.out.println("OUTPUT -- The dog makes sound like: ");
        dog.makeSound();

        Cat cat = new Cat("Cat");
        System.out.println("OUTPUT -- The cat makes sound like: ");
        cat.makeSound();

        MusicalInstrument guitar = new Guitar();
        MusicalInstrument piano = new Piano();

        System.out.println("OUTPUT -- The guitar makes sound like: ");
        guitar.play();
        System.out.println("OUTPUT -- The piano makes sound like: ");
        piano.play();

        Circle myCircle = new Circle(5.0);
        Rectangle myRectangle = new Rectangle(4.0, 6.0);

        myCircle.displayInfo();
        //System.out.println("Area of the circle: " + myCircle.calculateArea());

        myRectangle.displayInfo();
        //System.out.println("Area of the rectangle: " + myRectangle.calculateArea());
    }
}
