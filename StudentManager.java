import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private final String FILE = "students.txt";

    public void addStudent(String name, int rollNo, double marks) {
        students.add(new Student(name, rollNo, marks));
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void searchStudent(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void saveToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE));
        for (Student s : students) {
            writer.write(s.toData());
            writer.newLine();
        }
        writer.close();
    }

    public void loadFromFile() throws IOException {
        File file = new File(FILE);
        if (!file.exists()) return;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            students.add(Student.fromData(line));
        }
        reader.close();
    }
}
