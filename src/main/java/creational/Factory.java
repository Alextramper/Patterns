package creational;

public class Factory {
    public static void main(String [] args) {
    ProductMaker productMaker = new ProductMakerTwo();
    Product product = productMaker.make();
    product.produce();
    }
}

abstract class Product {
    abstract void produce();
}

class ProductOne extends Product {
    void produce() { System.out.println("product one"); }
}

class ProductTwo extends Product {
    void produce() { System.out.println("product two"); }
}

interface ProductMaker {
    Product make();
}

class ProductMakerOne implements ProductMaker {
    public Product make() {
        return new ProductOne();
    }
}

class ProductMakerTwo implements ProductMaker {
    public Product make() {
        return new ProductTwo();
    }
}






