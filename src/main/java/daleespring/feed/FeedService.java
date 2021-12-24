package daleespring.feed;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class FeedService {

    private final FeedRepository feedRepository;

    public FeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public Long saveFeed(Feed feed){
        feedRepository.saveFeed(feed);
        return feed.getFeedId();
    }

    public Optional<Feed> findByIdFeed(Long feedId){
        return feedRepository.findByIdFeed(feedId);
    }

    public List<Feed> findByAllFeed(){
        return feedRepository.findByAllFeed();
    }
}
