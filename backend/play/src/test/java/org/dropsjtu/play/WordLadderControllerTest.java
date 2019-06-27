package org.dropsjtu.play;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordLadderControllerTest {
    private final static String TOKEN = "3535ce20-1b02-41fe-8e8b-e4ac5ab8d7c7";
    @Autowired
    WordLadderController controller;

    @Test
    public void testWordLadderSuccessful() {
        WordLadderResult result1 = controller.wordLadder("code", "data", TOKEN);
        assertEquals(0, result1.status);
        assertEquals(5, result1.result.size());
        WordLadderResult result2 = controller.wordLadder("cat", "dog", TOKEN);
        assertEquals(0, result2.status);
        assertEquals(4, result2.result.size());
        WordLadderResult result3 = controller.wordLadder("sleep", "awake", TOKEN);
        assertEquals(0, result3.status);
        assertEquals(10, result3.result.size());
        WordLadderResult result4 = controller.wordLadder("angel", "devel", TOKEN);
        assertEquals(0, result4.status);
        assertEquals(10, result4.result.size());
        WordLadderResult result5 = controller.wordLadder("random", "ransom", TOKEN);
        assertEquals(0, result5.status);
        assertEquals(2, result5.result.size());
        WordLadderResult result6 = controller.wordLadder("work", "play", TOKEN);
        assertEquals(0, result6.status);
        assertEquals(7, result6.result.size());
    }

    @Test
    public void testWordLadderNoExist() {
        WordLadderResult result1 = controller.wordLadder("rudy", "ruru", TOKEN);
        assertEquals(-1, result1.status);
        assertNull(result1.result);
        WordLadderResult result2 = controller.wordLadder("guost", "boo", TOKEN);
        assertEquals(-1, result2.status);
        assertNull(result2.result);
        WordLadderResult result3 = controller.wordLadder("marty", "keith", TOKEN);
        assertEquals(-1, result3.status);
        assertNull(result3.result);
    }
}
