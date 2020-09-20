package creational;

public class Prototype {
    public static void main(String[] args) {
        TheProduct OriginProd = new TheProduct("Car", 30);
        ProductFactory prFactory = new ProductFactory(OriginProd);
        TheProduct prodOne = prFactory.makeClone();
    }
}

interface ProductPrototype {
    Object clone();
}

class TheProduct implements ProductPrototype {
   String name;
   int count;
   public TheProduct (String name, int count) {
       this.name = name;
       this.count = count;
   }
   @Override
   public Object clone() {
       TheProduct clone = new TheProduct(name, count);
       return clone;
    }
}

 class ProductFactory {
    TheProduct product;
    public ProductFactory(TheProduct product) {
        setProduct(product);
    }
    public void setProduct(TheProduct product) {
        this.product = product;
    }
    TheProduct makeClone() {
        return (TheProduct)product.clone();
    }
 }




