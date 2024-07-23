2b.Write a Java class called Customer to store their name and date_of_birth. The date_of_birth format should be dd/mm/yyyy. Write methods to read customer data as <name, dd/mm/yyyy> and display as <name, dd, mm, yyyy>
using StringTokenizer class considering the delimiter character as “/”.

package customer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Customer {
    String cname, dob;
    Scanner sobj = new Scanner(System.in);

    void read() {
        System.out.println("Enter Customer name:");
        cname = sobj.next();
        System.out.println("Enter Customer DOB in dd/mm/yyyy format");
        dob = sobj.next();
    }

    void display() {
        StringTokenizer st = new StringTokenizer(dob, "/");
        System.out.print(" < " + cname);
        while (st.hasMoreTokens())
            System.out.print(" , " + st.nextToken());
        System.out.print(" >");
    }

    public static void main(String[] args) {
        Customer cobj = new Customer();
        cobj.read();
        System.out.println("Customer Details.................");
        cobj.display();
    }
}
