package nl.hu.bep3.jobboard.jobs.core.ports.storage;

import nl.hu.bep3.jobboard.jobs.core.domain.Job;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

/*
    Docs: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.repositories
    Custom queries with @Query, see: https://stackabuse.com/spring-data-mongodb-guide-to-the-query-annotation/
 */
public interface JobRepository extends MongoRepository<Job, UUID> {
    List<Job> findByKeywordsEquals(String keyword, Sort sort);
}
