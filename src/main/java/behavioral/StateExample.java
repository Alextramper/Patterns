package behavioral;

public class StateExample {
    public static void main(String[] args) {
        Activity doing = new Work();
        Human human = new Human();
        human.setState(doing);
        for( int i = 0; i<10; i++) {
            human.doSomething();
            }
        }
    }

//State
interface Activity{
    void doSomething(Human human);
}

//ConcreteState
class Work implements Activity {
    public void doSomething (Human human) {
        System.out.println("Work");
        human.setState(new Weekend());
    }
}

class Weekend implements Activity {
    private int count = 0;
    public void doSomething(Human human) {
        if(count<3) {
            System.out.println("Weekend");
            count ++;
           // human.setState();
        }
        else {
            human.setState(new Work());
        }
    }
}

//Context
class Human {
   private Activity state;
    void setState(Activity st) { state = st; }
    void doSomething() {
        state.doSomething(this); ;
    }
}