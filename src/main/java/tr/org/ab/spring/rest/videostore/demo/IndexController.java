package tr.org.ab.spring.rest.videostore.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author Omer Ozkan
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/test")
    Object hello() {
        return Collections.singletonMap("message", "hello world");
    }

}
