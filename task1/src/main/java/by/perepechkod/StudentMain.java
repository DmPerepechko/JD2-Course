package by.perepechkod;

public class StudentMain {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            double talent = (double) ((int) (Math.random() * 10 + 1)) / 10;
            Study studentTypeOne = StudentFactory.createStudent(TypeStudent.ONE);
            Study studentTypeTwo = StudentFactory.createStudent(TypeStudent.TWO);
            Study studentTypeThree = StudentFactory.createStudent(TypeStudent.THREE);
            studentTypeOne.getStudyResult(talent);
            studentTypeTwo.getStudyResult(talent);
            studentTypeThree.getStudyResult(talent);
        }
    }
}

