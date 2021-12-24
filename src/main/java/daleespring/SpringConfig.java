package daleespring;

import daleespring.feed.FeedRepository;
import daleespring.feed.FeedService;
import daleespring.feed.FeedRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager entityManager;

    @Autowired
    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public FeedService feedService(){
        return new FeedService(feedRepository());
    }

    @Bean
    public FeedRepository feedRepository(){
        return new FeedRepositoryJpa(entityManager);
    }
}