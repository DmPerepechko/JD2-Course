package PersonTask;

import junit.framework.TestCase;
import org.junit.Test;

public class PersonMethodsTest extends TestCase {
    @Test
    public void testMakePerson() {
        Person person = PersonMethods.makePerson();
        assertNotNull(person);
        assertTrue(person.getAge()>=15&&person.getAge()<=30);
        assertTrue(person.toString().startsWith("Name="));
    }
}