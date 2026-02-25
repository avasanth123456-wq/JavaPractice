package Amazon;


import java.util.ArrayList;
import java.util.Scanner;

class Product{
     int id;
     String name;
     double price;

     Product( int id,String name,double price){

         this.id = id;
         this.name = name;
         this.price = price;
     }

 }
  public class AmazonDemo {
     public  static void main (String[] args){
         Scanner sc = new Scanner(System.in) ;

         ArrayList<Product> products = new ArrayList<>();
         products.add(new Product(1,"Mobile phone",2000));
         products.add(new Product(2," Laptop",55000));
         products.add(new Product(3,"headphones",2000));
         products.add(new Product(4,"smartwatch",3000));

         ArrayList<Product> cart = new ArrayList<>();

         int choice;
         do{
             System.out.println("\n====Amazon Shopping");
             System.out.println("1.view products");
             System.out.println("2.Add to cart");
             System.out.println("3.view chart");
             System.out.println("4.checkout");
             System.out.println("5.Exit");
             System.out.println("Enter choice");
             choice = sc.nextInt();

             switch (choice){

                 case 1:
                 System.out.println("\nAvailable Products");
                 for (Product p : products){
                     System.out.println(p.id +"."+p.name+"-$"+p.price);
                 }
                  break;
                 case 2:
                     System.out.println("Enter products id to add");
                      int pid = sc.nextInt();
                      boolean found = false;
                      for(Product p : products){
                          if (p.id == pid){
                              cart.add(p);
                              System.out.println(p.name+"added at cart!");
                              found = true;
                          }
                      }
                      if (!found) System.out.println("Invalid product id.");
                      break;
                 case 3 :
                      System.out.println("\n Your Cart");
                      double total = 0;
                      for (Product p:cart){
                          System.out.println(p.name+"-$"+p.price);
                          total += p.price;
                      }
                      System.out.println("Total=$" + total );
                      break;
                 case 4:
                     double sum =0;
                     for (Product p:cart) sum += p.price;
                     System.out.println("\n checkout successfull");
                     System.out.println("Total amount apaid:$"+ sum);
                     cart.clear();
                     break;
                 case 5:
                     System.out.println("Thank you for a shopping on Amazon");
                     break;

                 default:
                     System.out.println("Invalid choice.");

             }
         } while (choice !=5);
         sc.close();
     }
}

