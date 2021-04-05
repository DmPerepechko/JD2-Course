package by.perepechkod;

import junit.framework.TestCase;
import org.junit.Test;

public class StudentTypeThreeTest extends TestCase {
    @Test
    public void testGetStudyResult() {
        Study studentTypeOne = StudentFactory.createStudent(TypeStudent.THREE);
        assertEquals(594.0, studentTypeOne.getStudyResult(1));
    }
}