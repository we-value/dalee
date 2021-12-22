package daleespring.feed;

import java.util.*;

public class MemoryFeedRepository implements FeedRepository{

    private static Map<Long, Feed> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Feed save(Feed feed) {
        feed.setFeedId(++sequence);
        store.put(feed.getFeedId(), feed);
        return null;
    }

    @Override
    public Optional<Feed> findById(Long feedId) {
        return Optional.ofNullable(store.get(feedId));
    }

    @Override
    public List<Feed> findByAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
