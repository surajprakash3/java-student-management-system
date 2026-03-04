import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {

    // Student class
    static class Student {
        String name;
        int mark1, mark2, mark3;
        double average;

        void calculateAverage() {
            average = (mark1 + mark2 + mark3) / 3.0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Run as Server");
        System.out.println("2. Run as Client");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();
        sc.nextLine();  // clear buffer

        if (choice == 1) {
            runServer();
        } else if (choice == 2) {
            runClient();
        } else {
            System.out.println("Invalid choice!");
        }
    }

    // SERVER METHOD
    static void runServer() {
        int port = 5000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            Student s = new Student();

            s.name = in.readLine();
            s.mark1 = Integer.parseInt(in.readLine());
            s.mark2 = Integer.parseInt(in.readLine());
            s.mark3 = Integer.parseInt(in.readLine());

            s.calculateAverage();

            out.println("Name: " + s.name);
            out.println("Average: " + s.average);

            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CLIENT METHOD
    static void runClient() {
        String host = "localhost";
        int port = 5000;

        try {
            Socket socket = new Socket(host, port);

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Name: ");
            out.println(sc.nextLine());

            System.out.print("Enter Mark 1: ");
            out.println(sc.nextLine());

            System.out.print("Enter Mark 2: ");
            out.println(sc.nextLine());

            System.out.print("Enter Mark 3: ");
            out.println(sc.nextLine());

            System.out.println("\n--- Result From Server ---");
            System.out.println(in.readLine());
            System.out.println(in.readLine());

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
