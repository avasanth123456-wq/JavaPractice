package TimeComplexity;
//O(n2)
public class QuadratiTimeExample {
 /*   public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }
    }*/
 public static void checkDuplicates(int[] studentIds) {

     for (int i = 0; i < studentIds.length; i++) {

         for (int j = i + 1; j < studentIds.length; j++) {

             if (studentIds[i] == studentIds[j]) {
                 System.out.println("Duplicate Found: " + studentIds[i]);
             }
         }
     }
 }

    public static void main(String[] args) {

        int[] studentIds = {101, 102, 103, 104, 102, 105};

        checkDuplicates(studentIds);
    }
}

