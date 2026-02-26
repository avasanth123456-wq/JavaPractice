package TimeComplexity;
//O(n)
public class LinearTimeExample {
  /*  public static void main(String[] args) {
        int n = 100;

        for(int i =0; i < n; i++) {
            System.out.println(i);
        }
    }*/

      public static int findStudent(int[] studentIds, int targetId) {

          for (int i = 0; i < studentIds.length; i++) {

              if (studentIds[i] == targetId) {
                  return i;
              }
          }
          return -1;
      }

      public static void main(String[] args) {

          int[] studentIds = {101, 102, 103, 104, 105, 106, 107};

          int result = findStudent(studentIds, 106);

          if (result != -1)
              System.out.println("Student Found at index: " + result);
          else
              System.out.println("Student Not Found");
      }
  }

