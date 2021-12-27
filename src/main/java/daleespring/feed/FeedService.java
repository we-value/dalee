package daleespring.feed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    @Transactional
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
