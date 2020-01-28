package ru.otus.hw02;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class DIYArrayListTest {
    static Random random;


    @BeforeAll
    public static void setup() {
        random = new Random();
    }


    @Test
    public void DIYArrayListCollectionsCopyTest() {
        DIYArrayList<Integer> intListDst = new DIYArrayList<>();
        DIYArrayList<Integer> intListSrc = new DIYArrayList<>();
        for (int i = 0; i < 100; i++) {
            intListDst.add(0);
        }
        for (int i = 0; i < 100; i++) {
            intListSrc.add(random.nextInt(9));
        }
        Collections.copy(intListDst, intListSrc);
        assertEquals(intListDst, intListSrc);
    }

    @Test
    public void DIYArrayListCollectionsSortTest() {
        DIYArrayList<Integer> intList = new DIYArrayList<>();
        for (int i = 0; i < 100; i++) {
            intList.add(random.nextInt(9) - i);
        }
        Collections.sort(intList);
        boolean sorted = true;
        int previous = Integer.MIN_VALUE;
        for (int elem : intList) {
            if (elem < previous)  {
                sorted = false;
                break;
            }
            previous = elem;
        }
        assertTrue(sorted);
    }

    @Test
    public void DIYArrayListCollectionsAddAll() {
        DIYArrayList<String> stringDIYArrayList = new DIYArrayList<>();
        String[] stringArray = {"one", "two", "three"};
        Collections.addAll(stringDIYArrayList, "one", "two", "three");
        boolean added = true;
        for (int i = 0; i < stringArray.length; i ++) {
            if (!stringArray[i].equals(stringDIYArrayList.get(i))) {
                added = false;
            }
        }
        assertTrue(added);
    }

}
