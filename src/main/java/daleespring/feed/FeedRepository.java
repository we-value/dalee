package daleespring.feed;

import java.util.List;
import java.util.Optional;

public interface FeedRepository {
    Feed saveFeed(Feed feed);
    Optional<Feed> findByIdFeed(Long feedId);
    List<Feed> findByAllFeed();
}
