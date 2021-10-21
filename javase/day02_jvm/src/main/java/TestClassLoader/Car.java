package TestClassLoader;
public class Car {
    //类是模板，对象是具体的
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        String s = new String();
        System.out.println(s.getClass().getClassLoader());
        /*
            1163157884
            1956725890
            356573597
         */
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());
        Class<? extends Car> aClass1 = car1.getClass();
        Class<? extends Car> aClass2 = car2.getClass();
        Class<? extends Car> aClass3 = car3.getClass();
        /**
         * 460141958
         460141958
         460141958
         */
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());
    }
}
