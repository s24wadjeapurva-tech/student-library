import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Author: " + author +
               " | Status: " + (isIssued ? "Issued" : "Available");
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Add a new book
    public void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book Added Successfully!");
    }

    // View all books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        for (Book b : books) {
            System.out.println(b);
        }
    }

    // Search book by title
    public void searchBook() {
        sc.nextLine();
        System.out.print("Enter Book Title to Search: ");
        String title = sc.nextLine();

        boolean found = false;

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + b);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book Not Found!");
        }
    }

    // Issue book
    public void issueBook() {
        System.out.print("Enter Book ID to Issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book Issued Successfully!");
                } else {
                    System.out.println("Book Already Issued!");
                }
                return;
            }
        }
        System.out.println("Book Not Found!");
    }

    // Return book
    public void returnBook() {
        System.out.print("Enter Book ID to Return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book Returned Successfully!");
                } else {
                    System.out.println("This Book Was Not Issued!");
                }
                return;
            }
        }
        System.out.println("Book Not Found!");
    }

    // Delete book
    public void deleteBook() {
        System.out.print("Enter Book ID to Delete: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                books.remove(b);
                System.out.println("Book Deleted Successfully!");
                return;
            }
        }
        System.out.println("Book Not Found!");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: lib.addBook(); break;
                case 2: lib.viewBooks(); break;
                case 3: lib.searchBook(); break;
                case 4: lib.issueBook(); break;
                case 5: lib.returnBook(); break;
                case 6: lib.deleteBook(); break;
                case 7:
                    System.out.println("Exiting... Thank You!");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}


//OUTPUT
===== LIBRARY MANAGEMENT SYSTEM =====
1. Add Book
2. View Books
3. Search Book
4. Issue Book
5. Return Book
6. Delete Book
7. Exit
Enter Choice: 1
Enter Book ID: 44
Enter Book Title: c code
Enter Book Author: john
Book Added Successfully!

===== LIBRARY MANAGEMENT SYSTEM =====
1. Add Book
2. View Books
3. Search Book
4. Issue Book
5. Return Book
6. Delete Book
7. Exit
Enter Choice: 3

Enter Book Title to Search: c code
Book Found: ID: 44 | Title: c code | Author: john | Status: Available

===== LIBRARY MANAGEMENT SYSTEM =====
1. Add Book
2. View Books
3. Search Book
4. Issue Book
5. Return Book
6. Delete Book
7. Exit
Enter Choice: 6
Enter Book ID to Delete: 44
Book Deleted Successfully!

===== LIBRARY MANAGEMENT SYSTEM =====
1. Add Book
2. View Books
3. Search Book
4. Issue Book
5. Return Book
6. Delete Book
7. Exit
Enter Choice: 3
Enter Book Title to Search: c code
Book Not Found!