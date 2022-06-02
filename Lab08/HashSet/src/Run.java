import java.util.HashSet;
import java.util.Scanner;

public class Run {
    private static Scanner input = new Scanner(System.in);
    private static StudentList list;

    public static void menu(){
        System.out.println("1. Add a new student to the list");
        System.out.println("2. Delete a student from the list");
        System.out.println("3. Search by name");
        System.out.println("4. Search by id");
        System.out.println("5. Exit");
    }

    public static void addStudent(){
        int id = 0;
        String fn;
        String ln;
        double mark;
        System.out.println("Enter student ID: ");
        id = input.nextInt();
        System.out.println("Enter first name: ");
        fn = input.next();
        System.out.println("Enter last name: ");
        ln = input.next();
        System.out.println("Enter mark: ");
        mark = input.nextDouble();
        Student s = new Student(id, fn, ln, mark);
        list.add(s);
    }

    public static void deleteStudent() {
        int id;
        System.out.println("Enter student id: ");
        id = input.nextInt();
        list.remove(id);
    }

    public static void searchByName() {
        String name;
        System.out.println("Enter a name: ");
        name = input.next();
        HashSet<Student> found = list.findByName(name);
        list.showList(found);
    }

    public static void searchById() {
        int id;
        System.out.println("Enter an ID: ");
        id = input.nextInt();
        Student s = list.findById(id);
        if (s==null) {
            System.out.println("Not found");
        } else {
            s.printInfo();
        }
    }


    public static void main(String[] args) {
        list = new StudentList();
        menu();

        while(true) {
            int choice;
            System.out.println("#: ");
            choice = input.nextInt();
            if (choice == 1) {
                addStudent();
                menu();
            } else if (choice == 2) {
                deleteStudent();
                menu();
            } else if (choice == 3) {
                searchByName();
                menu();
            } else if (choice == 4) {
                searchById();
                menu();
            } else if (choice == 5) {
                System.exit(0);
            }
        }
    }

}