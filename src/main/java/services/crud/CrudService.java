package services.crud;

import java.util.List;

public interface CrudService<T>{

    void create(T t);
    T read(String id);
    List<T> readAll();
    void update(T t);
    void delete(Long id);
}
