package ex.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {

    @RequestMapping(value = "/hello-rest")
    public String HelloRest(){
        return "Hello World";
    }
}
