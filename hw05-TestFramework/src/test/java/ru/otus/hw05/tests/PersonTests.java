package ru.otus.hw05.tests;

import ru.otus.hw05.Person;
import ru.otus.hw05.annotations.After;
import ru.otus.hw05.annotations.Before;
import ru.otus.hw05.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTests {

    Person person;

    @Before
    public void initTestObject() {
        person = new Person("joker", 15);
    }

    @Test("проверка генерации никнейма на основе имени и возраста")
    public void generateNickNameTest() throws AssertionError{
        String nickName = person.generateNickName();
        assertThat(nickName).isEqualTo("joker2005");
    }

    @Test("проверка генерации никнейма на основе имени и возраста после изменения имени")
        public void generateNickNameAfterNameChanging() {
            person.setName("batman");
            String nickName = person.generateNickName();
            assertThat(nickName).isEqualTo("joker2005");
        }

    @Test("проверка генерации никнейма на основе имени и возраста после изменения возраста")
    public void generateNickNameAfterAgeChanging() {
        person.setAge(21);
        String nickName = person.generateNickName();
        assertThat(nickName).isEqualTo("batman1999");
    }


    @After
    public void finish() {}

}



