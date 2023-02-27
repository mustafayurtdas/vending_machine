import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Process {

    static List<Product> productList = new ArrayList<>();

    Product product = new Product();

    public void fillList() {

        for (int i = 0; i < product.getProducts().length; i++) {
            Product product = new Product(this.product.getProducts()[i], this.product.getPrices()[i]);
            productList.add(product);
        }
    }

    public void showList() {

        System.out.println("******* Yiyecek Otomatı *******");
        System.out.printf("%-3s   %-15s   %-8s \n", "Nu","Urunler","Fiyatlar");
        System.out.printf("%-3s   %-15s   %-8s \n", "---", "-------", "--------");
        for (Product product : productList) {
            System.out.printf("%-3s   %-15s   %5s TL\n",product.getProductId(),product.getProductName(),product.getPrice());
        }
        System.out.println("*".repeat(33));

    }

    public void process(){
        Scanner input = new Scanner(System.in);
        int select;
        int balance = 0;

        do {
            System.out.println("Ürün Numarasını Girin" + "\nÇıkmak Icin 0 tusuna basiniz");
            select = input.nextInt();
            if (select > 0 && select < 16) {
                System.out.println(productList.get(select-1).getProductName()+ " sectiniz. " +
                        "Ucreti = " +productList.get(select-1).getPrice() + " TL");

                if (balance < productList.get(select-1).getPrice()) {
                    do {
                        System.out.println("Parayı Yerleştirin\n 1 Tl 5 TL 10 TL 20 TL");
                        int para = input.nextInt();

                        switch (para) {
                            case 1:
                            case 5:
                            case 10:
                            case 20:
                                balance += para;
                                break;
                            default:
                                System.out.println("Geçersiz Para!");
                        }
                    } while (productList.get(select-1).getPrice()> balance);
                }
                balance -= productList.get(select-1).getPrice();

                System.out.println(productList.get(select-1).getProductName() + " aldınız.\nBakiyeniz = " + balance +" Tl");
            } else if (select == 0) {
                System.out.println("Teşekkür Ederiz");
                if (balance > 0) {
                    System.out.println("Para Üstünü Alınız : " + balance+" TL");
                    break;
                }else{
                    break;
                }
            } else {
                System.out.println("Hatalı Ürün Seçimi!.. Lütfen Yeniden Giriniz");
            }
        } while (true);
    }

}
