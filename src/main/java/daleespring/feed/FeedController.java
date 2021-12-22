package daleespring.feed;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/feed/*")
public class FeedController {

    //list
    @RequestMapping("list")
    public String feedList(Model model){

        model.addAttribute("name", "dalee");
        return "feed/feed_list";
    }

    //detail
    @RequestMapping (value = "detail")
    public String feedDetail(Model model){

        model.addAttribute("name", "dalee");
        return "feed/feed_detail";
    }

    //add
    @RequestMapping(value = "add")
    public String feedAdd(Model model){

        model.addAttribute("name", "dalee");
        return "feed/feed_detail";
    }
}
