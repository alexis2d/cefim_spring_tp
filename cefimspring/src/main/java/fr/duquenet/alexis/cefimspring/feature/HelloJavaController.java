package fr.duquenet.alexis.cefimspring.feature;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/hello")
public class HelloJavaController {

    @GetMapping(value = "/world", produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloWorld() {
        return "Hello World";
    }

}
