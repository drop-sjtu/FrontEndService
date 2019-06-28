package com.shenjiahuan.wordladder.login;

import org.springframework.stereotype.Component;

@Component
public class WordLadderFallback implements WordLadderController {

    @Override
    public Result wordLadder(String from, String to) {
        return new Result(null, -4);
    }
}
