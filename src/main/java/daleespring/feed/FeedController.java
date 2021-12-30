package daleespring.feed;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "feed/")
public class FeedController {

    private final FeedService feedService;

    @GetMapping("list")
    public String feedList(Model model){
        log.info(" === " + getClass() + " === " + "예시 log");

        model.addAttribute("feedList", feedService.findByAllFeed());
        return "feed/feed_list";
    }

    @GetMapping(value = "add")
    public String feedAdd(Model model){

        model.addAttribute("feedAddForm", new FeedAddForm());
        return "feed/feed_add";
    }

    @PostMapping(value = "add")
    public String feedAdd(@Valid FeedAddForm feedForm, BindingResult feedFromBindingResult){

        if (feedFromBindingResult.hasErrors()) {
            return "feed/feed_add";
        }

        Feed feed = new Feed();
        feed.setTitle(feedForm.getTitle());
        feed.setContent(feedForm.getContent());
        feed.setReservationDate(feedForm.getReservationDate());
        feed.setMoodColor(feedForm.getMoodColor());

        feedService.saveFeed(feed);
        return "redirect:/feed/list";
    }

    //modify 수정
    //remove 삭제
}
