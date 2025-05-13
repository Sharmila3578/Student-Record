import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        try {
            manager.loadFromFile();
        } catch (Exception e) {
            System.out.println("Failed to load students.");
        }

        while (true) {
            System.out.println("\n--- Student Record System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    System.out.print("Enter marks: ");
                    double marks = sc.nextDouble();
                    manager.addStudent(name, roll, marks);
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = sc.nextInt();
                    manager.searchStudent(searchRoll);
                    break;
                case 4:
                    try {
                        manager.saveToFile();
                        System.out.println("Data saved. Goodbye!");
                    } catch (Exception e) {
                        System.out.println("Failed to save data.");
                    }
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
