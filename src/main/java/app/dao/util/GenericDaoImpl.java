package app.dao.util;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Irina Sharnikova
 * irina.sharnikova@yandex.ru
 */
@Repository
@Data
public class GenericDaoImpl< PK extends Serializable, T> implements GenericDao<PK, T> {

    private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    public GenericDaoImpl( Class<T> type ) {
        this.type = type;
    }

    @Override
    public void create( T t ) {
        getSession().save( t );
    }

    @Override
    public void update( T t ) {
        getSession().update( t );
    }

    @Override
    public void delete( PK id ) {
        T element = getSession().load( type, id );
        getSession().delete( element );
    }

    @Override
    public T get( PK id ) {
        return getSession().get( type, id );
    }

    @Override
    public List<T> getAll() {
        return getSession().createQuery( "from " + type.getName(), type ).list();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}