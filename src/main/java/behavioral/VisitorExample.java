package behavioral;

public class VisitorExample  {
    public static void main(String[] args) {
        Element car = new CarElement();
        car.accept(new MechanicVisitor());
    }
}

//Посетитель
interface Visitor {
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(WheelElement wheel);
    void visit(CarElement car);
}

//Элемент автозапчасть
interface Element {
    void accept(Visitor visitor);
}

//Кузов
class BodyElement implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//Двигатель
class EngineElement implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//Колесо
class WheelElement implements Element {
    private String name;
    public WheelElement(String name) {this.name = name; }
    public String getName() { return this.name; }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element {
    Element[] elements;
    public CarElement() {
        this.elements = new Element[] {
                new WheelElement("Front wheels"), new WheelElement("Back wheels"),
                new BodyElement(), new EngineElement() };
    }
    public void accept(Visitor visitor) {
        for(Element el : elements) {
            el.accept(visitor);
        }
        visitor.visit(this);
    }
}

//Посетители
class CheckerVisitor implements Visitor {
    public void visit(EngineElement engine) {
        System.out.println("Engine checked");
    }
    public void visit(BodyElement body) {
        System.out.println("Body checked");
    }
    public void visit(WheelElement wheel) {
        System.out.println(wheel.getName() + "checked");
    }
    public void visit(CarElement car) {
        System.out.println("Whole car checked");
    }
}

class MechanicVisitor implements Visitor {
    public void visit(BodyElement body) {
        System.out.println("Body repaired");
    }
    public void visit(WheelElement wheel) {
        System.out.println(wheel.getName() + "repaired");
    }
    public void visit(CarElement car) {
        System.out.println("Whole car crepaired");
    }
    public void visit(EngineElement engineElement) {
        System.out.println("Engine repaired");
    }
}