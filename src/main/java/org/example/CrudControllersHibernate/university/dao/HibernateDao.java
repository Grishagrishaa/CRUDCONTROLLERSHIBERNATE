package org.example.CrudControllersHibernate.university.dao;

import org.example.CrudControllersHibernate.university.api.IDao;
import org.example.CrudControllersHibernate.university.service.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.OptimisticLockException;
import java.util.List;

public class HibernateDao<T> implements IDao<T> {
    private static HibernateDao instance;
    protected HibernateDao() {
    }

    //save in database
    //UPDATE IN DATABASE IF ID WAS PROVIDED
    public<T> void createOrUpdate(T object){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();
        session.saveOrUpdate(object);

        try{
            session.getTransaction().commit();
        }catch (OptimisticLockException e){
            throw new IllegalArgumentException("NO SUCH OBJECT WITH PROVIDED ID WAS FOUND");
        }
        session.close();

    }

    //read from database
    public<T> List read(Class<T> type){
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();
        List result = session.createQuery("from " + type.getName()).list();
        session.getTransaction().commit();
        session.close();


        return result;
    }

    public<T> void delete(T object){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(object.getClass().getName(), object);
        try{
            session.getTransaction().commit();
        }catch (OptimisticLockException e){
            throw new IllegalArgumentException("NO SUCH OBJECT WITH PROVIDED ID WAS FOUND");
        }
        session.close();
    }



    public static HibernateDao getInstance(){
        if(instance == null){
            instance = new HibernateDao();
        }
        return instance;
    }



}
