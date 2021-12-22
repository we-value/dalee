package daleespring.baseClass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "/")
public class HomeController {

    @GetMapping(value = "/")
    public String home(){

        return "home";
    }
}
