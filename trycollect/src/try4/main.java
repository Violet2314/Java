package try4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("我",198));
        list.add(new Student("你",178));
        list.add(new Student("他",188));

        String[] array = list.stream().map(Student::toString).toArray(String[]::new);
        System.out.print(Arrays.toString(array));
    }
}
