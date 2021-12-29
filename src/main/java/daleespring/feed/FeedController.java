package daleespring.feed;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "feed/")
public class FeedController {

    private final FeedService feedService;

    @GetMapping("list")
    public String feedList(){
        log.info(" === " + getClass() + " === " + "예시 log");

        return "feed/feed_list";
    }

    @GetMapping(value = "add")
    public String feedAdd(Model model){

        model.addAttribute("feedAddForm", new FeedAddForm());
        model.addAttribute("feedMoodColor", FeedMoodColor.values());
        return "feed/feed_add";
    }

    @PostMapping(value = "add")
    public String feedAdd(FeedAddForm feedForm){


        return "redirect:/feed/list";
    }

    //modify 수정
    //remove 삭제
}
