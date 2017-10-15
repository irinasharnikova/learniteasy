package app.dao.util;

import java.io.Serializable;
import java.util.List;


/**
 * @author Irina Sharnikova
 * irina.sharnikova@yandex.ru
 */
public interface GenericDao<PK extends Serializable, T> {
    void create(T element);

    void update( T element );

    void delete( PK id );

    T get (PK id);

    List<T> getAll();
}
