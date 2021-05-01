package by.perepechkod;

import java.text.DecimalFormat;

public class StudentTypeTwo implements Study {
    @Override
    public double getStudyResult(double talent){
        double studyTime = hours*2/talent;
        double partOfTime = studyTime/2;
        System.out.println("Студенту второго типа с размером таланта "+ talent+
                " необходимо:\n время для практики: "+partOfTime+" часов"+
                ";\n время для разбора: "+partOfTime+" часов"+
                ";\n итого времени для обучения:" + studyTime+" часов");
        return studyTime;
    }
}
