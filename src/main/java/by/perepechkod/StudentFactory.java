package by.perepechkod;

import java.lang.reflect.Type;

public class StudentFactory {
    public static Study createStudent(TypeStudent typeStudent){
        Study study = null;
        switch (typeStudent){
            case ONE:
                study = new StudentTypeOne();
                break;
            case TWO:
                study = new StudentTypeTwo();
                break;
            case THREE:
                study = new StudentTypeThree();
        }
        //study.getStudyResult();
        return study;
    }
}
