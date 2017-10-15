package app.service;

import app.entity.Word;

import java.util.List;

/**
 * @author Irina Sharnikova
 * irina.sharnikova@yandex.ru
 */
public interface WordService {

    void addWord( Word word );

    List<Word> getWords();
}
