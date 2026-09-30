import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {
    @Test
    void shouldAddContact() {
        PhoneBook phoneBook = new PhoneBook();

        int result = phoneBook.add("Иван", "123");

        assertEquals(1, result);
    }

    @Test
    void shouldReturnNumberOfContacts() {
        PhoneBook phoneBook = new PhoneBook();

        assertEquals(1, phoneBook.add("Иван", "123"));
        assertEquals(2, phoneBook.add("Пётр", "456"));
        assertEquals(3, phoneBook.add("Алексей", "789"));
    }

    @Test
    void shouldFindNameByNumber() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иван", "123");

        String result = phoneBook.findByNumber("123");

        assertEquals("Иван", result);
    }

    @Test
    void shouldFindNumberByName() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иван", "123");

        String result = phoneBook.findByName("Иван");

        assertEquals("123", result);
    }

    @Test
    void shouldPrintAllNamesInAlphabeticalOrder() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Пётр", "333");
        phoneBook.add("Иван", "222");
        phoneBook.add("Алексей", "111");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            phoneBook.printAllNames();

        } finally {
            System.setOut(originalOut);
        }

        String expected =
                "Алексей" + System.lineSeparator()
                        + "Иван" + System.lineSeparator()
                        + "Пётр" + System.lineSeparator();

        assertEquals(expected, output.toString());
    }
}