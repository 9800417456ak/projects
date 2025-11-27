
import java.io.*;
import java.util.*;

public class StudentGradeManager {
    private static final String FILE_NAME = "students.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Grade Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> System.out.println("Thank you... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter number of subjects: ");
        int numSubjects = Integer.parseInt(scanner.nextLine());

        double[] scores = new double[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter score for subject " + (i + 1) + ": ");
            scores[i] = Double.parseDouble(scanner.nextLine());
        }

        Student student = new Student(id, name, scores);
        saveStudentToFile(student);
        System.out.println("Student added successfully!");
    }

    private static void saveStudentToFile(Student student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(student.toFileString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving student data.");
        }
    }

    private static void viewAllStudents() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No student data found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n=== All Students ===");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                double[] scores = new double[parts.length - 3]; 
                for (int i = 0; i < scores.length; i++) {
                    scores[i] = Double.parseDouble(parts[2 + i]);
                }
                Student student = new Student(id, name, scores);
                System.out.println(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data.");
        }
    }
}





