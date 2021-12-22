package daleespring.feed;

import java.util.List;
import java.util.Optional;

public interface FeedRepository {
    Feed save(Feed feed);
    Optional<Feed> findById(Long feedId);
    List<Feed> findByAll();
}
