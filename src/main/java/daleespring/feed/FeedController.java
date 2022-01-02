package daleespring.feed;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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
    public String feedAdd(@Valid FeedAddForm feedAddForm, BindingResult feedFormBindingResult){

        if (feedFormBindingResult.hasErrors()) {
            return "feed/feed_add";
        }

        Feed feed = new Feed();
        feed.setTitle(feedAddForm.getTitle());
        feed.setContent(feedAddForm.getContent());
        feed.setReservationDate(feedAddForm.getReservationDate());
        feed.setMoodColor(feedAddForm.getMoodColor());

        feedService.saveFeed(feed);
        return "redirect:/feed/list";
    }

    @GetMapping(value = "{feedId}/modify")
    public String feedModify(@PathVariable("feedId") Long feedId, Model model){
        Feed modifyFeed = feedService.findByIdFeed(feedId);
        FeedModifyForm feedModifyForm = new FeedModifyForm();
        feedModifyForm.setTitle(modifyFeed.getTitle());
        feedModifyForm.setContent(modifyFeed.getContent());
        feedModifyForm.setMoodColor(modifyFeed.getMoodColor());
        feedModifyForm.setReservationDate(modifyFeed.getReservationDate());

        model.addAttribute("feedModifyForm", feedModifyForm);
        return "feed/feed_modify";
    }

    @PostMapping(value = "{feedId}/modify")
    public String feedModify(@PathVariable("feedId") Long feedId,
                             @ModelAttribute("feedModifyForm") @Valid FeedModifyForm feedModifyForm,
                             BindingResult feedFormBindingResult){

        if (feedFormBindingResult.hasErrors()) {
            return "feed/feed_modify";
        }

        feedService.editFeed(feedId, feedModifyForm.getTitle(), feedModifyForm.getContent(), feedModifyForm.getReservationDate(), feedModifyForm.getMoodColor());

        return "feed/feed_modify";
    }

    //remove 삭제
}
