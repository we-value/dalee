package daleespring.feed;

import java.util.*;

public class MemoryFeedRepository implements FeedRepository{

    private static Map<Long, Feed> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Feed saveFeed(Feed feed) {
        feed.setFeedId(++sequence);
        store.put(feed.getFeedId(), feed);
        return null;
    }

    @Override
    public Optional<Feed> findByIdFeed(Long feedId) {
        return Optional.ofNullable(store.get(feedId));
    }

    @Override
    public List<Feed> findByAllFeed() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}