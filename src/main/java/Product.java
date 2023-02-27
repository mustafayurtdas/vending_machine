import java.util.ArrayList;
import java.util.List;

public class Product extends Stock{
private static int counter = 0;
    private int productId;
    private String productName;
    private int price;

    public Product() {
    }

    public Product(String productName, int price) {
        counter++;
        this.productName = productName;
        this.price = price;
        this.productId = counter;



    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
}
