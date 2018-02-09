package lab5;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter list of numbers with whitespace: ");
        String str = input.nextLine();
        Scanner line = new Scanner(str);
        while (true) {
           ArrayList<Integer> arrayList = new ArrayList();

           while (line.hasNextLine()) {
                arrayList.add(line.nextInt());
           }

           System.out.println(arrayList);
           System.out.print("Enter list of numbers with whitespace: ");
           str = input.nextLine();
           line = new Scanner(str);
        }
    }
}



