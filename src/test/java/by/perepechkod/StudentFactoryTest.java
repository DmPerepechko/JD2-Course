package by.perepechkod;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class StudentFactoryTest extends TestCase {
    @Test
    public void testStudentOneSuccess(){
        Study studentTypeOne = StudentFactory.createStudent(TypeStudent.ONE);
        assertTrue(studentTypeOne instanceof StudentTypeOne);
    }

    @Test
    public void testStudentTwoSuccess(){
        Study studentTypeTwo = StudentFactory.createStudent(TypeStudent.TWO);
        assertTrue(studentTypeTwo instanceof StudentTypeTwo);
    }

    @Test
    public void testStudentThreeSuccess(){
        Study studentTypeThree = StudentFactory.createStudent(TypeStudent.THREE);
        assertTrue(studentTypeThree instanceof StudentTypeThree);
    }

}