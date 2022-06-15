package org.example.CrudControllersHibernate.university.service;

import org.example.CrudControllersHibernate.university.api.IService;
import org.example.CrudControllersHibernate.university.dao.HibernateDao;
import org.example.CrudControllersHibernate.university.dao.entity.Group;

import java.util.List;

public class GroupsStudentsService implements IService<Group> {
    private static GroupsStudentsService instance;
    private HibernateDao dao;

    private GroupsStudentsService() {
        this.dao = HibernateDao.getInstance();
    }


    public List readAll(){
        return dao.read(Group.class);
    }

    @Override
    public void create(Group object) {
        //NO USES OF THE ISERVICE HERE
    }


    public void update(Group group){
        if(group.getId() == null){
            throw new IllegalArgumentException("A GROUP WITH ID EXPECTED FOR UPDATE METHOD");
        }
        dao.createOrUpdate(group);
    }

    public void delete(Group group){
        if(group.getId() == null){
            throw new IllegalArgumentException("A GROUP WITH ID EXPECTED FOR DELETE METHOD");
        }
        dao.delete(group);
    }


    public static GroupsStudentsService getInstance() {
        if(instance == null){
            return new GroupsStudentsService();
        }
        return instance;
    }
}
