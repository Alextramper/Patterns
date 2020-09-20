package creational;

public class BuilderEasyExample {
    public static void main(String[] args) {
    Computer computer = new ComputerBuilder()
            .buildProc("Ryzen5").buildMotherBoard("ASUS")
            .buildSocket(Socket.AMD).buildSequence(3.4).build();
        System.out.println(computer.toString());
    }
}

enum Socket { AMD, INTEL }

class Computer {
    String processor;
    String motherboard;
    Socket socket;
    double sequence;
    public void setProcessor(String processor) { this.processor = processor; }
    public void setMotherboard(String motherboard) { this.motherboard = motherboard; }
    public void setSocket(Socket socket) { this.socket = socket; }
    public void setSequence(double sequence) { this.sequence = sequence; }
    public String toString() { return ("processor: " + processor + ", motherboard: "
            + motherboard + ", socket: " + socket + ", nuclear sequence: " + sequence); }
}

class ComputerBuilder {
    String proc;
    String motherb;
    Socket socket = Socket.AMD;
    double sequen = 3.2;
    ComputerBuilder buildProc(String proc){
        this.proc = proc;
        return this;
    }
    ComputerBuilder buildMotherBoard(String motherb) {
        this.motherb = motherb;
        return this;
    }
    ComputerBuilder buildSocket(Socket socket) {
        this.socket = socket;
        return this;
    }
    ComputerBuilder buildSequence(double sequen) {
        this.sequen = sequen;
        return this;
    }
    Computer build() {
        Computer computer = new Computer();
        computer.setProcessor(proc);
        computer.setMotherboard(motherb);
        computer.setSocket(socket);
        computer.setSequence(sequen);
        return computer;
    }
}

