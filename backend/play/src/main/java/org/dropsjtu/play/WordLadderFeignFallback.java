package org.dropsjtu.play;

import org.springframework.stereotype.Component;

@Component
public class WordLadderFeignFallback implements WordLadderFeign {

    @Override
    public int check(String token) {
        return 2;
    }
}
