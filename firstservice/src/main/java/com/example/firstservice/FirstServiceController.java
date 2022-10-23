package com.example.firstservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.netty.http.server.HttpServerRequest;

@RestController
@RequestMapping("/first-service")
@RequiredArgsConstructor
@Slf4j
public class FirstServiceController {

    private final Environment env;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome first-service";
    }
    @GetMapping("/message")
    public String message(@RequestHeader("first-request")String header){
        log.info(header);
        return "Hello World in First Service";
    }

    @GetMapping("/check")
    public String check(HttpServerRequest request){
        log.info("Server port = {}", request.hostAddress().getPort());
        return String.format("Hi, there. This is a message from First Service on PORT %s"
                , env.getProperty("local.server.port"));
    }
}
