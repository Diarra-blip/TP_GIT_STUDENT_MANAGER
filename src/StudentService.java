import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void printList() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("- " + student);
        }
    }

    public boolean addStudent(String studentId, String name) {
        if (findById(studentId) != null) {
            return false;
        }
        students.add(new Student(studentId, name));
        return true;
    }

    public boolean removeStudent(String studentId) {
        Student student = findById(studentId);
        if (student == null) {
            return false;
        }
        students.remove(student);
        return true;
    }

    private Student findById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
public void exportStudentsCsv(String filePath) {
    try (FileWriter writer = new FileWriter(filePath)) {
        writer.write("id,name\n");
        for (Student s : students) {
            writer.write(s.getId() + "," + s.getName() + "\n");
        }
        System.out.println("Exported to CSV: " + filePath);
    } catch (IOException e) {
        System.out.println("Error exporting CSV: " + e.getMessage());
    }
}
}