package org.dropsjtu.play;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "wordladder-login", fallback = WordLadderFeignFallback.class)
public interface WordLadderFeign {
    @GetMapping(value = "/check")
    int check(@RequestParam(value = "token") String token);
}
