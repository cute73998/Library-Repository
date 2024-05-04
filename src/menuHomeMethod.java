
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class menuHomeMethod {
        public static void login() {
        System.out.println("***              LOGIN  ACCOUNT           ****");
        boolean found = false;
        boolean adfound = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String userName = sc.nextLine();
        System.out.println("Enter your password:  ");
        String password = sc.nextLine();
        try {

            Scanner enter = new Scanner(new FileInputStream("ReaderAccount.txt"));
            Scanner adEnter = new Scanner(new FileInputStream("AdminAccount.txt"));
            while (enter.hasNextLine()) {
                String read = enter.nextLine();
                String[] line = read.split("_");              
                if (line[0].equals(userName) && line[1].equals(password)) {
                    System.out.println("Log in Successfully!");
                    System.out.println("Welcome reader " + line[2]);
                    System.out.println("id: " + line[3]);
                    found = true;
                    break;
                }
            }
            while (adEnter.hasNextLine()) {
                String adRead = adEnter.nextLine();
                String[] adLine = adRead.split("_");                
                if (adLine[0].equals(userName) && adLine[1].equals(password)) {
                    System.out.println("Log in Successfully!");
                    System.out.println("Welcome admin " + adLine[2]);
                    adfound = true;
                    break;
                }
            }
            if (found) {
                Menu.readerMenu();// menu danh cho reader   
            } else if (adfound) {
                Menu.adMenu(); //menu danh cho admin
            }
            else{
                if (!found && !adfound) {
            System.out.println("This account does not exist");
            Menu.menuHome();
        }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Failed to read accounts");
            Menu.menuHome();
        }
    }
    
    public static void Register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***              REGISTER ACCOUNT              ****");
        System.out.println("");
        System.out.println("Enter your username: ");
        String userName = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        System.out.println("Enter your Name: ");
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
                    Register();
                    found = true;
                    break;
                } else {
                    found = false;
                }
            }
            if (found == false) {
                ps.println(userName + "_" + password + "_" + name + "_" + idSave);
                ps.println("");
                System.out.println("Register successfully !");
                ps.close();
                read.close();
            }
        } catch (Exception e) {
            System.out.println("registration failed !");
        }
    }
    
    public static void information() {
        try {
            Scanner sc = new Scanner(new FileInputStream("BookInformation.txt"));
            while (sc.hasNextLine()) {
                String read = sc.nextLine();
                System.out.println(read);
            }
        } catch (Exception e) {
            System.out.println("Display error !");
        }
    }
    
    public static void exit(){
        System.out.println("***        EXIT SUCCESSFULLY            ***");
        System.out.println("              Goodbye readers                  ");
        System.out.println("Wish you have a nice day! Thank you for using FPT Enemy's software.");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        System.out.println("");
        System.out.println("            /~~~~~~~~\\                           _");
        System.out.println("    ##\\__/ @)      ~~~~~~~~\\                     \\ \\ ) )");
        System.out.println("    |              /~~\\~~~~~                ((    |  \\");
        System.out.println("     \\    /           |                          /   |");
        System.out.println("      (~~~   /         \\____________/~~~~~~~~~~~~   /");
        System.out.println("       ~~~~|~                                     /");
        System.out.println("           :                                      |");
        System.out.println("            \\                                     |");
        System.out.println("            |                               /      \\");
        System.out.println("             \\  \\_         :         \\     /~~~\\    |");
        System.out.println("             /   :~~~~~|   :~~~~~~~~~~|   :     :   :");
        System.out.println("            /    :    /    :         /    :    /    :");
        System.out.println("        (~~~     )(~~~     )     (~~~     )(~~~     )");
        System.out.println("         ~~~~~~~~  ~~~~~~~~       ~~~~~~~~  ~~~~~~~~");
        System.out.println("          STOMP     STOMP          STOMP     STOMP");
        System.out.println("");
        System.out.println("");
        System.out.println(" *****             KNOWLEDGE IS POWER            *****");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
