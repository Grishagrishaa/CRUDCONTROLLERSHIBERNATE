package org.example.CrudControllersHibernate.university.api;

import java.util.List;

public interface IDao <T> {
    <T> void createOrUpdate(T object);
    <T> List read(Class<T> type);

    <T> void delete(T object);
}
