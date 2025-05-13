public class Student {
    private String name;
    private int rollNo;
    private double marks;

    public Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }

    public String toData() {
        return name + ";" + rollNo + ";" + marks;
    }

    public static Student fromData(String line) {
        String[] parts = line.split(";");
        return new Student(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2]));
    }
}
