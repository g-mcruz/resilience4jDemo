package org.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "helloClient", url = "localhost:8080")
public interface SleepClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sleep/{time}")
    String getSleep(@PathVariable("time") long time);
}
