package by.perepechkod;

import junit.framework.TestCase;
import org.junit.Test;

public class StudentTypeOneTest extends TestCase {
    @Test
    public void testGetStudyResult() {
        Study studentTypeOne = StudentFactory.createStudent(TypeStudent.ONE);
        assertEquals(198.0, studentTypeOne.getStudyResult(1));
    }
}