package app.controller;

import app.entity.Word;
import app.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Irina Sharnikova
 * irina.sharnikova@yandex.ru
 */
@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/words/save", method = RequestMethod.POST, produces = "application/json")
    public Boolean addWord(@RequestBody Word word)  {
        wordService.addWord(word);
        return Boolean.TRUE;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex()  {
        return "index";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/words", method = RequestMethod.GET, produces = "application/json")
    public List<Word> getWords()  {
        return wordService.getWords();
    }
}
