2a. Design a superclass called Staff with details as StaffId, Name, Phone, and Salary. Extend this class by writing three subclasses namely Teaching (domain, publications), Technical (skills), and Contract (period). 
Write a Java program to read and display at least 3 staff objects of all three categories.

package staffmain;
import java.util.Scanner;

class Staff {
    private int staffid, salary;
    private long phone;
    private String name;

    void display() {
        System.out.println("Staff ID: " + staffid);
        System.out.println("Salary: " + salary);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
    }

    void read() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter SID, Salary, Name, Phone Number");
        staffid = in.nextInt();
        salary = in.nextInt();
        name = in.next();
        phone = in.nextLong();
    }
}

class Teaching extends Staff {
    String domain, publication;

    void read() {
        Scanner in = new Scanner(System.in);
        super.read();
        System.out.println("Enter Domain and Publications");
        domain = in.next();
        publication = in.next();
    }

    void display() {
        super.display();
        System.out.println("Domain: " + domain);
        System.out.println("Publication: " + publication);
    }
}

class Technical extends Staff {
    String skills;

    void read() {
        Scanner in = new Scanner(System.in);
        super.read();
        System.out.println("Enter skills");
        skills = in.next();
    }

    void display() {
        super.display();
        System.out.println("Skills: " + skills);
    }
}

class Contract extends Staff {
    int period;

    void read() {
        Scanner in = new Scanner(System.in);
        super.read();
        System.out.println("Enter the contract period");
        period = in.nextInt();
    }

    public void display() {
        super.display();
        System.out.println("Period: " + period);
    }
}

package staffmain;
import java.util.Scanner;

public class StaffMain {

    public static void main(String[] args) {
        int n, ch;
        Scanner sobj = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Teaching\n2. Technical\n3. Contract\n4. Exit\nEnter your Category:");
            ch = sobj.nextInt();
            
            switch (ch) {
                case 1:
                    System.out.println("How many teaching staff");
                    n = sobj.nextInt();
                    Teaching[] te = new Teaching[n];
                    for (int i = 0; i < n; i++) {
                        te[i] = new Teaching();
                        te[i].read();
                    }
                    System.out.println("\nTeaching staff details\n");
                    for (int i = 0; i < n; i++)
                        te[i].display();
                    break;

                case 2:
                    System.out.println("How many technical staff");
                    n = sobj.nextInt();
                    Technical[] tech = new Technical[n];
                    for (int i = 0; i < n; i++) {
                        tech[i] = new Technical();
                        tech[i].read();
                    }
                    System.out.println("\nTechnical staff details\n");
                    for (int i = 0; i < n; i++)
                        tech[i].display();
                    break;

                case 3:
                    System.out.println("How many contract staff");
                    n = sobj.nextInt();
                    Contract[] con = new Contract[n];
                    for (int i = 0; i < n; i++) {
                        con[i] = new Contract();
                        con[i].read();
                    }
                    System.out.println("Contract staff details\n");
                    for (int i = 0; i < n; i++)
                        con[i].display();
                    break;
                    
                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
