package com.tms.web.dao;

import com.tms.web.entity.Car2;
import com.tms.web.entity.CarModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.List;
import static com.tms.web.config.HibernateConfiguration.sessionFactory;

public class CarDao implements ServiceCar{

    @Override
    public void addCar(String nom, String model) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CarModel carModel;
        if (model.equals("Audi")) {
            carModel = CarModel.Audi;
        } else if (model.equals("BMW")) {
            carModel = CarModel.BMW;
        } else {
            carModel = CarModel.Porsche;
        }

        Car2 car2 = new Car2(nom, carModel, new Date(), true);
        session.save(car2);
        transaction.commit();
        session.close();
    }

    @Override
    public void editСar(String id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Car2 car = session.createQuery("from Car2 where id = :id", Car2.class)
                .setParameter("id", Integer.parseInt (id)).getSingleResult();

        car.setInStock(false);
        session.saveOrUpdate(car);

        transaction.commit();
        session.close();
    }

    @Override
    public void delСar(String id) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Car2 car = session.createQuery("from Car2 where id = :id", Car2.class)
                .setParameter("id", Integer.parseInt (id)).getSingleResult();

        session.delete(car);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Car2> getCar(String nom) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Car2> cars;
        if (nom.equals("")) {
            cars = session.createQuery("from Car2", Car2.class).list();
        } else {
            cars = session.createQuery("from Car2 where nom = :nom", Car2.class)
                    .setParameter("nom", nom).list();
        }
        transaction.commit();
        session.close();

        return cars;
    }
}
