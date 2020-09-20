package structural;

public class Facade {
    public static void main(String[] args) {
    User user = new User();
    user.startEngine();
    }
}

class User {
    FuelBox fuelBox = new FuelBox();
    Pump pump = new Pump();
    SwitchEngine switchEngine = new SwitchEngine();
    void startEngine() {
        fuelBox.loadFuel();
        pump.pumpFuelToCarburetor(fuelBox);
        switchEngine.on();
    }
}

class SwitchEngine {
    void on() { System.out.println("Engine is turned on"); }
    void of() { System.out.println("Engine is turned off"); }
}

class FuelBox {
private boolean data = false;
public boolean hasFuel() { return data; }
void loadFuel() { data = true; }
void unloadFuel() { data = false; }
}

class Pump {
    void pumpFuelToCarburetor(FuelBox gasolineBox) {
        if(gasolineBox.hasFuel()) { System.out.println("Engine is ready for start"); }
        else { System.out.println("FuelBox is empty"); }
    }
}


