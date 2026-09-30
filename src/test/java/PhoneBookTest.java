import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {
    @Test
    void shouldAddContact() {
        PhoneBook phoneBook = new PhoneBook();

        int result = phoneBook.add("Иван", "123");

        assertEquals(1, result);
    }
}
