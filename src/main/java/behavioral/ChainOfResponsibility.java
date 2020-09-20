package behavioral;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Logger smslogger = new SMSLogger(Level.ERROR);
        Logger filelogger = new FileLogger(Level.DEBUG);
        Logger emaillogger = new EmailLogger(Level.INFO);
        smslogger.setNext(filelogger);
        filelogger.setNext(emaillogger);
        smslogger.writeMessage("All Right", Level.INFO);
        smslogger .writeMessage("Debug process is going", Level.DEBUG);
        smslogger.writeMessage("ERROR, system crashed", Level.ERROR);
    }
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

//Handler
abstract class Logger {
    int priority;
    public Logger(int priority) { this.priority = priority; }
    Logger next;
    public void setNext(Logger next) { this.next = next; }
    public void writeMessage(String message, int level) {
        if(level<=priority) { printMessage(message); }
        if(next!=null) { next.writeMessage(message, level); }
    }
    abstract void printMessage(String message);
}

//Concrete Handler
class SMSLogger extends Logger {
    public SMSLogger(int priority) { super(priority); }
    public void printMessage(String message) { System.out.println("SMS: " + message); }
}

//Concrete Handler
class FileLogger extends Logger {
    public FileLogger(int priority) { super(priority);  }
    public void printMessage(String message) { System.out.println("File: " + message); }
}

//Concrete Handler
class EmailLogger extends Logger {
    public EmailLogger(int priority) { super(priority); }
    void printMessage(String message) { System.out.println("Email message: " + message); }
}