package behavioral;

public class IteratorExample {
    public static void main(String[] args) {
        TaskContainer tasks = new Tasks();
        Iterator i = tasks.getIterator();
        while(i.hasNext()) {
            System.out.println((String)i.next());
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

//Aggregate
interface TaskContainer {
    Iterator getIterator();
}

//ConcreteAggregate
class Tasks implements TaskContainer {
    String[] tasks = {"Get job", "Make money", "Get chilling"};

    public Iterator getIterator() {
        return new TaskIterator();
        }
    //ConcreteIterator
    private class TaskIterator implements Iterator {
        int index = 0;
        @Override
        public boolean hasNext() {
            if (index < tasks.length) {
                return true;
            }
            return false;
        }
        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
