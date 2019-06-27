package org.dropsjtu.play;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class WordLadderController {
    private WordLadder wordLadder;

    @Autowired
    private WordLadderFeign auth;

    @PostConstruct
    private void init() {
        try {
            this.wordLadder = new WordLadder("/static/EnglishWords.txt");
        } catch (IOException | NullPointerException ex) {
            this.wordLadder = null;
        }
    }

    @RequestMapping({"/wordladders"})
    public WordLadderResult wordLadder(@RequestParam(value = "from", required = false) String from,
                                       @RequestParam(value = "to", required = false) String to,
                                       @RequestParam(value = "token") String token) {
        if (auth.check(token) != 1)
            return new WordLadderResult(null, -4);

        ArrayList<String> result = null;
        int status = 0;
        if (from == null || to == null) {
            status = -3;
            return new WordLadderResult(result, status);
        }

        try {
            result = this.wordLadder.get(from, to);
            if (result == null) {
                status = -1;
            }
        } catch (NullPointerException ex) {
            status = -2;
        }

        return new WordLadderResult(result, status);
    }
}
