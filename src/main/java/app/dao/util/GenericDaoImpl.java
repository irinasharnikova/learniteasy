package app.dao.util;

import lombok.Data;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import app.entity.Word;

/**
 * @author Irina Sharnikova
 * irina.sharnikova@yandex.ru
 */
@Repository
@Data
public abstract class GenericDaoImpl< PK extends Serializable, T> implements GenericDao<PK, T> {

    private Class<T> type;

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDaoImpl( Class<T> type ) {
        this.type = type;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void create( T t ) {

    }

    @Override
    public void update( T t ) {

    }

    @Override
    public void delete( PK id ) {

    }

    @Override
    public T get( PK id ) {
        return null;
    }

//    @Override
//    public List<T> getAll() {
//        return entityManager.createQuery("select w from Word w where w.name = 1", Word.class ).getResultList();
//    }

//    private Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }
}