package com.tms.web.config;

import com.tms.web.entity.Car2;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

    public static SessionFactory sessionFactory;

    private HibernateConfiguration() {
    }

    public static void prepareHibernate() {
        Configuration configuration = new Configuration();
        // --------- connection
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/lesson27");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "1234");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        // ---------hibernate specific
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperty("hibernate.format_sql", "true");
        configuration.addAnnotatedClass(Car2.class);

        sessionFactory = configuration.buildSessionFactory();
    }
}