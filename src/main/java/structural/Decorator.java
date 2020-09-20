package structural;

public class Decorator {
    public static void main(String[] args) {
        PrinterInterface printer = new QuotesDecorator(new HelloDecorator(new Printer("world")));
        printer.print();
    }
}

interface PrinterInterface { void print();}

abstract class AbstractDecorator {
    PrinterInterface component;
    AbstractDecorator(PrinterInterface component) { this.component = component; }
}

class Printer implements PrinterInterface {
    String value;
    public Printer(String value) { this.value = value; }
    public void print() { System.out.print(value); }
}

class HelloDecorator extends AbstractDecorator implements PrinterInterface {
    public HelloDecorator(PrinterInterface component) { super(component); }
    public void print() {
        System.out.print("Hello, ");
        component.print();
    }
}

class QuotesDecorator extends AbstractDecorator implements PrinterInterface {
    public QuotesDecorator(PrinterInterface component) { super(component); }
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("!\"");
    }
}

