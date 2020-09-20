package behavioral;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverExample {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());
        station.setMeasurements(25, 765);
    }
}

interface Observer {
    void handleEvent(int temp, int pressure);
}

class ConsoleObserver implements Observer {
    public void handleEvent(int temp, int pressure) {
        System.out.println("Weather changed. Temperature: " + temp
                + ", Pressure:  " + pressure);
    }
}

class FileObserver implements Observer {
    public void handleEvent(int temp, int pressure) {
        File file;
        try {
            file = File.createTempFile("TempPressure", "_txt");
            PrintWriter pw = new PrintWriter(file);
            pw.print("Weather changed.Temperature: " + temp
                    + ", Pressure:  " + pressure);
            pw.println();
            pw.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}

interface Observed {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class MeteoStation implements Observed {
    int temp;
    int pressure;
    List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int t, int p) {
        temp = t;
        pressure = p;
        notifyObservers();
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for(Observer ob : observers) {
            ob.handleEvent(temp, pressure);
        }
    }
}
