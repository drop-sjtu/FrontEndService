package com.shenjiahuan.wordladder.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    WordLadderController wordLadderController;

    @RequestMapping("/wordladders")
    public Result callWordLadder(@RequestParam(value = "from", required = false) String from, @RequestParam(value = "to", required = false) String to) throws Exception {
        return wordLadderController.wordLadder(from, to);
    }
}
