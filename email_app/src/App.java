import java.util.*;
import java.io.*;

public class EmailApp {
    private Scanner s = new Scanner(System.in); // Scanner class
    // Setting variables as private to prevent direct access
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    // Constructor to receive first name, last name
    public EmailApp(String fname, String lname) {
        this.fname = fname;

        this.lname = lname;
        System.out.println("New Employee:" + this.fname + " " + this.lname);
        // Calling methods
        this.dept = this.setDept(); // Department
        this.password = this.generate_password(8); // password
        this.email = this.generate_email(); // email generation

    }

    // Generate mail method
    private String generate_email() {
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase()
                + ".company.com";
    }

    private String setDept() {
        System.out.println("Enter Department code:");
        System.out.println("\n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        // this.dept = s.next();
        boolean flag = false;
        do {
            // System.out.println("Enter Department code");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose again");
            }
        } while (!flag);
        return null;
    }

    // Generate Random password method
    private String generate_password(int length) {
        Random r = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%&*?";
        String values = Capital_chars + Small_chars + numbers + symbols;
        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    // change password method
    public void set_password() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password? (Y/N");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter current password");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = s.next();
                    System.out.println("Password changed successfully");
                } else {
                    System.out.println("Incorrect password");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password change option cancelled!");
            } else {
                System.out.println("Enter Valid choice");
            }
        } while (!flag);
    }

    // set mailbox capacity method
    public void set_mailCap() {
        System.out.println("Current capacity = " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    // set alternate mailbox
    public void alternate_email() {
        System.out.println("Enter alternate mail: ");
        this.alter_email = s.next();
        System.out.println("Alternate email is set");

    }

    // Display user info method
    public void getInfo() {
        System.out.println("Name:" + this.fname + " " + this.lname);
        System.out.println("Department:" + this.dept);
        System.out.println("Email:" + this.email);
        System.out.println("Password:" + this.password);
        System.out.println("Mailbox capacity " + this.mailCapacity + "mb");

        if (alter_email == null) {
            System.out.println("No Alternate mail");
        } else
            System.out.println("Alternate mail " + this.alter_email);
    }

    // System.out.println("Alternate mail " + this.alter_email);

    // Store in file
    public void storefile() {
        try {
            FileWriter in = new FileWriter("C:\\Users\\HP\\Desktop\\info.txt");
            in.write("First name: " + this.fname);
            in.append("\nLast name: " + this.lname);
            in.append("\nEmail: " + this.email);
            in.append("\nPassword:" + this.password);
            in.append("\nCapacity" + this.mailCapacity);
            in.append("\nAlternate mail" + this.alter_email);
            in.close();
            System.out.println("Data Stored..");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Reading file method
    public void read_file() {
        try {
            FileReader f1 = new FileReader("C:\\Users\\HP\\Desktop\\info.txt");
            int i;
            while ((i = f1.read()) != 1) {
                System.out.println((char) i);
            }
            System.out.println();
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
