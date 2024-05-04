
import java.util.Scanner;

public class Menu {
    public static void menuHome() {
        boolean found = true;
        while (found) {
            System.out.println("        *****************************************   ");
            System.out.println("        *    *  LIBRARY MANAGER SOFTWARE    *   *   ");
            System.out.println("        *       *    WELCOME EVERYONE    *    *  ");
            System.out.println("        *****************************************   ");
            System.out.println("");
            System.out.println("      ***             HOME      MENU             ***               ");
            System.out.println("1. Login                                                                              ");
            System.out.println("2. Register your account                                                   ");
            System.out.println("3. Software information                                                    ");
            System.out.println("4. Exit                                                                                  ");
            System.out.println("");
            System.out.println("Enter your choice by number 1 -> 4: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    menuHomeMethod.login();
                    break;
                case 2:
                    menuHomeMethod.Register();
                    found = true;
                    break;
                case 3:
                    menuHomeMethod.information();
                    found = true;
                    break;
                case 4:
                    found =false;
                    menuHomeMethod.exit();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your selection does not exist, please enter your selection as numbers from 1 to 4");
                    found = true;
                    break;
            }
        }
    }
    
      public static void adMenu() {
        boolean find = true;
        while (find) {
            System.out.println("         ***                   ADMIN      MENU             ***             ");
            System.out.println("1.  Add book to the library                                               ");
            System.out.println("2.  Remove book in the library                                         ");
            System.out.println("3.  Display all information of books in the library            ");
            System.out.println("4.  Check out the borrowed book                                     ");
            System.out.println("5.  Add account of reader                                                 ");
            System.out.println("6.  Delete the reader's account                                         ");
            System.out.println("7.  Display account of readers in system                          ");
            System.out.println("8.  Log out                                                                        ");
            System.out.println("Enter your choice by number 1 -> 8: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    adminMethod.addBook();
                    find = true;
                    break;
                case 2:
                    adminMethod.removeBook();
                    find = true;
                    break;
                case 3:
                    adminMethod.displayAdBook();
                    find = true;
                    break;
                case 4:
                    adminMethod.checkBorrowBook();
                    find = true;
                    break;
                case 5:
                    adminMethod.addAccount();
                    find = true;
                    break;
                case 6:
                    adminMethod.deleteAccount();
                    find = true;
                    break;
                case 7:    
                    adminMethod.DisplayAccountOfReader();
                    find = true;
                    break;
                case 8:
                    menuHome();
                    find = true;
                    break;
                default:
                    System.out.println("Your selection does not exist, please enter your selection as numbers from 1 to 4");
                    find = true;
                    break;
            }
        }
    }

    public static void readerMenu(){
          boolean find = true;
        while (find) {
            System.out.println("         ***                   READER      MENU             ***           ");
            System.out.println("1.  Display book in library                                                 ");
            System.out.println("2.  Search information of book                                         ");
            System.out.println("3.  Sign up to borrow books                                              ");
            System.out.println("4.  Give book back                                                           ");
            System.out.println("5.  Log out                                                                           ");
            System.out.println("Enter your choice by number 1 -> 4: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    readerMethod.displayBook();
                    find = true;
                    break;
                case 2:
                    readerMethod.bookInformation();
                    find = true;
                    break;
                case 3:
                    readerMethod.borrowBook();
                    find = true;
                    break;
                case 4:
                    readerMethod.giveBookBack();
                    find = true;
                    break;
                case 5:
                    menuHome();
                    find = true;
                    break;            
                default:
                    System.out.println("Your selection does not exist, please enter your selection as numbers from 1 to 5");
                    find = true;
                    break;
            }
        }
    }
}
