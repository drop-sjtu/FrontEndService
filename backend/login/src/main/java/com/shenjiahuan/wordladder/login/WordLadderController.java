package com.shenjiahuan.wordladder.login;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "wordladder-play", fallback = WordLadderFallback.class)
public interface WordLadderController {
    @RequestMapping({"/wordladders"})
    Result wordLadder(@RequestParam(value = "from", required = false) String from, @RequestParam(value = "to", required = false) String to);
}
