package org.example.CrudControllersHibernate.university.service;

import org.example.CrudControllersHibernate.university.dao.HibernateDao;
import org.example.CrudControllersHibernate.university.dao.entity.Student;

import java.util.List;

public class StudentsService {
    private static StudentsService instance;
    private HibernateDao dao;

    private StudentsService() {
        this.dao = HibernateDao.getInstance();
    }


    public List<Student> readAll(){
        Class<Student> studentClass = Student.class;
        return dao.read(studentClass);
    }

    public void create(Student student){
        if(student.getId() != null){
            throw new IllegalArgumentException("A STUDENT WITHOUT ID EXPECTED FOR CREATE METHOD");
        }
        dao.createOrUpdate(student);
    }

    public void update(Student student){
        if(student.getId() == null){
            throw new IllegalArgumentException("A STUDENT WITH ID EXPECTED FOR UPDATE METHOD");
        }
        dao.createOrUpdate(student);
    }

    public void delete(Student student){
        if(student.getId() == null){
            throw new IllegalArgumentException("A STUDENT WITH ID EXPECTED FOR DELETE METHOD");
        }
        dao.delete(student);
    }

    public static StudentsService getInstance() {
        if(instance == null){
            return new StudentsService();
        }
        return instance;
    }
}
