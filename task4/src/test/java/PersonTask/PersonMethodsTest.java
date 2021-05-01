package PersonTask;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class PersonMethodsTest extends TestCase {
    @Test
    public void testMakePerson() {
        List<Person> person = PersonMethods.makePerson(5);
        assertNotNull(person);
        assertTrue(person.toString().startsWith("Name="));
    }
}