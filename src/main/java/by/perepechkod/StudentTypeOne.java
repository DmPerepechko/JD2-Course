package by.perepechkod;

import java.text.DecimalFormat;

public class StudentTypeOne implements Study{

    @Override
    public double getStudyResult(double talent){
        double studyTime = hours/talent;
        double partOfTime = studyTime/3;
        System.out.println("Студенту первого типа с размером таланта "+ talent+
                " необходимо:\n время для практики: "+partOfTime+" часов"+
                ";\n время для разбора: "+partOfTime+" часов"+
                ";\n время в потоке: "+partOfTime+" часов"+
                ";\n итого времени для обучения:" + studyTime+" часов");
        return studyTime;
    }
}
