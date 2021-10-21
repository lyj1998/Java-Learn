package lang;

public class Student {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.getClass().getClassLoader());
    }
}
