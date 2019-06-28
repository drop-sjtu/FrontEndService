package org.dropsjtu.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class AuthController {
    private final static String TOKEN = "3535ce20-1b02-41fe-8e8b-e4ac5ab8d7c7";
    private final static AtomicInteger counter = new AtomicInteger(0);

    @PostMapping(value = "/login")
    public static AuthResult login(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "password") String password) {
        System.out.println(counter.get());
        counter.incrementAndGet();
        AuthResult ret = new AuthResult();
        if (username.equals("SE418") && password.equals("SE418")) {
            ret.setCode(0);
            ret.setToken(TOKEN);
        } else {
            ret.setCode(1);
        }
        return ret;
    }

    @GetMapping(value = "/check")
    public static int check(@RequestParam(value = "token") String token) {
        System.out.println(counter.get());
        counter.incrementAndGet();
        if (token.equals(TOKEN))
            return 1;
        else
            return 0;
    }
}
