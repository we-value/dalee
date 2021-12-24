package daleespring.feed;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class FeedRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public Feed saveFeed(Feed feed) {
        entityManager.persist(feed);
        return feed;
    }

    public Optional<Feed> findByIdFeed(Long feedId) {
        return Optional.ofNullable(entityManager.find(Feed.class, feedId));
    }

    public List<Feed> findByAllFeed() {
        return entityManager.createQuery("select f from Feed f", Feed.class).getResultList();
    }
}
