package org.example.CrudControllersHibernate.university.service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactory implements AutoCloseable{

        private static ManagerFactory instance;
        private final EntityManagerFactory factory;

        private ManagerFactory() {
            factory =  Persistence.createEntityManagerFactory
                    ("dao.entity");
        }

        public EntityManager getManager() {
            return factory.createEntityManager();
        }

        public static ManagerFactory getInstance() {
            if(instance == null){
                instance = new ManagerFactory();
            }
            return instance;
        }

        @Override
        public void close() throws Exception {
            factory.close();
        }
    }

