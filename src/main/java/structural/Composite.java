package structural;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        Component blueMotoBody = new Body("Motocycle", "blue");
        Component blueCarBody = new Body("Car", "blue");
        Component MotoWheels = new Wheels("Motocycle", 2);
        Component CarWheels = new Wheels("Car", 4);
        Component MotoEngine = new Engine("Motocycle", 40);
        Component CarEngine = new Engine(" Car", 140);

        Collect vehicle1 = new Collect();
        Collect vehicle2 = new Collect();
        Collect vehicle = new Collect();

        vehicle1.addComponent(blueMotoBody);
        vehicle1.addComponent(MotoWheels);
        vehicle1.addComponent(MotoEngine);
        vehicle2.addComponent(blueCarBody);
        vehicle2.addComponent(CarWheels);
        vehicle2.addComponent(CarEngine);

        vehicle.addComponent(vehicle1);
        vehicle.addComponent(vehicle2);
    }
}

abstract class Component {
    String type;
    abstract void mountOnVehicle();
}

class Body extends Component {
    String color;
    public Body(String type, String color) { super.type = type; this.color = color; }
    @Override
    void mountOnVehicle() { System.out.println(color + " body is mounting to the " + type); }
}

class Wheels extends Component {
    int count;
    public Wheels(String type, int count) { super.type = type; this.count = count; }
    @Override
    void mountOnVehicle() { System.out.println(count + " wheels are mounted to the " + type); }
}

class Engine extends Component {
    int power;
    public Engine(String type, int power) { super.type = type; this.power = power; }
    @Override
    void mountOnVehicle() { System.out.println("Engine " + power + " Hm of power is mounted to the " + type); }
}

class Collect extends Component {
    List<Component> vehicle = new ArrayList();
    void addComponent(Component component) { vehicle.add(component);}
    void removeComponent(Component component) { vehicle.remove(component); }
    @Override
    void mountOnVehicle() {
        for(Component component: vehicle) {
            component.mountOnVehicle();
        }
    }
}