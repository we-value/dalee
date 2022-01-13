package daleespring.feed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public Long saveFeed(Feed feed){
        feedRepository.saveFeed(feed);
        return feed.getId();
    }

    public Feed findByIdFeed(Long feedId){
        return feedRepository.findByIdFeed(feedId);
    }

    public List<Feed> findByAllFeed(){
        return feedRepository.findByAllFeed();
    }

    @Transactional
    public void editFeed(Long feedId, String title, String content, LocalDateTime reservationDate, MoodColor moodColor){
        Feed findByIdFeed = feedRepository.findByIdFeed(feedId);
        findByIdFeed.editFeed(title, content, reservationDate, moodColor);
    }
}
