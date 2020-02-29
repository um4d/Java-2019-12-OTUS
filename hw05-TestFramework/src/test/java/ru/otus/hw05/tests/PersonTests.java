package ru.otus.hw05.tests;

import ru.otus.hw05.Person;
import ru.otus.hw05.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTests {

    final Person person = new Person("joker", 15);

    @Test("проверка генерации никнейма на основе имени и возраста")
    public void generateNickNameTest() throws AssertionError{
        String nickName = person.generateNickName();
        assertThat(nickName).isEqualTo("joker2006");
    }

    @Test("проверка генерации никнейма на основе имени и возраста")
    public void generateNickNameTest2() {
        String nickName = person.generateNickName();
        assertThat(nickName).isEqualTo("joker2005");
    }
}


