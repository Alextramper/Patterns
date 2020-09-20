package creational;

public class BuilderDifficultExample {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new FirstTypeComputerBuilder());
        Computer computerOne = director.buildComputer();
        director.setBuilder(new SecondTypeComputerBuilder());
        Computer computerTwo = director.buildComputer();
    }
}

abstract class AbstrComputerBuilder {
    Computer computer;
    void makeComp() { Computer computer = new Computer(); }
    abstract void buildProcessor();
    abstract void buildMotherboard();
    abstract void buildSocket();
    abstract void buildSequense();
    Computer getComputer() { return computer; }
}

class FirstTypeComputerBuilder extends AbstrComputerBuilder {
    void buildProcessor() { computer.setProcessor("Intel i7 9400"); }
    void buildMotherboard() { computer.setMotherboard("ASER"); }
    void buildSocket() { computer.setSocket(Socket.INTEL); }
    void buildSequense() { computer.setSequence(3.2); }
}

class SecondTypeComputerBuilder extends AbstrComputerBuilder {
    void buildProcessor() { computer.setProcessor("Ryzen7"); }
    void buildMotherboard() { computer.setMotherboard("ASUS"); }
    void buildSocket() { computer.setSocket(Socket.AMD); }
    void buildSequense() { computer.setSequence(3.6); }
}

class Director {
    AbstrComputerBuilder builder;
    void setBuilder(AbstrComputerBuilder b) { builder = b; }
    Computer buildComputer() {
        builder.makeComp();
        builder.buildProcessor();
        builder.buildMotherboard();
        builder.buildSocket();
        builder.buildSequense();
        Computer computer = builder.getComputer();
        return computer;
    }
}