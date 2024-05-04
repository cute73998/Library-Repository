
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readerMethod {
          public static void giveBookBack() {
    System.out.println("***       GIVE BOOK BACK        ***");
    System.out.println("");
    System.out.println("Enter the name of the book you want to give back: ");
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
            store.add(save);
        }
        read.close();

        PrintStream ps = new PrintStream(new FileOutputStream("BookBorrow.txt"));
        for (String extant : store) {
            ps.println(extant);
        }
        ps.close();

        if (found) {
            System.out.println("Returned the book successfully!");
        } else {
            System.out.println("The book is not currently borrowed.");
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
    
    public static void borrowBook() {
        System.out.println("*** BORROW BOOK ***\n");

        System.out.println("Enter the name of the book you want to borrow: ");
        Scanner sc = new Scanner(System.in);
        String bookName = sc.nextLine();
        boolean found = false;
        boolean borrowFound = false;
        try {
            Scanner read = new Scanner(new FileInputStream("Book.txt"));
            Scanner check = new Scanner(new FileInputStream("BookBorrow.txt"));
            PrintWriter write = new PrintWriter(new FileOutputStream("BookBorrow.txt", true));
            while (read.hasNextLine()) {
                String save = read.nextLine();
                boolean bookExistsInLibrary = save.contains(bookName);

                if (bookExistsInLibrary) {
                    found = true;

                    boolean bookAlreadyBorrowed = false;
                    while (check.hasNextLine()) {
                        String store = check.nextLine();
                        if (store.contains(bookName)) {
                            bookAlreadyBorrowed = true;
                            break;
                        }
                    }

                    if (bookAlreadyBorrowed) {
                        borrowFound = true;
                        System.out.println("This book has been borrowed by another user.");
                    } else {
                        write.println(bookName);
                        System.out.println("Borrowed books successfully");
                    }
                    break; // Stop searching once the book is found
                }
            }
            read.close();
            check.close();
            write.close();

            if (!found) {
                System.out.println("This book does not exist in the library");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void bookInformation(){
    System.out.println("***          BOOK INFORMATION              ***");
    System.out.println("");
    System.out.println("Enter the name of book you want to find information: ");
    Scanner sc = new Scanner(System.in);
    String book = sc.nextLine();
    boolean found = false;
    try{
        Scanner check = new Scanner(new FileInputStream("Book.txt"));
        while(check.hasNextLine()){
            String store = check.nextLine();
            if(store.startsWith("Book: ") && store.contains(book)){
                found = true;
                System.out.println(store);
                while(check.hasNextLine()){
                    store = check.nextLine();
                    if(store.isEmpty()){
                        break;
                    }
                    System.out.println(store);
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found !");
        }
    }
    catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }
    
    public static void displayBook(){
        System.out.println("***        DISPLAY BOOKS IN LIBRARY         ***");
        System.out.println("");
        boolean found =false;
        try{
            Scanner sc = new Scanner(new FileInputStream("Book.txt"));
            while(sc.hasNextLine()){
                 String save = sc.nextLine();
                 if(save.startsWith("Book:")){
                     System.out.println(save);
                 }
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
