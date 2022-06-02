import java.util.*;

public class StudentList {
    private HashSet<Student> list;
    private int length;

    public StudentList(){
        list = new HashSet<Student>();
    }

    public HashSet<Student> findByName (String name) {
        boolean found = false;
        HashSet<Student> matches = new HashSet<>();
        for (Student s: list) {
            String fullName = new String(s.getFirstName() + " " + s.getLastName()). toLowerCase();
            if (fullName.matches("(.*)" + name.toLowerCase() + "(.*)")) {
                matches.add(s);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Not found");
        }
        return matches;
    }
    public Student findById(int id) {
        for (Student s:list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void add(Student s){
        list.add(s);
    }

    public void remove(int id){
        boolean found = false;
        for (Student s: list) {
            if (s.getId() == id) {
                int choice;
                System.out.println("Are you sure deleting this student? (1.Yes 2.No");
                choice = new Scanner(System.in).nextInt();
                if (choice == 1)
                    list.remove(s);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Cannot find student with id "+id);
        }
    }


    public void showList() {
        for (Student s: list) {
            s.printInfo();
        }
    }
    public void showList(HashSet<Student> slist){
        for (Student s: slist) {
            s.printInfo();
        }
    }

}