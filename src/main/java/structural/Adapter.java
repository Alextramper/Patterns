package structural;

public class Adapter {
    public static void main(String[] args) {
        ConnectInterface adapter = new WifiAdapter(new ComputerBox());
        adapter.connectByAdapter();
    }
}

interface ConnectInterface {
    void connectByAdapter();
}

class ComputerBox {
    void connectToInternet() {
        System.out.println("Connecting to Internet by wifi adapter");
    }
}

class WifiAdapter implements ConnectInterface {
    ComputerBox computerBox;
    WifiAdapter (ComputerBox computerBox)  { this.computerBox = computerBox;}
    public void connectByAdapter() {
        computerBox.connectToInternet();
    }
}
