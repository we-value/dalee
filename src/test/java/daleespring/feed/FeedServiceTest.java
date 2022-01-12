package daleespring.feed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.beans.FeatureDescriptor;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class FeedServiceTest {

    @Autowired
    FeedService feedService;
    @Autowired
    FeedRepository feedRepository;

    @Test
    public void saveFeed(){
        //given
        Feed feed = new Feed();
        feed.setTitle("테스트 제목");
        feed.setContent("테스트 내용");
        feed.setReservationDate(LocalDateTime.now());
        feed.setMoodColor(MoodColor.red);

        //when
        Long feedId = feedService.saveFeed(feed);

        //then
        Feed findFeed = feedService.findByIdFeed(feedId);
        assertThat(feed.getFeedId()).isEqualTo(findFeed.getFeedId());
    }

    @Test
    public void 피드_검색() {
        Feed feed = new Feed();
        feed.setTitle("테스트 제목");
        feed.setContent("테스트 내용");
        feed.setReservationDate(LocalDateTime.now());
        feed.setMoodColor(MoodColor.yellow);
        feedService.saveFeed(feed);

        Feed result = feedService.findByIdFeed(feed.getFeedId());

        assertThat(result).isEqualTo(feed);
    }

    @Test
    public void 피드_전체_검색() {
        Feed feed1 = new Feed();
        feed1.setTitle("테스트 제목1");
        feed1.setContent("테스트 내용1");
        feed1.setReservationDate(LocalDateTime.now());
        feed1.setMoodColor(MoodColor.yellow);
        feedService.saveFeed(feed1);

        Feed feed2 = new Feed();
        feed2.setTitle("테스트 제목2");
        feed2.setContent("테스트 내용2");
        feed2.setReservationDate(LocalDateTime.now());
        feed2.setMoodColor(MoodColor.green);
        feedService.saveFeed(feed2);

        List<Feed> result = feedService.findByAllFeed();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void 피드_수정() {
        Feed feed = new Feed();
        feed.setTitle("테스트 제목");
        feed.setContent("테스트 내용");
        feed.setReservationDate(LocalDateTime.now());
        feed.setMoodColor(MoodColor.yellow);
        Long saveFeedId = feedService.saveFeed(feed);

        FeedModifyForm feedModifyForm = new FeedModifyForm();
        feedModifyForm.setTitle("제목 수정");
        feedModifyForm.setContent("내용 수정");
        feedModifyForm.setReservationDate(LocalDateTime.now());
        feedModifyForm.setMoodColor(MoodColor.red);
        feedService.editFeed(saveFeedId, feedModifyForm.getTitle(), feedModifyForm.getContent(), feedModifyForm.getReservationDate(), feedModifyForm.getMoodColor());

        Feed result = feedService.findByIdFeed(saveFeedId);

        assertThat(result.getTitle()).isEqualTo(feedModifyForm.getTitle());
    }
}