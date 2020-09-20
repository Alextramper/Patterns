package structural;

public class Delegate {
    public static void main (String[] args) {
    CarUser caruser = new CarUser();
    caruser.setCarAction(new Rule()) ;
    caruser.action();
    }
}

interface Car {
    void action();
}

class Rule implements Car {
    @Override
    public void action() { System.out.println("Going right or left"); }
}

class SpeedBox implements Car {
    @Override
    public void action() { System.out.println("Shift the step of speed"); }
}

class TapeSpeakers implements Car {
    @Override
    public void action() { System.out.println("Play cool music"); }
}

class CarUser {
    Car car;
    void setCarAction(Car c) { car = c; }
    void action() {
        car.action();
    }
}
