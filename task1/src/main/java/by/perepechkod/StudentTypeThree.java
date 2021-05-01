package by.perepechkod;

import java.text.DecimalFormat;

public class StudentTypeThree implements Study{
    @Override
    public double getStudyResult(double talent){
        double studyTime = hours*3/talent;
        System.out.println("Студенту третьего типа с размером таланта "+ talent+
                " необходимо:\n время для практики: "+studyTime+" часов"+
                ";\n итого времени для обучения:" + studyTime+" часов");
        return studyTime;
    }
}
