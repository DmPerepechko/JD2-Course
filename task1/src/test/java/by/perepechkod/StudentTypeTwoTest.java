package by.perepechkod;

import junit.framework.TestCase;
import org.junit.Test;

public class StudentTypeTwoTest extends TestCase {

    @Test
    public void testGetStudyResult() {
        Study studentTypeOne = StudentFactory.createStudent(TypeStudent.TWO);
        assertEquals(396.0, studentTypeOne.getStudyResult(1));
    }
}