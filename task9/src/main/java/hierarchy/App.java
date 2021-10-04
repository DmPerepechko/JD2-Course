package hierarchy;


import hierarchy.pojos.*;
import hierarchy.util.SessionUtil;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;

public class App {
    public static void main( String[] args ) {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();

        City city = City.builder()
                .cityName("Paris")
                .build();

        Address address = Address.builder()
                .city(city)
                .street("Rue de Rivoli")
                .build();

        Task task = Task.builder()
                .name("task")
                .description("task_1")
                .build();

        HomeTask homeTask = HomeTask.builder()
                .name("home_task")
                .description("home_task_1")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(20)))
                .address(address)
                .build();

        WorkTask workTask = WorkTask.builder()
                .name("work_task")
                .description("work_task_1")
                .cost("700")
                .build();

            session.save(task);
            session.save(homeTask);
            session.save(workTask);
            session.getTransaction().commit();

            SessionUtil.closeSessionFactory();
        }
}