package Hibernate;

import org.hibernate.Session;
import java.time.LocalDate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Hibernate_First_Project
{
    public static void main(String[] args)
    {
        EmployeeDB emp = new EmployeeDB(16, "Nancy", "Chawla", "nancy@gmail.com0", "9825676896", LocalDate.of(2024, 6, 2), 3, 1256789.00, 2, 4);

        Configuration cfg = new Configuration();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

//        Transaction transaction = session.beginTransaction();

        session.save(emp);
//        transaction.commit();

        System.out.println(emp);
    }
}
