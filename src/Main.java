import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("--- Student Manager CLI ---");
        
        while (true) {
            System.out.print("> Enter command (add, remove, list, quit): ");
            command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("quit")) {
                break;
            }

            switch (command) {
                case "add":
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    service.addStudent(id, name);
                    break;
                case "list":
                    service.printList();
                    break;
                case "remove":
                    System.out.print("ID to remove: ");
                    String rid = scanner.nextLine();
                    service.removeStudent(rid);
                    break;
                case "export":
    if (parts.length == 3 && parts[1].equals("csv")) {
        service.exportStudentsCsv(parts[2]);
    } else {
        System.out.println("Usage: export csv <file_path>");
    }
    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
        scanner.close();
    }
}