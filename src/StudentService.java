import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void printList() {
        if (students.isEmpty()) {
            System.out.println("No students.");
        } else {
            System.out.println("Students:");
            for (Student s : students) {
                System.out.println("- " + s.getId() + ": " + s.getName());
            }
        }
    }

    public boolean addStudent(String id, String name) {
        for (Student s : students) {
            if (s.getId().equals(id)) return false;
        }
        students.add(new Student(id, name));
        return true;
    }

    public boolean removeStudent(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }
}