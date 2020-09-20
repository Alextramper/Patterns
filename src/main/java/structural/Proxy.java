package structural;

public class Proxy {
    public static void main(String[] args) {
        Image image = new ProxyImage("D:/images/my.jpg") ;
        image.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    String file;
    public RealImage(String file) {
        this.file = file;
        load();
    }
    void load() {
        System.out.println("Load " + file);
    }
    @Override
    public void display() {
        System.out.println("View " + file);
    }
}

class ProxyImage implements Image {
    String file;
    RealImage realImage;
    public ProxyImage(String file) {
        super();
        this.file = file;
    }
    @Override
    public void display() {
        if(realImage == null) {
            realImage = new RealImage(file);
        }
        realImage.display();
    }
}