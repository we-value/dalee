package daleespring.feed;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryFeedRepositoryTest {

    MemoryFeedRepository memoryFeedRepository = new MemoryFeedRepository();

    @AfterEach
    public void afterEach(){
        memoryFeedRepository.clearStore();
    }

    @Test
    void save() {
        Feed feed = new Feed();
        feed.setTitle("테스트 제목");
        feed.setContent("테스트 내용");
        feed.setMoodColor(Color.red);
        feed.setReservationTime(LocalDateTime.now());
        feed.setwTime(LocalDateTime.now());

        memoryFeedRepository.save(feed);

        Feed result = memoryFeedRepository.findById(feed.getFeedId()).get();

        assertThat(feed).isEqualTo(result);
    }

    @Test
    void findById() {
        Feed feed = new Feed();
        feed.setTitle("테스트 제목");
        memoryFeedRepository.save(feed);

        Feed result = memoryFeedRepository.findById(feed.getFeedId()).get();

        assertThat(result).isEqualTo(feed);
    }

    @Test
    void findByAll() {
        Feed feed1 = new Feed();
        feed1.setTitle("테스트 제목1");
        memoryFeedRepository.save(feed1);

        Feed feed2 = new Feed();
        feed2.setTitle("테스트 제목2");
        memoryFeedRepository.save(feed2);

        List<Feed> result = memoryFeedRepository.findByAll();

        assertThat(result.size()).isEqualTo(2);
    }
}