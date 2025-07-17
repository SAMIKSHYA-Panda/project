package com.infinite.jsf.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfigTest {
    public static void main(String[] args) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            System.out.println("✅ Hibernate loaded successfully");
            factory.close(); // always close the factory when done
        } catch (Throwable t) {
            System.out.println("❌ Hibernate failed to initialize");
            t.printStackTrace();
        }
    }
}
