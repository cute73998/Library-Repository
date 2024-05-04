
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adminMethod {
     public static void checkBorrowBook() {
    System.out.println("***       CHECK BORROW BOOK        ***");
    System.out.println("");
    System.out.println("Enter the name of the book you want to check: ");
    Scanner sc = new Scanner(System.in);
    String book = sc.nextLine();
    boolean found = false;
    List<String> store = new ArrayList<>();
    try {
        File file = new File("BookBorrow.txt");
        if (!file.exists()) {
            System.out.println("Error: BookBorrow.txt does not exist.");
            return;
        }
        Scanner read = new Scanner(file);
        while (read.hasNextLine()) {
            String save = read.nextLine().trim();
            if (save.contains(book)) {
                found = true;
                break; // Exit the loop when the book is found
            }
        }
        read.close();
        if (found) {
            System.out.println("This book has been borrowed by reader !");
        } else {
            System.out.println("The book is not currently borrowed.");
        }
    } catch (Exception e) {
        System.out.println("Books do not exist!");
    }
}
    
    public static void DisplayAccountOfReader(){
    System.out.println("*** DISPLAY ACCOUNT AND INFORMATION OF READER ***\n");

try (Scanner sc = new Scanner(new FileInputStream("ReaderAccount.txt"))) {
        while (sc.hasNextLine()) {
            String save = sc.nextLine().trim(); // Loại bỏ khoảng trắng ở đầu và cuối dòng
            if (!save.isEmpty()) { // Kiểm tra xem dòng có rỗng không
                String[] arraySave = save.split("_");
                if (arraySave.length >= 4) {
                    System.out.println("Username: " + arraySave[0]);
                    System.out.println("Password: " + arraySave[1]);
                    System.out.println("Reader name: " + arraySave[2]);
                    System.out.println("id: " + arraySave[3]);
                    System.out.println();
                } else {
                    System.out.println("Error: Invalid data format in the file.");                  
                }
            }
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}
    
        public static void deleteAccount() {
        System.out.println("***      DELETE   ACCOUNT       ***");
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of reader you want to delete: ");
        String id = sc.nextLine();
        boolean found = false;
        List<String> store = new ArrayList<>();
        try {
            Scanner read = new Scanner(new FileInputStream("ReaderAccount.txt"));
            while (read.hasNextLine()) {
                String data = read.nextLine();
                if (data.contains(id)) {
                    found = true;
                    while (read.hasNextLine()) {
                        data = read.nextLine();
                        if (data.isEmpty()) {
                            break;
                        }
                    }
                } else {
                    store.add(data);
                }
            }
            PrintStream ps = new PrintStream(new FileOutputStream("ReaderAccount.txt"));
            for (String save : store) {
                ps.println(save);            
            }
            if(found){
                System.out.println("Delete Successfully !");
            }
            else{
                System.out.println("id not found !");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***              ADD ACCOUNT              ****");
        System.out.println("");
        System.out.println("Add reader username: ");
        String userName = sc.nextLine();
        System.out.println("add reader  password: ");
        String password = sc.nextLine();
        System.out.println("Enter reader Name: ");
        String name = sc.nextLine();
        int idSave = (int) (Math.random() * (90000 - 1000 + 1) + 1000);
        boolean found = false;
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("ReaderAccount.txt", true));
            Scanner read = new Scanner(new FileInputStream("ReaderAccount.txt"));
            while (read.hasNextLine()) {
                String check = read.nextLine();
                if (check.contains(userName)) {
                    System.out.println("This account name is existed ! Choose other username");
                    menuHomeMethod.Register();
                    found = true;
                    break;
                } else {
                    found = false;
                }
            }
            if (found == false) {
                ps.println(userName + "_" + password + "_" + name + "_" + idSave);
                ps.println("");
                System.out.println("Add successfully !");
                ps.close();
                read.close();
            }
        } catch (Exception e) {
            System.out.println("Add failed because of system error");
        }
    }

    public static void displayAdBook() {
        System.out.println("***       DISPLAY BOOK INFORMATION     ***");
        System.out.println("");
        try {
            Scanner sc = new Scanner(new FileInputStream("book.txt"));
            while (sc.hasNextLine()) {
                String read = sc.nextLine();
                System.out.println(read);
            }
        } catch (Exception e) {
            System.out.println("Empty book !");
        }
    }

    public static void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("****         ADD   BOOK      ****");
        System.out.println("");
        System.out.println("Enter the name of book you want to add: ");
        String bookName = sc.nextLine();
        System.out.println("Enter the author name of book: ");
        String authorName = sc.nextLine();
        System.out.println("Enter the year the book was published: ");
        String year = sc.nextLine();
        System.out.println("Succesfully !");
        try {
            PrintStream write = new PrintStream(new FileOutputStream("Book.txt", true));
            write.println("");
            write.println("Book: " + bookName);
            write.println("Author: " + authorName);
            write.println("Year: " + year);
            write.close();
        } catch (Exception e) {
            System.out.println("Add failed!");
        }
    }

    public static void removeBook() {
        System.out.println("***     REMOVE   BOOK     ***");
        System.out.println("");
        List<String> store = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of book you want to remove: ");
        String book = sc.nextLine();
        boolean found = false;
        try {
            Scanner read = new Scanner(new FileInputStream("Book.txt"));
            while (read.hasNextLine()) {
                String search = read.nextLine();
                if (search.startsWith("Book: ") && search.contains(book)) {
                    found = true;
                    while (read.hasNextLine()) {
                        search = read.nextLine();
                        if (search.isEmpty()) {
                            break;
                        }
                    }
                } else {
                    store.add(search);
                }
            }
            read.close();
            if (!found) {
                System.out.println("The book " + book + " is not found.");
                return;
            }
            PrintStream prin = new PrintStream(new FileOutputStream("Book.txt"));
            for (String line : store) {
                prin.println(line);
            }
            System.out.println("Remove book successfully!");
            prin.close();
        } catch (Exception e) {
            System.out.println("Failed to remove the book.");
        }
    }
}
