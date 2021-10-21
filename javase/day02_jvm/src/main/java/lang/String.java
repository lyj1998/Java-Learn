package lang;

public class String {
    //双亲委派机制：安全

//    public String toString(){
//        return "hello";
//    }
    public static void main(String[] args) {
        String s = new String();
        System.out.println(s.getClass().getClassLoader());
    }
}
