package creational;


public class AbstractFactory {
    public static void main(String[] args) {
        VehicleFactory vehicle = getFactoryByType("H");
        Jet jet = vehicle.getJet();
        Helicopter heli = vehicle.getHelicopter();
        jet.flyHorizontally();
        heli.flyVertically();
    }
    public static VehicleFactory getFactoryByType(String type) {
        switch(type) {
            case "H": return new HeavyVehicleFactory();
            case "L": return new LightVehicleFactory();
            default: throw new RuntimeException("Unknown type literal, need input H or L");
        }
    }
}

interface Jet {
    void flyHorizontally();
}

interface Helicopter {
    void flyVertically();
}

interface VehicleFactory {
    Jet getJet();
    Helicopter getHelicopter();
}

class HeavyJet implements Jet{
    public void flyHorizontally() { System.out.println("Produce Heavy Jet"); }
}

class HeavyHelicopter implements Helicopter {
    public void flyVertically() { System.out.println("Produce Heavy Helicopter");}
}

class LightJet implements Jet {
    public void flyHorizontally() { System.out.println("Produce Light Jet");}
}

class LightHelicopter implements Helicopter {
    public void flyVertically() { System.out.println("Produce Light Helicopter");}
}

class HeavyVehicleFactory implements VehicleFactory {
    public Jet getJet() { return new HeavyJet(); }
    public Helicopter getHelicopter() { return new HeavyHelicopter(); }
}

class LightVehicleFactory implements VehicleFactory {
    public Jet getJet() { return new LightJet();}
    public Helicopter getHelicopter() { return new LightHelicopter();}
}