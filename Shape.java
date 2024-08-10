public abstract class Shape {
    public abstract double calculateArea();

    public void display() {
        System.out.println("This is a shape");
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public void displayInfo() {
        System.out.format("This is a circle with radius %.0f and area %.2f. %n", radius, calculateArea());
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    public void displayInfo() {
        System.out.println("This is a rectangle with length " + length + " and width " + width + " and area " + calculateArea());
    }
}