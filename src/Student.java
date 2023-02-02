import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student implements Comparable<Student> {

    String name;
    int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student Name: " + name + " Roll No: " + rollNo;
    }    

    @Override
    public int compareTo(Student o) {
        return this.rollNo - o.rollNo;
    }

    public static void main(String[] args) {    
        var list = new ArrayList<Student>();
        
        list.add(new Student("Ahmad", 534));
        list.add(new Student("Larry", 456));
        list.add(new Student("Tim", 12));

        System.out.println(list);

        Collections.sort(list);
        
        System.out.println(list);

        Collections.sort(list, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }

}
