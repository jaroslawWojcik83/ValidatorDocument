import org.omg.PortableInterceptor.ServerRequestInfo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scr = new Scanner(System.in);

        System.out.print("Enter id document: ");
        String idDoc = scr.nextLine();

        Validator validator = new Validator();

        if (validator.validate(idDoc)) {
            System.out.println("Id document: " + idDoc + " is OK");
        } else {
            System.out.println("Id document: " + idDoc + " is BAD");
        }
    }
}
