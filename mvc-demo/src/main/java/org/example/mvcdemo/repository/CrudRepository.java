package org.example.mvcdemo.repository;

import java.util.List;

//CRUD - Create, Read, Update, Delete
public interface CrudRepository<T> {
    List<T> findAll(); // получить все данные

    void save(T model); // сохранрить объект в хранилище
}
