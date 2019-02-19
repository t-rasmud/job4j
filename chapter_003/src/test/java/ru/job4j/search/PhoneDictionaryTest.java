package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Elena Kartashova (kartashova.ee@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionaryTest {

    /**
     * Тест ситуации, когда пользователь найден.
     */
    @Test
    public void whenFindByCityPart() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Иван", "Козлов", "3373777", "Воркута")
        );
        phones.add(
                new Person("Константин", "Тимофеев", "343599", "Миллерово")
        );
        List<Person> persons = phones.find("еро");
        assertThat(persons.iterator().next().getSurname(), is("Тимофеев"));
    }

    /**
     * Тест ситуации, когда пользователь не найден.
     */
    @Test
    public void whenNotFindByCity() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Иван", "Козлов", "3373777", "Воркута")
        );
        phones.add(
                new Person("Константин", "Тимофеев", "343599", "Миллерово")
        );
        List<Person> persons = phones.find("Ростов");
        Person expected = null;
        assertThat(persons, is(expected));
    }
}
