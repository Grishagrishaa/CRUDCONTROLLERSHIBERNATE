package org.example.CrudControllersHibernate.university.api;

import org.example.CrudControllersHibernate.university.dao.entity.Group;

import java.util.List;

public interface IService<G> {
    List<G> readAll();

    void create(G object);

    void update(G object);

    void delete(G object);
}
