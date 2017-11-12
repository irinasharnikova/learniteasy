package app.dao.impl;

import app.dao.util.GenericDaoImpl;
import app.entity.Word;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Irina Sharnikova
 * irina.sharnikova@yandex.ru
 */
@Repository
public class WordDao extends GenericDaoImpl<Long, Word> {
    public WordDao() {
        super(Word.class);
    }

    @Override
    public List<Word> getAll() {
        return getEntityManager().createQuery("select w from Word w", Word.class ).getResultList();
    }
}


