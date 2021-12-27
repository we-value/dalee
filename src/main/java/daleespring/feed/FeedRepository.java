package daleespring.feed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FeedRepository {

    private final EntityManager entityManager;

    public void saveFeed(Feed feed) {
        entityManager.persist(feed);
    }

    public Optional<Feed> findByIdFeed(Long feedId) {
        return Optional.ofNullable(entityManager.find(Feed.class, feedId));
    }

    public List<Feed> findByAllFeed() {
        return entityManager.createQuery("select f from Feed f", Feed.class).getResultList();
    }
}
