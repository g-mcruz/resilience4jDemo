package org.example.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.feign.SleepClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResilienceController {

    private static final String SLEEP_SERVICE = "sleepService";
    private final SleepClient sleepClient;

    public ResilienceController(SleepClient sleepClient){
        this.sleepClient = sleepClient;
    }

    @GetMapping("/sleep/{time}")
    @CircuitBreaker(name = SLEEP_SERVICE,fallbackMethod ="subscribesFallbackMethod")
    public ResponseEntity<String> resilience(@PathVariable Long time){
        return new ResponseEntity<String>(sleepClient.getSleep(time), HttpStatus.OK);
    }

    public ResponseEntity<String> subscribesFallbackMethod(Exception e){
		return new ResponseEntity<String>("subscribe service is down", HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
