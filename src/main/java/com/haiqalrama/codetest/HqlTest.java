package com.haiqalrama.codetest;

import com.haiqalrama.codetest.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Properties;

public class HqlTest {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "postgres");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.PostgreSQL81Dialect");
        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addProperties(prop);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //Insert some data for testing purpose
        session.getTransaction().begin();
        User test = new User("nama");
        session.save(test);
        User test2 = new User("nama2");
        session.save(test2);
        session.getTransaction().commit();


        //Select all data from User
        Query<User> query = session.createQuery("from User", User.class);
        List<User> i = query.getResultList();
        for (User user : i) {
            System.out.println(user);
        }

        //Update field name from data with name "nama" to "Haiqal"
        session.getTransaction().begin();
        Query query2 = session.createQuery("update User u set u.name=:nameUpdated where u.name=:name");
        query2.setParameter("name", "nama");
        query2.setParameter("nameUpdated", "Haiqal");
        query2.executeUpdate();
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
