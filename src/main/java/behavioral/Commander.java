package behavioral;

public class Commander {
    public static void main(String[] args) {
        Comp comp = new Comp();
        ComUser comUser = new ComUser(new StartCommand(comp)
                , new ShutDownCommand(comp), new ResetCommand(comp));
        comUser.startComputer();
        comUser.shutDownComputer();
        comUser.resetComputer();
    }
}

//Command
interface Command {
    void execute();
}

//Reciver
class Comp {
    void start() { System.out.println("Start computer"); }
    void shutDown() { System.out.println("Stop computer"); }
    void reset() { System.out.println("Reset computer"); }
}

//ConcreteCommand
class StartCommand implements Command {
    Comp computer;
    public StartCommand(Comp computer) { this.computer = computer; }
    @Override
    public void execute() { computer.start(); }
}

//ConcreteCommand
class ShutDownCommand implements Command {
    Comp computer;
    public ShutDownCommand(Comp computer) { this.computer = computer; }
    @Override
    public void execute() { computer.shutDown(); }
}

//ConcreteCommand
class ResetCommand implements Command {
    Comp computer;
    public ResetCommand(Comp computer) { this.computer = computer; }
    @Override
    public void execute() { computer.reset(); }
}

//Invoker
class ComUser {
    Command start;
    Command shutDown;
    Command reset;
    public ComUser(Command start, Command shutDown, Command reset) {
        this.start = start;
        this.shutDown = shutDown;
        this.reset = reset;
    }
    void startComputer() { start.execute(); }
    void shutDownComputer() { shutDown.execute(); }
    void resetComputer() { reset.execute(); }
}
