package TimeComplexity;
//O(1)
public class ConstantTimeExample {
 //   public static void main(String[] args) {
      //  int[] arr = {10, 20, 30, 40, 50};

       // System.out.println(arr[0]);  // Direct access
   // }


    public static int getBalance(int[] accounts, int accountNumber) {
               return accounts[accountNumber];   // Direct access
           }

           public static void main(String[] args) {

               int[] accounts = {5000, 12000, 3000, 45000, 7000};

               int balance = getBalance(accounts, 3);

               System.out.println("Account Balance: " + balance);
           }
       }

