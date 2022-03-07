package ex.demo.Lang;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ctrl {
    @RequestMapping(value = "/hello")
    public String home(@RequestParam(value = "language", required = false) String  s, Model model){
        model.addAttribute("language", s);
        return "hello";
    }
}
