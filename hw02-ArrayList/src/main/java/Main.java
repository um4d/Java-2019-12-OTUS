import ru.otus.hw03.DIYArrayList;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        DIYArrayList<Integer> test = new DIYArrayList<>();
        DIYArrayList<Integer> test9 = new DIYArrayList<>();
        test.add(21);
        test.add(2);
        test.add(8);

        for(int i = 0; i < 40; i++ ) {
            test9.add(9);
        }
        Collections.sort(test);
        Collections.copy(test9, test);
        System.out.println(test.isEmpty());
        System.out.println(test9.toString());
        Collections.sort(test9);
        System.out.println(test9);

    }
}
