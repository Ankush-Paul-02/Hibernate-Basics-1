package org.paul;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App {
    public static void main(String[] args) {
        Alien alien = new Alien();
        AlienName alienName = new AlienName();
        alienName.setFirstName("Samrat");
        alienName.setLastName("Paul");

        /*
        alien.setId(104);
        alien.setName("Soumili");
        alien.setColor("Pink");*/

        alien.setId(200);
        alien.setColor("Grey");
        alien.setName(alienName);


        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Save data
        session.save(alien);

        // Get data
        // alien = (Alien) session.get(Alien.class, 104);

        transaction.commit();

        System.out.println(alien);

    }
}
