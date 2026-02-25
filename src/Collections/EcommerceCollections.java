package Collections;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class EcommerceCollections {

     public  static  void main (String[] args){
         int [] productIds = {101,102,103} ;
          System.out.println("Amazon product ids (Array):");
           for ( int id : productIds){
               System.out .println(id);
           }
         LinkedList<String> routeDelivery = new LinkedList<>();
           routeDelivery.add("Store");
          routeDelivery.add("Customre A");
          routeDelivery.add("Customre B");
          routeDelivery.addFirst("warehouse");
          System.out.println("\nZepto Route Delivery (LinkedList):");
          System.out.println(routeDelivery);

         Vector<String> sharedCart = new Vector<>();
         sharedCart.add("Rice");
         sharedCart.add("Milk");
         sharedCart.add("Oil");

         System.out.println("\nBigBasket Shared Cart (Vector):");
         System.out.println(sharedCart);

         Stack<String> orderStack = new Stack<>();
         orderStack.push("Order#A100");
         orderStack.push("Order#A101");
         orderStack.push("Order#A102");

         System.out.println("\nOrder Processing Stack:");
         System.out.println(orderStack);
         System.out.println("Processing Order: " + orderStack.pop());

         CopyOnWriteArrayList<String> liveUsers = new CopyOnWriteArrayList<>();
         liveUsers.add("User1");
         liveUsers.add("User2");
         liveUsers.add("User3");

         for (String user : liveUsers) {
             if (user.equals("User2")) {
                 liveUsers.add("User4");
             }
         }

         System.out.println("\nLive Users Browsing (CopyOnWriteArrayList):");
         System.out.println(liveUsers);
     }
}

