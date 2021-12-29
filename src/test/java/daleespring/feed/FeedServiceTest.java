package daleespring.feed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
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
    public void Feed_저장(){
        //given
        Feed feed = new Feed();
        feed.setTitle("테스트 제목");
        feed.setContent("테스트 내용");
        feed.setMoodColor(FeedMoodColor.red);
        feed.setReservationDate(LocalDateTime.now());
        feed.setWDate(LocalDateTime.now());

        //when
        Long feedId = feedService.saveFeed(feed);

        //then
        Feed findFeed = feedService.findByIdFeed(feedId).get();
        assertThat(feed.getFeedId()).isEqualTo(findFeed.getFeedId());
    }

    @Test
    public void 피드_검색() {
        Feed feed = new Feed();
        feed.setTitle("테스트 제목");
        feedService.saveFeed(feed);

        Feed result = feedService.findByIdFeed(feed.getFeedId()).get();

        assertThat(result).isEqualTo(feed);
    }

    @Test
    public void 피드_전체_검색() {
        Feed feed1 = new Feed();
        feed1.setTitle("테스트 제목1");
        feedService.saveFeed(feed1);

        Feed feed2 = new Feed();
        feed2.setTitle("테스트 제목2");
        feedService.saveFeed(feed2);

        List<Feed> result = feedService.findByAllFeed();

        assertThat(result.size()).isEqualTo(2);
    }
}