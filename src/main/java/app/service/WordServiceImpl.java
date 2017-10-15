package app.service;

import app.dao.util.GenericDao;
import app.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Irina Sharnikova
 * irina.sharnikova@yandex.ru
 */
@Service
@Transactional
public class WordServiceImpl implements WordService {

    @Autowired
    private GenericDao<Long, Word> wordDao;

    @Override
    public void addWord(Word word) {
        wordDao.create(word);
    }

    @Override
    public List<Word> getWords() {
        return wordDao.getAll();
    }
}
