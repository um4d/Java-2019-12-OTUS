import ru.otus.hw03.DIYArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> superList = new ArrayList<>();
        System.out.println(superList.size());




        DIYArrayList<String> test = new DIYArrayList<>();

        test.add("2");
        test.add("2");
        test.add("2");
        System.out.println(test.array.length);
        System.out.println(test.size());

        DIYArrayList<String> testArray = new DIYArrayList<>();
        testArray.add("a");
        testArray.add("b");
        testArray.add("c");
        testArray.add("c");



        Collections.copy(test, testArray);

        for(String elem : test) {
            System.out.println(elem);
        }

    }
}
