package structural;

import java.util.*;

public class FlyWeight {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(factory.getShape("square"));
        shapes.add(factory.getShape("circle"));
        shapes.add(factory.getShape("circle"));
        shapes.add(factory.getShape("rectangle"));
        shapes.add(factory.getShape("square"));
        shapes.add(factory.getShape("rectangle"));

        Random random = new Random();
        for(Shape shape: shapes) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shape.draw(x,y);
        }
    }
}

//FlyWeight
interface Shape{
    void draw(int x, int y);
}

//Circle FlyWeight
class Circle implements Shape {
    int r = 5;
    public void draw(int x, int y) {
        System.out.println("Draw point with coordinates(" + x + ", " + y + ") wth radius " + r);
    }
}

//Square FlyWeight
class Square implements Shape {
    int a = 10;
    public void draw(int x, int y) {
        System.out.println("Draw square (" + x + ", " + y + ")" + "side: " + a);
    }
}

//Rectangle FlyWeight
class Rectangle implements Shape {
    int b = 10;
    public void draw(int x, int y) {
        System.out.println("Draw rectangle (" + x + ", " + y + ")" + "side: " + b);
    }
}

//FlyWeight
class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap();
    public Shape getShape(String shapeName) {
        Shape shape = shapes.get(shapeName);
        if(shape==null) {
            switch(shapeName) {
                case "circle":
                    shape = new Circle();
                    break;
                case "square":
                    shape = new Square();
                    break;
                case "rectangle":
                    shape = new Rectangle();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}

