package structural;

public class BridgeExample {
    public static void main(String[] args) {
        CarProduct car = new Sedan(new Kia());
        CarProduct car1 = new HatchBack(new Opel());
        car.showDetails();
        car1.showDetails();
    }
}

abstract class CarProduct {
    Make make;
    public CarProduct(Make m) { make = m; }
    abstract void showType();
    void showDetails() {
     showType();
     make.setMake();
    }
}

interface Make {
    void setMake();
}

class Sedan extends CarProduct{
    public Sedan(Make m) { super(m); }
    void showType() {
        System.out.println("Sedan");
    }
}

class HatchBack extends CarProduct {
    public HatchBack(Make m) { super(m); }
    void showType() {
        System.out.println("Hatchback");
    }
}

class Coupe extends CarProduct {
    public Coupe(Make m) { super(m); }
    void showType() {
        System.out.println("Coupe");
    }
}

class Kia implements Make {
    public void setMake() {
        System.out.println("Kia");
    }
}

class Shkoda implements Make {
    public void setMake() {
        System.out.println("Shkoda");
    }
}

class Opel implements Make {
    public void setMake() {
        System.out.println("Opel");
    }
}