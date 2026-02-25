package LibrarySystem;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    static class Book {
        String title, author;
        boolean isAvailable;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        public String toString() {
            return title + "by" + author + (isAvailable ? " (Available)" : "(Borrowed)");
        }
    }

    static class Library {
        ArrayList<Book> books = new ArrayList<>();

        void addBook(String title, String author) {
            books.add(new Book(title, author));
        }

        void ShowBooks() {
            if (books.isEmpty()) {
                System.out.println("No book avialable");
            } else {
                for (Book b : books) {
                    System.out.println(b);

                }
            }
        }

        void borrowBook(String title) {
            for (Book b : books) {
                if (b.title.equalsIgnoreCase(title) && b.isAvailable) {
                    b.isAvailable = false;
                    System.out.println(title + " borrowed successfully");
                    return;
                }
            }
            System.out.println(" booked not avialable");
        }

        void returnBook(String title) {
            for (Book b : books) {
                if (b.title.equalsIgnoreCase(title) && !b.isAvailable) {
                    b.isAvailable = true;
                    System.out.println(title + "returned successfully");
                    return;
                }
            }
            System.out.println(" this booked was not borrow");

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        library.addBook("java basic", "james gosling");
        library.addBook("Data structures", "robert lafor");
        library.addBook("OOP is java", "Bjarne Stroustrup");

        int choice;
        do {
            System.out.println("\n=== Library menu ===");
            System.out.println("1.show Books");
            System.out.println("2.Borrow Book");
            System.out.println("3.Return Book");
            System.out.println("4.exit");
            System.out.println(" Enter choice");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> library.ShowBooks();
                case 2 -> {
                    System.out.println("Enter book title");
                    String title = sc.nextLine();
                    library.borrowBook(title);

                }
                case 3 -> {
                    System.out.println("Enter book title");
                    String title = sc.nextLine();
                    library.returnBook(title);
                }
                case 4 -> System.out.println("Good bye!");
                default -> System.out.println("Invalid choice!");


            }
        } while (choice != 4);

       sc.close();
    }


}


