package daleespring.feed;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaFeedRepository implements FeedRepository{

    private final EntityManager entityManager;

    public JpaFeedRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Feed saveFeed(Feed feed) {
        entityManager.persist(feed);
        return feed;
    }

    @Override
    public Optional<Feed> findByIdFeed(Long feedId) {
        return Optional.ofNullable(entityManager.find(Feed.class, feedId));
    }

    @Override
    public List<Feed> findByAllFeed() {
        return entityManager.createQuery("select f from Feed f", Feed.class).getResultList();
    }
}
