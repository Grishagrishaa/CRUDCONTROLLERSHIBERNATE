package org.example.CrudControllersHibernate.university.service;


import org.example.CrudControllersHibernate.university.api.IService;
import org.example.CrudControllersHibernate.university.dao.HibernateDao;
import org.example.CrudControllersHibernate.university.dao.entity.Group;

import java.util.List;

public class GroupsService implements IService<Group> {
    private static GroupsService instance;
    private final HibernateDao dao;

    private GroupsService() {
        this.dao = HibernateDao.getInstance();
    }


    public List<Group> readAll(){
        return dao.read(Group.class);
    }

    public void create(Group group){
        if(group.getId() != null){
            throw new IllegalArgumentException("A GROUP WITHOUT ID EXPECTED FOR CREATE METHOD");
        }
        if(group.getStudents().size() != 0){
            throw new IllegalArgumentException("OPERATIONS WITH STUDENTS ON ANOTHER URL: .../json/groups/manage");
        }
        dao.createOrUpdate(group);
    }


    public void update(Group group){
        if(group.getId() == null){
            throw new IllegalArgumentException("A GROUP WITH ID EXPECTED FOR UPDATE METHOD");
        }
        if(group.getStudents().size() != 0){
            throw new IllegalArgumentException("OPERATIONS WITH STUDENTS ON ANOTHER URL: .../json/groups/manage");
        }
        dao.createOrUpdate(group);
    }

    public void delete(Group group){
        if(group.getId() == null){
            throw new IllegalArgumentException("A GROUP WITH ID EXPECTED FOR DELETE METHOD");
        }
        if(group.getStudents().size() != 0){
            throw new IllegalArgumentException("OPERATIONS WITH STUDENTS ON ANOTHER URL: .../json/groups/manage");
        }
        dao.delete(group);
    }


    public static GroupsService getInstance(){
        if(instance == null){
            instance  = new GroupsService();
        }
        return instance;
    }
}
