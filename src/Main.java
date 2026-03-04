import java.util.Scanner;

class Student {
    String name;
    int mark1, mark2, mark3;
    double average;

    // Method to take input
    void getInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        System.out.print("Enter Mark 1: ");
        mark1 = sc.nextInt();

        System.out.print("Enter Mark 2: ");
        mark2 = sc.nextInt();

        System.out.print("Enter Mark 3: ");
        mark3 = sc.nextInt();
    }

    // Method to calculate average
    void calculateAverage() {
        average = (mark1 + mark2 + mark3) / 3.0;
    }

    // Method to display result
    void displayResult() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Name: " + name);
        System.out.println("Average: " + average);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.getInput();
        s.calculateAverage();
        s.displayResult();
    }
}